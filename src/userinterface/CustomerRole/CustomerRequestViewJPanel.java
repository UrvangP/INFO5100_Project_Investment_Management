/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import Business.EcoSystem;
import Business.Network.Network;
import Business.Organization.IndustriesOrganization;
import Business.Organization.JewelleryOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AssetBuyWorkRequest;
import Business.WorkQueue.WorkRequest;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author prathameshnemade
 */
public class CustomerRequestViewJPanel extends javax.swing.JPanel {

    JSplitPane jSplitPane;
    UserAccount account;
    EcoSystem ecosystem;
    Network selectedNetwork;

    public CustomerRequestViewJPanel(EcoSystem ecosystem, UserAccount account, JSplitPane jSplitPane, Network selectedNetwork) {
        this.jSplitPane = jSplitPane;
        this.account = account;
        this.ecosystem = ecosystem;
        this.selectedNetwork = selectedNetwork;
        initComponents();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (int i = 0; i < this.ecosystem.getWorkQueue().getWorkRequestList().size(); i++) {
            WorkRequest ongoing = this.ecosystem.getWorkQueue().getWorkRequestList().get(i);
            if (ongoing instanceof AssetBuyWorkRequest) {
                AssetBuyWorkRequest temp = (AssetBuyWorkRequest) ongoing;
                Object[] row = {
                    temp.getOraganization() instanceof IndustriesOrganization ? "Industries" : temp.getOraganization() instanceof JewelleryOrganization ? "Jewellery" : "Real Estate",
                    temp.getCompanyName(),
                    temp.getQuantity(),
                    temp.getPrice(),
                    temp.getModifiedAt(),
                    temp.getStatusType()
                };
                model.addRow(row);
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Market Type", "Company Name", "Unit", "Price", "Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
