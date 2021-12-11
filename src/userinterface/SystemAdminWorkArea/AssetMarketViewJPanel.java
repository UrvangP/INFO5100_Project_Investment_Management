/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.IndustriesOrganization;
import Business.Organization.JewelleryOrganization;
import Business.Organization.Organization;
import Business.Organization.RealEstateOrganization;
import Business.Role.AssetAgentRole;
import Business.UserAccount.UserAccount;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author prathameshnemade
 */
public class AssetMarketViewJPanel extends javax.swing.JPanel {

    EcoSystem ecosystem;
    UserAccount account;
    JSplitPane jSplitPane;
    JPanel browsingJPanel;
    String isAssetAgent;

    public AssetMarketViewJPanel(EcoSystem ecosystem, UserAccount account, JSplitPane jSplitPane, JPanel browsingJPanel) {
        this.ecosystem = ecosystem;
        this.account = account;
        this.jSplitPane = jSplitPane;
        this.browsingJPanel = browsingJPanel;
        initComponents();

        Network ongoing = null;

        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            Network ongoing1 = this.ecosystem.getNetwork().getNetworkList().get(i);
            if (ongoing1.getIsSelected()) {
                ongoing = ongoing1;
            }
        }

        if (ongoing != null) {
            if (!(this.account.getRole() instanceof AssetAgentRole) && ongoing != null) {

                if (ongoing.getEnterpriseDirectory().getEnterpriseSelection().get("AssetMarket") != null && ongoing.getEnterpriseDirectory().getEnterpriseSelection().get("AssetMarket").get("Industries")) {
                    AssetIndustiesJPanel industriesPanel = new AssetIndustiesJPanel(ecosystem, account, jSplitPane, browsingJPanel);
                    assetJTabbedPane.addTab("Industries", industriesPanel);
                };
                if (ongoing.getEnterpriseDirectory().getEnterpriseSelection().get("AssetMarket") != null && ongoing.getEnterpriseDirectory().getEnterpriseSelection().get("AssetMarket").get("RealEstate")) {
                    AssetRealEstateJPanel realEstatePanel = new AssetRealEstateJPanel(ecosystem, account, jSplitPane, browsingJPanel);
                    assetJTabbedPane.addTab("Real Estate", realEstatePanel);
                };
                if (ongoing.getEnterpriseDirectory().getEnterpriseSelection().get("AssetMarket") != null && ongoing.getEnterpriseDirectory().getEnterpriseSelection().get("AssetMarket").get("Jewellery")) {

                    AssetJewelleryJPanel jewellery = new AssetJewelleryJPanel(ecosystem, account, jSplitPane, browsingJPanel);
                    assetJTabbedPane.addTab("Jewellery", jewellery);
                };
            } else {
                if (ongoing.getEnterpriseDirectory().getEnterpriseSelection().get("AssetMarket") != null && ongoing.getEnterpriseDirectory().getEnterpriseSelection().get("AssetMarket").get("Industries")) {
                    for (int i = 0; i < ongoing.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
                        Enterprise temp = ongoing.getEnterpriseDirectory().getEnterpriseDir().get(i);
                        for (int j = 0; j < temp.getOrganizationDirectory().getOrganizationList().size(); j++) {
                            Organization temp1 = temp.getOrganizationDirectory().getOrganizationList().get(j);
                            if (temp1 instanceof IndustriesOrganization) {
                                if (((IndustriesOrganization) temp1).getAdmin().getUsername().toString() == this.account.getUsername().toString()) {
                                    AssetIndustiesJPanel industriesPanel = new AssetIndustiesJPanel(ecosystem, account, jSplitPane, browsingJPanel);
                                    assetJTabbedPane.addTab("Industries", industriesPanel);
                                }
                            }
                        }
                    }
                };
                if (ongoing.getEnterpriseDirectory().getEnterpriseSelection().get("AssetMarket") != null && ongoing.getEnterpriseDirectory().getEnterpriseSelection().get("AssetMarket").get("RealEstate")) {
                    for (int i = 0; i < ongoing.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
                        Enterprise temp = ongoing.getEnterpriseDirectory().getEnterpriseDir().get(i);
                        for (int j = 0; j < temp.getOrganizationDirectory().getOrganizationList().size(); j++) {
                            Organization temp1 = temp.getOrganizationDirectory().getOrganizationList().get(j);
                            if (temp1 instanceof RealEstateOrganization) {
                                if (((RealEstateOrganization) temp1).getAdmin().getUsername().toString() == this.account.getUsername().toString()) {
                                    AssetRealEstateJPanel realEstatePanel = new AssetRealEstateJPanel(ecosystem, account, jSplitPane, browsingJPanel);
                                    assetJTabbedPane.addTab("Real Estate", realEstatePanel);
                                }
                            }
                        }
                    }
                };
                if (ongoing.getEnterpriseDirectory().getEnterpriseSelection().get("AssetMarket") != null && ongoing.getEnterpriseDirectory().getEnterpriseSelection().get("AssetMarket").get("Jewellery")) {
                    for (int i = 0; i < ongoing.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
                        Enterprise temp = ongoing.getEnterpriseDirectory().getEnterpriseDir().get(i);
                        for (int j = 0; j < temp.getOrganizationDirectory().getOrganizationList().size(); j++) {
                            Organization temp1 = temp.getOrganizationDirectory().getOrganizationList().get(j);
                            if (temp1 instanceof JewelleryOrganization) {
                                if (((JewelleryOrganization) temp1).getAdmin().getUsername().toString() == this.account.getUsername().toString()) {
                                    AssetJewelleryJPanel jewellery = new AssetJewelleryJPanel(ecosystem, account, jSplitPane, browsingJPanel);
                                    assetJTabbedPane.addTab("Jewellery", jewellery);
                                }
                            }
                        }
                    }

                };
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please create an enterprise first!", "Setup", ERROR_MESSAGE);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        assetJTabbedPane = new javax.swing.JTabbedPane();

        setBackground(new java.awt.Color(255, 255, 255));

        assetJTabbedPane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(assetJTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(assetJTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane assetJTabbedPane;
    // End of variables declaration//GEN-END:variables
}
