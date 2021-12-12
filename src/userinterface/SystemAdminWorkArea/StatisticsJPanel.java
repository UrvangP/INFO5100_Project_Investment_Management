/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.AssetMarketEnterprise;
import Business.Enterprise.CryptoMarketEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ForexMarketEnterprise;
import Business.Enterprise.StockMarketEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AssetBuyWorkRequest;
import Business.WorkQueue.AssetSellWorkRequest;
import Business.WorkQueue.CryptoBuyWorkRequest;
import Business.WorkQueue.CryptoSellWorkRequest;
import Business.WorkQueue.ForexBuyWorkRequest;
import Business.WorkQueue.ForexSellWorkRequest;
import Business.WorkQueue.StockBuyWorkQueue;
import Business.WorkQueue.StockSellWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.BorderLayout;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author prathameshnemade
 */
public class StatisticsJPanel extends javax.swing.JPanel {

    EcoSystem ecosystem;
    UserAccount account;
    JSplitPane jSplitPane;
    JPanel browsingJPanel;

    public StatisticsJPanel(EcoSystem ecosystem, UserAccount account, JSplitPane jSplitPane, JPanel browsingJPanel) {
        initComponents();
        this.ecosystem = ecosystem;
        this.account = account;
        this.jSplitPane = jSplitPane;
        this.browsingJPanel = browsingJPanel;

        statistics1();
    }

    public void statistics1() {
        CategoryDataset dataset = statistics1CreateDataset();
        JFreeChart chart = ChartFactory.createBarChart(
                "Organizations in each Network",
                "Networks",
                "Total Companies",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );
        ChartPanel myChart = new ChartPanel(chart);
        jPanel.setLayout(new java.awt.BorderLayout());
        jPanel.add(myChart, BorderLayout.CENTER);
        jPanel.validate();
    }

