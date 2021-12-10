/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AssetAgentRole;

import Business.EcoSystem;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import userinterface.SystemAdminWorkArea.AssetMarketViewJPanel;

/**
 *
 * @author prathameshnemade
 */
public class AssetAgentJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    EcoSystem ecosystem;
    UserAccount account;
    JPanel browsingJPanel;
    ArrayList<Network> allNetworks = new ArrayList<>();
    Network selectedNetwork;

    public AssetAgentJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem ecosystem, JPanel browsingJPanel) {
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.account = account;
        this.browsingJPanel = browsingJPanel;
        initComponents();
        this.userNameJLabel.setText(account.getUsername());

        getNetwork();
    }

    public void getNetwork() {
        ArrayList<String> asset = new ArrayList<>();
        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            Network ongoing1 = this.ecosystem.getNetwork().getNetworkList().get(i);
            asset.add(ongoing1.getNName());
            this.allNetworks.add(ongoing1);
        }
        String[] netwrokSDropdown = asset.toArray(new String[asset.size()]);
        DefaultComboBoxModel<String> brandSDropdownModel = new DefaultComboBoxModel<>(netwrokSDropdown);
        this.networkComboBox.setModel(brandSDropdownModel);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        industryJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        userNameJLabel = new javax.swing.JLabel();
        networkComboBox = new javax.swing.JComboBox<>();
        brandJLabel1 = new javax.swing.JLabel();
        industryJButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        homeButton.setBackground(new java.awt.Color(200, 203, 178));
        homeButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        homeButton.setForeground(new java.awt.Color(67, 100, 100));
        homeButton.setText("Home");
        homeButton.setBorder(null);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        industryJButton.setBackground(new java.awt.Color(200, 203, 178));
        industryJButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        industryJButton.setForeground(new java.awt.Color(67, 100, 100));
        industryJButton.setText("Market");
        industryJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industryJButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Noto Sans Oriya", 0, 36)); // NOI18N
        jLabel2.setText("Hello,");

        userNameJLabel.setFont(new java.awt.Font("Noto Sans Oriya", 1, 36)); // NOI18N
        userNameJLabel.setText("System Admin!");

        networkComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                networkComboBoxItemStateChanged(evt);
            }
        });
        networkComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                networkComboBoxFocusGained(evt);
            }
        });
        networkComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkComboBoxActionPerformed(evt);
            }
        });
        networkComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                networkComboBoxPropertyChange(evt);
            }
        });

        brandJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brandJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        brandJLabel1.setText("Select Network (*):");

        industryJButton1.setBackground(new java.awt.Color(200, 203, 178));
        industryJButton1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        industryJButton1.setForeground(new java.awt.Color(67, 100, 100));
        industryJButton1.setText("Requests");
        industryJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industryJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(industryJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(homeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(networkComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(industryJButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(brandJLabel1)
                            .addComponent(jLabel2)
                            .addComponent(userNameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(userNameJLabel)
                .addGap(18, 18, 18)
                .addComponent(brandJLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(networkComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(industryJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(industryJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );

        jSplitPane.setLeftComponent(jPanel1);

        jLabel3.setText("DASHBOARD");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel3)
                .addContainerGap(381, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel3)
                .addContainerGap(499, Short.MAX_VALUE))
        );

        jSplitPane.setRightComponent(jPanel3);

        add(jSplitPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        AssetAgentDashboardJPanel assetAgentDashboardJPanel = new AssetAgentDashboardJPanel(ecosystem, account, jSplitPane, browsingJPanel);
        this.jSplitPane.setRightComponent(assetAgentDashboardJPanel);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void industryJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industryJButtonActionPerformed
        AssetMarketViewJPanel assetAgentRealEstateJPanel = new AssetMarketViewJPanel(ecosystem, account, jSplitPane, browsingJPanel);
        this.jSplitPane.setRightComponent(assetAgentRealEstateJPanel);
    }//GEN-LAST:event_industryJButtonActionPerformed

    private void networkComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_networkComboBoxItemStateChanged
        _adminChnageHandler();
    }//GEN-LAST:event_networkComboBoxItemStateChanged

    private void networkComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_networkComboBoxFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_networkComboBoxFocusGained

    private void networkComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_networkComboBoxActionPerformed

    private void networkComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_networkComboBoxPropertyChange
        this._adminChnageHandler();
    }//GEN-LAST:event_networkComboBoxPropertyChange

    private void industryJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industryJButton1ActionPerformed
        AssetAgentStatusJPanel assetAgentStatusJPanel = new AssetAgentStatusJPanel(ecosystem, account, jSplitPane, browsingJPanel);
        this.jSplitPane.setRightComponent(assetAgentStatusJPanel);
    }//GEN-LAST:event_industryJButton1ActionPerformed

    public void _adminChnageHandler() {
        Integer selectedDelIndex = this.networkComboBox.getSelectedIndex();
        if (selectedDelIndex != -1) {
            this.selectedNetwork = this.allNetworks.get(selectedDelIndex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brandJLabel1;
    private javax.swing.JButton homeButton;
    private javax.swing.JButton industryJButton;
    private javax.swing.JButton industryJButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JComboBox<String> networkComboBox;
    private javax.swing.JLabel userNameJLabel;
    // End of variables declaration//GEN-END:variables
}
