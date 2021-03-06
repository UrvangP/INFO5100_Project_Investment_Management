/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import Business.EcoSystem;
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
import javax.swing.JSplitPane;

/**
 *
 * @author prathameshnemade
 */
public class CustomerDashboardJPanel extends javax.swing.JPanel {

    EcoSystem system;
    UserAccount account;
    JSplitPane jSplitPane;

    public CustomerDashboardJPanel(EcoSystem system, UserAccount account, JSplitPane jSplitPane) {
        initComponents();
        this.system = system;
        this.account = account;
        this.jSplitPane = jSplitPane;

        getTotalInvestments();
    }

    public void getTotalInvestments() {
        Integer stocks = 0;
        Integer assets = 0;
        Integer forex = 0;
        Integer crypto = 0;

        for (int i = 0; i < this.system.getWorkQueue().getWorkRequestList().size(); i++) {
            WorkRequest ongoing = this.system.getWorkQueue().getWorkRequestList().get(i);
            if (ongoing instanceof AssetBuyWorkRequest && (((AssetBuyWorkRequest) ongoing).getStatusType() == AssetBuyWorkRequest.StatusType.Completed || ((AssetBuyWorkRequest) ongoing).getStatusType() == AssetBuyWorkRequest.StatusType.Sold)) {
                AssetBuyWorkRequest temp = (AssetBuyWorkRequest) ongoing;
                assets += temp.getQuantity() * temp.getPrice();
            } else if (ongoing instanceof AssetSellWorkRequest && ((AssetSellWorkRequest) ongoing).getStatusType() == AssetSellWorkRequest.StatusType.Sold) {
                AssetSellWorkRequest temp = (AssetSellWorkRequest) ongoing;
                assets -= temp.getQuantity() * temp.getPrice();
            }
        }

        for (int i = 0; i < this.system.getWorkQueue().getWorkRequestList().size(); i++) {
            WorkRequest ongoing = this.system.getWorkQueue().getWorkRequestList().get(i);
            if (ongoing instanceof ForexBuyWorkRequest && (((ForexBuyWorkRequest) ongoing).getStatusType() == ForexBuyWorkRequest.StatusType.Completed || ((ForexBuyWorkRequest) ongoing).getStatusType() == ForexBuyWorkRequest.StatusType.Sold)) {
                ForexBuyWorkRequest temp = (ForexBuyWorkRequest) ongoing;
                forex += temp.getQuantity() * temp.getPrice();
            } else if (ongoing instanceof ForexSellWorkRequest && ((ForexSellWorkRequest) ongoing).getStatusType() == ForexSellWorkRequest.StatusType.Sold) {
                ForexSellWorkRequest temp = (ForexSellWorkRequest) ongoing;
                forex -= temp.getQuantity() * temp.getPrice();
            }
        }

        for (int i = 0; i < this.system.getWorkQueue().getWorkRequestList().size(); i++) {
            WorkRequest ongoing = this.system.getWorkQueue().getWorkRequestList().get(i);
            if (ongoing instanceof StockBuyWorkQueue && (((StockBuyWorkQueue) ongoing).getStatusType() == StockBuyWorkQueue.StatusType.Completed || ((StockBuyWorkQueue) ongoing).getStatusType() == StockBuyWorkQueue.StatusType.Sold)) {
                StockBuyWorkQueue temp = (StockBuyWorkQueue) ongoing;
                stocks += temp.getPrice();
            } else if (ongoing instanceof StockSellWorkRequest && ((StockSellWorkRequest) ongoing).getStatusType() == StockSellWorkRequest.StatusType.Sold) {
                StockSellWorkRequest temp = (StockSellWorkRequest) ongoing;
                stocks -= temp.getPrice();
            }
        }

        for (int i = 0; i < this.system.getWorkQueue().getWorkRequestList().size(); i++) {
            WorkRequest ongoing = this.system.getWorkQueue().getWorkRequestList().get(i);
            if (ongoing instanceof CryptoBuyWorkRequest && (((CryptoBuyWorkRequest) ongoing).getStatusType() == CryptoBuyWorkRequest.StatusType.Completed || ((CryptoBuyWorkRequest) ongoing).getStatusType() == CryptoBuyWorkRequest.StatusType.Sold)) {
                CryptoBuyWorkRequest temp = (CryptoBuyWorkRequest) ongoing;
                crypto += temp.getPrice();
            } else if (ongoing instanceof CryptoSellWorkRequest && ((CryptoSellWorkRequest) ongoing).getStatusType() == CryptoSellWorkRequest.StatusType.Sold) {
                CryptoSellWorkRequest temp = (CryptoSellWorkRequest) ongoing;
                crypto -= temp.getPrice();
            }
        }

        this.totalOrdersJLabel.setText(assets.toString());
        this.totalOrdersJLabel2.setText(stocks.toString());
        this.totalOrdersJLabel1.setText(forex.toString());
        this.totalOrdersJLabel3.setText(crypto.toString());
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
        totalOrdersJLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        totalOrdersJLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        totalOrdersJLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        totalOrdersJLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(67, 100, 100));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 15, 10, 15));
        jPanel1.setPreferredSize(new java.awt.Dimension(385, 190));

        jLabel3.setFont(new java.awt.Font("Noto Sans Myanmar", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Total Asset Market Investments:");

        totalOrdersJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 60)); // NOI18N
        totalOrdersJLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalOrdersJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalOrdersJLabel.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalOrdersJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalOrdersJLabel)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(67, 100, 100));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 15, 10, 15));
        jPanel2.setPreferredSize(new java.awt.Dimension(385, 190));

        jLabel4.setFont(new java.awt.Font("Noto Sans Myanmar", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Total Forex Market Investments:");

        totalOrdersJLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 60)); // NOI18N
        totalOrdersJLabel1.setForeground(new java.awt.Color(255, 255, 255));
        totalOrdersJLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalOrdersJLabel1.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalOrdersJLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalOrdersJLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(67, 100, 100));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 15, 10, 15));
        jPanel3.setPreferredSize(new java.awt.Dimension(385, 190));

        jLabel5.setFont(new java.awt.Font("Noto Sans Myanmar", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Total Stock Market Investments:");

        totalOrdersJLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 60)); // NOI18N
        totalOrdersJLabel2.setForeground(new java.awt.Color(255, 255, 255));
        totalOrdersJLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalOrdersJLabel2.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalOrdersJLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalOrdersJLabel2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(67, 100, 100));
        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 15, 10, 15));
        jPanel4.setPreferredSize(new java.awt.Dimension(385, 190));

        jLabel6.setFont(new java.awt.Font("Noto Sans Myanmar", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Total Crypto Market Investments:");

        totalOrdersJLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 60)); // NOI18N
        totalOrdersJLabel3.setForeground(new java.awt.Color(255, 255, 255));
        totalOrdersJLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalOrdersJLabel3.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalOrdersJLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalOrdersJLabel3)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel totalOrdersJLabel;
    private javax.swing.JLabel totalOrdersJLabel1;
    private javax.swing.JLabel totalOrdersJLabel2;
    private javax.swing.JLabel totalOrdersJLabel3;
    // End of variables declaration//GEN-END:variables
}