    private CategoryDataset statistics1CreateDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            Network ongoing = this.ecosystem.getNetwork().getNetworkList().get(i);
            Integer asset = 0;
            Integer stock = 0;
            Integer forex = 0;
            Integer crypto = 0;
            for (int j = 0; j < ongoing.getEnterpriseDirectory().getEnterpriseDir().size(); j++) {
                Enterprise ongoing1 = ongoing.getEnterpriseDirectory().getEnterpriseDir().get(j);
                if (ongoing1 instanceof AssetMarketEnterprise) {
                    AssetMarketEnterprise temp1 = (AssetMarketEnterprise) ongoing1;
                    for (int k = 0; k < temp1.getOrganizationDirectory().getOrganizationList().size(); k++) {
                        Organization temp2 = temp1.getOrganizationDirectory().getOrganizationList().get(k);
                        asset += 1;
//                        if (temp2 instanceof IndustriesOrganization) {
//                            
//                        } else if (temp2 instanceof JewelleryOrganization) {
//
//                        } else if (temp2 instanceof RealEstateOrganization) {
//
//                        }
                    }
                } else if (ongoing1 instanceof CryptoMarketEnterprise) {
                    CryptoMarketEnterprise temp1 = (CryptoMarketEnterprise) ongoing1;
                    for (int k = 0; k < temp1.getOrganizationDirectory().getOrganizationList().size(); k++) {
                        Organization temp2 = temp1.getOrganizationDirectory().getOrganizationList().get(k);
                        crypto += 1;
                    }
                } else if (ongoing1 instanceof ForexMarketEnterprise) {
                    ForexMarketEnterprise temp1 = (ForexMarketEnterprise) ongoing1;
                    for (int k = 0; k < temp1.getOrganizationDirectory().getOrganizationList().size(); k++) {
                        Organization temp2 = temp1.getOrganizationDirectory().getOrganizationList().get(k);
                        forex += 1;
                    }

                } else if (ongoing1 instanceof StockMarketEnterprise) {
                    StockMarketEnterprise temp1 = (StockMarketEnterprise) ongoing1;
                    for (int k = 0; k < temp1.getOrganizationDirectory().getOrganizationList().size(); k++) {
                        Organization temp2 = temp1.getOrganizationDirectory().getOrganizationList().get(k);
                        crypto += 1;
                    }
                }
            }
            dataset.addValue(asset, "Asset", ongoing.getNName().toString());
            dataset.addValue(stock, "Stock", ongoing.getNName().toString());
            dataset.addValue(crypto, "Crypto", ongoing.getNName().toString());
            dataset.addValue(forex, "Forex", ongoing.getNName().toString());
        }

        return dataset;
    }

    public void statistics2() {
        CategoryDataset dataset = statistics2CreateDataset();
        JFreeChart chart = ChartFactory.createBarChart(
                "Investments in each Market",
                "Markets",
                "Investments",
                dataset,
                PlotOrientation.HORIZONTAL,
                true, true, false
        );
        ChartPanel myChart = new ChartPanel(chart);
        jPanel.setLayout(new java.awt.BorderLayout());
        jPanel.add(myChart, BorderLayout.CENTER);
        jPanel.validate();
    }

    private CategoryDataset statistics2CreateDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Integer temp1 = 0;
        Integer temp2 = 0;
        Integer temp3 = 0;
        Integer temp4 = 0;
        Integer temp5 = 0;
        Integer temp6 = 0;
        Integer temp7 = 0;
        Integer temp8 = 0;
        for (int i = 0; i < this.ecosystem.getWorkQueue().getWorkRequestList().size(); i++) {
            WorkRequest ongoing = this.ecosystem.getWorkQueue().getWorkRequestList().get(i);
            if (ongoing instanceof AssetBuyWorkRequest) {
                temp1 += ((AssetBuyWorkRequest) ongoing).getPrice() * ((AssetBuyWorkRequest) ongoing).getQuantity();
            } else if (ongoing instanceof AssetSellWorkRequest) {
                temp2 += ((AssetSellWorkRequest) ongoing).getPrice() * ((AssetSellWorkRequest) ongoing).getQuantity();
            } else if (ongoing instanceof CryptoBuyWorkRequest) {
                temp3 += ((CryptoBuyWorkRequest) ongoing).getPrice() * ((CryptoBuyWorkRequest) ongoing).getQuantity();
            } else if (ongoing instanceof CryptoSellWorkRequest) {
                temp4 += ((CryptoSellWorkRequest) ongoing).getPrice() * ((CryptoSellWorkRequest) ongoing).getQuantity();
            } else if (ongoing instanceof ForexBuyWorkRequest) {
                temp5 += ((ForexBuyWorkRequest) ongoing).getPrice() * ((ForexBuyWorkRequest) ongoing).getQuantity();
            } else if (ongoing instanceof ForexSellWorkRequest) {
                temp6 += ((ForexSellWorkRequest) ongoing).getPrice() * ((ForexSellWorkRequest) ongoing).getQuantity();
            } else if (ongoing instanceof StockBuyWorkQueue) {
                temp7 += ((StockBuyWorkQueue) ongoing).getPrice() * ((StockBuyWorkQueue) ongoing).getQuantity();
            } else if (ongoing instanceof StockSellWorkRequest) {
                temp8 += ((StockSellWorkRequest) ongoing).getPrice() * ((StockSellWorkRequest) ongoing).getQuantity();
            }

        }

        dataset.addValue(temp1, "Buy", "Asset Market");
        dataset.addValue(temp2, "Sell", "Asset Market");

        dataset.addValue(temp3, "Buy", "Crypto Market");
        dataset.addValue(temp4, "Sell", "Crypto Market");

        dataset.addValue(temp5, "Buy", "Forex Market");
        dataset.addValue(temp6, "Sell", "Forex Market");

        dataset.addValue(temp5, "Buy", "Stock Market");
        dataset.addValue(temp6, "Sell", "Stock Market");
        return dataset;
    }

    public void statistics3() {
        PieDataset dataset = createDataset();

        // Create chart  
        JFreeChart chart = ChartFactory.createPieChart(
                "Organizations in each Enterprises",
                dataset,
                true,
                true,
                false);

        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);

        ChartPanel panel = new ChartPanel(chart);
        jPanel.setLayout(new java.awt.BorderLayout());
        jPanel.add(panel, BorderLayout.CENTER);
        jPanel.validate();
    }

    private PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            Network ongoing = this.ecosystem.getNetwork().getNetworkList().get(i);
            for (int j = 0; j < ongoing.getEnterpriseDirectory().getEnterpriseDir().size(); j++) {
                Integer total = 0;
                Enterprise ongoing1 = ongoing.getEnterpriseDirectory().getEnterpriseDir().get(j);
                String ongoingName = "";
                if (ongoing1 instanceof AssetMarketEnterprise) {
                    AssetMarketEnterprise temp1 = (AssetMarketEnterprise) ongoing1;
                    ongoingName = "Asset Market";
                    for (int k = 0; k < temp1.getOrganizationDirectory().getOrganizationList().size(); k++) {
                        Organization temp2 = temp1.getOrganizationDirectory().getOrganizationList().get(k);
                        total += 1;
                    }
                } else if (ongoing1 instanceof CryptoMarketEnterprise) {
                    ongoingName = "Crypto Market";
                    CryptoMarketEnterprise temp1 = (CryptoMarketEnterprise) ongoing1;
                    for (int k = 0; k < temp1.getOrganizationDirectory().getOrganizationList().size(); k++) {
                        Organization temp2 = temp1.getOrganizationDirectory().getOrganizationList().get(k);
                        total += 1;
                    }
                } else if (ongoing1 instanceof ForexMarketEnterprise) {
                    ongoingName = "Forex Market";
                    ForexMarketEnterprise temp1 = (ForexMarketEnterprise) ongoing1;
                    for (int k = 0; k < temp1.getOrganizationDirectory().getOrganizationList().size(); k++) {
                        Organization temp2 = temp1.getOrganizationDirectory().getOrganizationList().get(k);
                        total += 1;
                    }

                } else if (ongoing1 instanceof StockMarketEnterprise) {
                    ongoingName = "Stock Market";
                    StockMarketEnterprise temp1 = (StockMarketEnterprise) ongoing1;
                    for (int k = 0; k < temp1.getOrganizationDirectory().getOrganizationList().size(); k++) {
                        Organization temp2 = temp1.getOrganizationDirectory().getOrganizationList().get(k);
                        total += 1;
                    }
                }

                dataset.setValue(ongoingName, total);
            }

        }
        return dataset;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("BACK");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jButton1.setText("Investments Statistics");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Network Statistics");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Organization Statistics");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(100, 100, 100))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        SystemAdminDashboard createAdmin = new SystemAdminDashboard(ecosystem, account, jSplitPane, browsingJPanel);
        this.jSplitPane.setRightComponent(createAdmin);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        statistics1();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        statistics2();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        statistics3();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel;
    // End of variables declaration//GEN-END:variables
}
