/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.StockMarketAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author urvang
 */
public class stockMarketDashboard extends javax.swing.JPanel {

    /**
     * Creates new form stockMarketDashboard
     */
    EcoSystem ecosystem;
    UserAccount account;
    JSplitPane jSplitPane;
    JPanel browsingJPanel;
    Network ongoing;
    
    public stockMarketDashboard(EcoSystem ecosystem, UserAccount account, JSplitPane jSplitPane, JPanel browsingJPanel) {
        
        this.ecosystem = ecosystem;
        this.account = account;
        this.jSplitPane = jSplitPane;
        this.browsingJPanel = browsingJPanel;
        
        initComponents();
        
        this.ongoing = null;

        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            Network ongoing1 = this.ecosystem.getNetwork().getNetworkList().get(i);
            if (ongoing1.getIsSelected()) {
                ongoing = ongoing1;
            }
        }
        
        parseList();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        paneNavigation = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lsOrganizationNames = new javax.swing.JList<>();
        lbCreateCompany = new javax.swing.JLabel();
        paneContent = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        lsOrganizationNames2 = new javax.swing.JList<>();
        lbCreateCompany1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTabbedPane1PropertyChange(evt);
            }
        });

        jSplitPane2.setBackground(new java.awt.Color(255, 255, 255));
        jSplitPane2.setDividerLocation(200);

        paneNavigation.setBackground(new java.awt.Color(255, 255, 255));

        lsOrganizationNames.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lsOrganizationNames.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lsOrganizationNamesPropertyChange(evt);
            }
        });
        jScrollPane6.setViewportView(lsOrganizationNames);

        lbCreateCompany.setFont(new java.awt.Font("Zapf Dingbats", 1, 14)); // NOI18N
        lbCreateCompany.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/create.png"))); // NOI18N
        lbCreateCompany.setText(" Create Company");
        lbCreateCompany.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lbCreateCompanyFocusGained(evt);
            }
        });
        lbCreateCompany.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCreateCompanyMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout paneNavigationLayout = new javax.swing.GroupLayout(paneNavigation);
        paneNavigation.setLayout(paneNavigationLayout);
        paneNavigationLayout.setHorizontalGroup(
            paneNavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneNavigationLayout.createSequentialGroup()
                .addGroup(paneNavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addComponent(lbCreateCompany, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        paneNavigationLayout.setVerticalGroup(
            paneNavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneNavigationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbCreateCompany)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane2.setLeftComponent(paneNavigation);

        paneContent.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout paneContentLayout = new javax.swing.GroupLayout(paneContent);
        paneContent.setLayout(paneContentLayout);
        paneContentLayout.setHorizontalGroup(
            paneContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        paneContentLayout.setVerticalGroup(
            paneContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 722, Short.MAX_VALUE)
        );

        jSplitPane2.setRightComponent(paneContent);

        jTabbedPane1.addTab("Companies", jSplitPane2);

        jSplitPane1.setBackground(new java.awt.Color(255, 255, 255));
        jSplitPane1.setDividerLocation(220);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lsOrganizationNames2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane8.setViewportView(lsOrganizationNames2);

        lbCreateCompany1.setFont(new java.awt.Font("Zapf Dingbats", 1, 14)); // NOI18N
        lbCreateCompany1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/create.png"))); // NOI18N
        lbCreateCompany1.setText(" Create Mutual Fund");
        lbCreateCompany1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lbCreateCompany1FocusGained(evt);
            }
        });
        lbCreateCompany1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCreateCompany1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbCreateCompany1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(395, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(339, 339, 339)
                    .addComponent(lbCreateCompany1)
                    .addContainerGap(339, Short.MAX_VALUE)))
        );

        jSplitPane1.setLeftComponent(jPanel3);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 703, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel8);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Mutual Funds", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbCreateCompanyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbCreateCompanyFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_lbCreateCompanyFocusGained

    private void lbCreateCompanyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCreateCompanyMouseClicked
        companyOrganizationPanel companyPanel = new companyOrganizationPanel(ecosystem, account, jSplitPane, browsingJPanel);
        jSplitPane2.setRightComponent(companyPanel);
    }//GEN-LAST:event_lbCreateCompanyMouseClicked

    private void lsOrganizationNamesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lsOrganizationNamesPropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_lsOrganizationNamesPropertyChange

    private void jTabbedPane1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1PropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTabbedPane1PropertyChange

    private void lbCreateCompany1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbCreateCompany1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_lbCreateCompany1FocusGained

    private void lbCreateCompany1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCreateCompany1MouseClicked
        // TODO add your handling code here:
        mutualFundsOrganizationPanel companyPanel = new mutualFundsOrganizationPanel(ecosystem, account, jSplitPane, browsingJPanel);
        jSplitPane1.setRightComponent(companyPanel);
    }//GEN-LAST:event_lbCreateCompany1MouseClicked

    private void parseList(){
        EnterpriseDirectory ep = ongoing.getEnterpriseDirectory();
        ArrayList<Organization> orgs = ep.getEnterprise(0).getOrganizationDirectory().getOrganizationList();
        
        ArrayList<String> listData= new ArrayList();
        ArrayList<String> listData1= new ArrayList();
        
        for(int i=0; i<orgs.size(); i++){
            if(orgs.get(i).getType().equals(Organization.Type.Companies.getValue())){
                listData.add(orgs.get(i).getName());
            }
            if(orgs.get(i).getType().equals(Organization.Type.MutualFunds.getValue())){
                listData1.add(orgs.get(i).getName());
            }
        }
        
        String[] liData = new String[listData.size()];
        String[] liData1 = new String[listData.size()];
        
        for(int i=0; i<listData.size(); i++){
            liData[i] = listData.get(i);
        }
        
        for(int i=0; i<listData1.size(); i++){
            liData1[i] = listData1.get(i);
        }
        
        lsOrganizationNames.setListData(liData);
        lsOrganizationNames2.setListData(liData1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList4;
    private javax.swing.JList<String> jList5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbCreateCompany;
    private javax.swing.JLabel lbCreateCompany1;
    private javax.swing.JList<String> lsOrganizationNames;
    private javax.swing.JList<String> lsOrganizationNames2;
    private javax.swing.JPanel paneContent;
    private javax.swing.JPanel paneNavigation;
    private javax.swing.JLabel viewJLabel1;
    private javax.swing.JLabel viewJLabel2;
    private javax.swing.JLabel viewJLabel3;
    private javax.swing.JLabel viewJLabel4;
    private javax.swing.JLabel viewJLabel5;
    // End of variables declaration//GEN-END:variables
}
