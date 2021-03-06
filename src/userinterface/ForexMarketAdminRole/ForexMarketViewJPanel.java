/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ForexMarketAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.BanksOrganization;
import Business.Organization.BrokersOrganization;
import Business.Organization.Organization;
import Business.Role.AssetAgentRole;
import Business.Role.ForexAgentRole;
import Business.UserAccount.UserAccount;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author ronak
 */
public class ForexMarketViewJPanel extends javax.swing.JPanel {

    EcoSystem ecosystem;
    UserAccount account;
    JSplitPane jSplitPane;
    JPanel browsingJPanel;

    /**
     * Creates new form ForexMarketViewJPanel
     */
    public ForexMarketViewJPanel(EcoSystem ecosystem, UserAccount account, JSplitPane jSplitPane, JPanel browsingJPanel) {

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
            if (!(this.account.getRole() instanceof ForexAgentRole) && ongoing != null) {
                if (ongoing.getEnterpriseDirectory().getEnterpriseSelection().get("ForexMarket") != null && ongoing.getEnterpriseDirectory().getEnterpriseSelection().get("ForexMarket").get("Banks")) {//Banks
                    ForexBankJPanel forexBankJpanel = new ForexBankJPanel(ecosystem, account, jSplitPane, browsingJPanel);
                    forexJTabbedPane.addTab("Banks", forexBankJpanel);

                };
                if (ongoing.getEnterpriseDirectory().getEnterpriseSelection().get("ForexMarket") != null && ongoing.getEnterpriseDirectory().getEnterpriseSelection().get("ForexMarket").get("Brokers")) {//Brokers
                    ForexBrokerJPanel forexBrokerPanel = new ForexBrokerJPanel(ecosystem, account, jSplitPane, browsingJPanel);
                    forexJTabbedPane.addTab("Brokers", forexBrokerPanel);

                };
            } else {
                if (ongoing.getEnterpriseDirectory().getEnterpriseSelection().get("ForexMarket") != null && ongoing.getEnterpriseDirectory().getEnterpriseSelection().get("ForexMarket").get("Banks")) {
                    for (int i = 0; i < ongoing.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
                        Enterprise temp = ongoing.getEnterpriseDirectory().getEnterpriseDir().get(i);
                        for (int j = 0; j < temp.getOrganizationDirectory().getOrganizationList().size(); j++) {
                            Organization temp1 = temp.getOrganizationDirectory().getOrganizationList().get(j);
                            if (temp1 instanceof BanksOrganization) {
                                if (((BanksOrganization) temp1).getAdmin().getUsername().toString() == this.account.getUsername().toString()) {
                                    ForexBankJPanel forexBankJpanel = new ForexBankJPanel(ecosystem, account, jSplitPane, browsingJPanel);
                                    forexJTabbedPane.addTab("Banks", forexBankJpanel);
                                }
                            }
                        }
                    }
                };
                if (ongoing.getEnterpriseDirectory().getEnterpriseSelection().get("ForexMarket") != null && ongoing.getEnterpriseDirectory().getEnterpriseSelection().get("ForexMarket").get("Brokers")) {
                    for (int i = 0; i < ongoing.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
                        Enterprise temp = ongoing.getEnterpriseDirectory().getEnterpriseDir().get(i);
                        for (int j = 0; j < temp.getOrganizationDirectory().getOrganizationList().size(); j++) {
                            Organization temp1 = temp.getOrganizationDirectory().getOrganizationList().get(j);
                            if (temp1 instanceof BrokersOrganization) {
                                if (((BrokersOrganization) temp1).getAdmin().getUsername().toString() == this.account.getUsername().toString()) {
                                    ForexBrokerJPanel forexBrokerPanel = new ForexBrokerJPanel(ecosystem, account, jSplitPane, browsingJPanel);
                                    forexJTabbedPane.addTab("Brokers", forexBrokerPanel);
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

        forexJTabbedPane = new javax.swing.JTabbedPane();

        forexJTabbedPane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(forexJTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(forexJTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane forexJTabbedPane;
    // End of variables declaration//GEN-END:variables
}
