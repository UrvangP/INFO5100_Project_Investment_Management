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
import Business.Organization.IndustriesOrganization;
import Business.Organization.JewelleryOrganization;
import Business.Organization.Organization;
import Business.Organization.RealEstateOrganization;
import Business.Role.CustomerRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AssetBuyWorkRequest;
import Business.WorkQueue.AssetSellWorkRequest;
import Business.WorkQueue.WorkRequest;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author prathameshnemade
 */
public class SystemAdminDashboard extends javax.swing.JPanel {

    EcoSystem ecosystem;
    UserAccount account;
    JSplitPane jSplitPane;
    JPanel browsingJPanel;

    SystemAdminDashboard(EcoSystem ecosystem, UserAccount account, JSplitPane jSplitPane, JPanel browsingJPanel) {
        initComponents();
        this.ecosystem = ecosystem;
        this.account = account;
        this.jSplitPane = jSplitPane;
        this.browsingJPanel = browsingJPanel;
        _populateTree();
        _getdata();
    }

    public void _populateTree() {
        DefaultMutableTreeNode assets = new DefaultMutableTreeNode("network");

        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            Network ongoing = this.ecosystem.getNetwork().getNetworkList().get(i);
            DefaultMutableTreeNode temp = new DefaultMutableTreeNode(ongoing.getNName());
            assets.add(temp);
            for (int j = 0; j < ongoing.getEnterpriseDirectory().getEnterpriseDir().size(); j++) {
                Enterprise temp1 = ongoing.getEnterpriseDirectory().getEnterpriseDir().get(j);
                if (temp1 instanceof AssetMarketEnterprise) {
                    AssetMarketEnterprise temp2 = (AssetMarketEnterprise) temp1;
                    DefaultMutableTreeNode assetTemp = new DefaultMutableTreeNode("Asset Market");
                    temp.add(assetTemp);
                    for (int k = 0; k < temp2.getOrganizationDirectory().getOrganizationList().size(); k++) {
                        Organization temp3 = temp2.getOrganizationDirectory().getOrganizationList().get(k);
                        if (temp3 instanceof IndustriesOrganization) {
                            DefaultMutableTreeNode nameTemp = new DefaultMutableTreeNode(((IndustriesOrganization) temp3).getCompanyName().toString());
                            assetTemp.add(nameTemp);
                        } else if (temp3 instanceof JewelleryOrganization) {
                            DefaultMutableTreeNode nameTemp = new DefaultMutableTreeNode(((JewelleryOrganization) temp3).getCompanyName().toString());
                            assetTemp.add(nameTemp);
                        } else if (temp3 instanceof RealEstateOrganization) {
                            DefaultMutableTreeNode nameTemp = new DefaultMutableTreeNode(((RealEstateOrganization) temp3).getCompanyName().toString());
                            assetTemp.add(nameTemp);
                        }
                    }

                } else if (temp1 instanceof CryptoMarketEnterprise) {
                    CryptoMarketEnterprise temp2 = (CryptoMarketEnterprise) temp1;
                    DefaultMutableTreeNode cryptoTemp = new DefaultMutableTreeNode("Crypto Market");
                    temp.add(cryptoTemp);
                    DefaultMutableTreeNode nameTemp = new DefaultMutableTreeNode(temp2.name.toString());
                    cryptoTemp.add(nameTemp);
                } else if (temp1 instanceof ForexMarketEnterprise) {
                    ForexMarketEnterprise temp2 = (ForexMarketEnterprise) temp1;
                    DefaultMutableTreeNode forexTemp = new DefaultMutableTreeNode("Forex Market");
                    temp.add(forexTemp);
                    DefaultMutableTreeNode nameTemp = new DefaultMutableTreeNode(temp2.name.toString());
                    forexTemp.add(nameTemp);
                } else if (temp1 instanceof StockMarketEnterprise) {
                    StockMarketEnterprise temp2 = (StockMarketEnterprise) temp1;
                    DefaultMutableTreeNode stockTemp = new DefaultMutableTreeNode("Stock Market");
                    temp.add(stockTemp);
                    DefaultMutableTreeNode nameTemp = new DefaultMutableTreeNode(temp2.name.toString());
                    nameTemp.add(nameTemp);
                }
            }
        }

        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(assets));
    }

    public void _getdata() {
        Integer networks = 0;
        Integer totalUsers = 0;
        Integer totalCustomers = 0;
        Integer investments = 0;
        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            networks += 1;
        }
        for (int i = 0; i < this.ecosystem.getUserAccountDirectory().getUserAccountList().size(); i++) {
            totalUsers += 1;
            UserAccount temp = this.ecosystem.getUserAccountDirectory().getUserAccountList().get(i);
            if (temp.getRole() instanceof CustomerRole) {
                totalCustomers += 1;
            }
        }
        for (int i = 0; i < this.ecosystem.getWorkQueue().getWorkRequestList().size(); i++) {
            WorkRequest temp = this.ecosystem.getWorkQueue().getWorkRequestList().get(i);
            if (temp instanceof AssetBuyWorkRequest) {
                investments += ((AssetBuyWorkRequest) temp).getPrice() * ((AssetBuyWorkRequest) temp).getQuantity();
            } else if (temp instanceof AssetSellWorkRequest) {
                investments -= ((AssetSellWorkRequest) temp).getPrice() * ((AssetSellWorkRequest) temp).getQuantity();
            }
        }

        this.totalNetwrokJLabel.setText(networks.toString());
        this.totalInvestmentsJLabel.setText(investments.toString());
        this.totalUsers.setText(totalUsers.toString());
        this.totalCustBoardedJLabel.setText(totalCustomers.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        totalNetwrokJLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        totalCustBoardedJLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        totalUsers = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        totalInvestmentsJLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        jPanel1.setBackground(new java.awt.Color(67, 100, 100));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 15, 10, 15));
        jPanel1.setPreferredSize(new java.awt.Dimension(385, 190));

        jLabel3.setFont(new java.awt.Font("Noto Sans Myanmar", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("No. of Networks");

        totalNetwrokJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 60)); // NOI18N
        totalNetwrokJLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalNetwrokJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalNetwrokJLabel.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalNetwrokJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalNetwrokJLabel)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(67, 100, 100));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 15, 10, 15));
        jPanel2.setPreferredSize(new java.awt.Dimension(385, 190));

        jLabel6.setFont(new java.awt.Font("Noto Sans Myanmar", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("No. of Customers boarded");

        totalCustBoardedJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 60)); // NOI18N
        totalCustBoardedJLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalCustBoardedJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalCustBoardedJLabel.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                    .addComponent(totalCustBoardedJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalCustBoardedJLabel)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(67, 100, 100));
        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 15, 10, 15));
        jPanel4.setPreferredSize(new java.awt.Dimension(385, 190));

        jLabel8.setFont(new java.awt.Font("Noto Sans Myanmar", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Total Users:");

        totalUsers.setFont(new java.awt.Font("Lucida Grande", 0, 60)); // NOI18N
        totalUsers.setForeground(new java.awt.Color(255, 255, 255));
        totalUsers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalUsers.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                    .addComponent(totalUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalUsers)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(67, 100, 100));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 15, 10, 15));
        jPanel3.setPreferredSize(new java.awt.Dimension(385, 190));

        jLabel7.setFont(new java.awt.Font("Noto Sans Myanmar", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Total Investments:");

        totalInvestmentsJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 60)); // NOI18N
        totalInvestmentsJLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalInvestmentsJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalInvestmentsJLabel.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                    .addComponent(totalInvestmentsJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalInvestmentsJLabel)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("JTree");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("network");
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(jTree1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel totalCustBoardedJLabel;
    private javax.swing.JLabel totalInvestmentsJLabel;
    private javax.swing.JLabel totalNetwrokJLabel;
    private javax.swing.JLabel totalUsers;
    // End of variables declaration//GEN-END:variables
}
