/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.AssetMarketEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.JewelleryOrganization;
import Business.Organization.Organization;
import Business.Role.AssetAgentRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author prathameshnemade
 */
public class AssetJewelleryEditJPanel extends javax.swing.JPanel {

    EcoSystem ecosystem;
    UserAccount account;
    JSplitPane jSplitPane;
    JPanel browsingJPanel;
    Network ongoinNetwork;
    UserAccount selectedUser;
    Organization selectedOrganization;
    Integer selectedDelIndex;
    JewelleryOrganization selectedJewelery;
    ArrayList<JewelleryOrganization> allJewellery = new ArrayList<>();
    ArrayList<UserAccount> assetsAdminUser = new ArrayList<>();

    public AssetJewelleryEditJPanel(EcoSystem ecosystem, UserAccount account, JSplitPane jSplitPane, JPanel browsingJPanel) {
        this.ecosystem = ecosystem;
        this.account = account;
        this.jSplitPane = jSplitPane;
        this.browsingJPanel = browsingJPanel;
        initComponents();

        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            Network ongoing1 = this.ecosystem.getNetwork().getNetworkList().get(i);
            if (ongoing1.getIsSelected()) {
                ongoinNetwork = ongoing1;
            }
        }
        setAssetAdminUsers();

        _getData();
    }

    public void _getData() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (int i = 0; i < ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
            Enterprise ongoing = ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().get(i);
            if (ongoing instanceof AssetMarketEnterprise) {
                for (int j = 0; j < ongoing.getOrganizationDirectory().getOrganizationList().size(); j++) {

                    selectedOrganization = ongoing.getOrganizationDirectory().getOrganizationList().get(j);
                    if (selectedOrganization instanceof JewelleryOrganization) {
                        JewelleryOrganization ongoing2 = (JewelleryOrganization) selectedOrganization;
                        allJewellery.add(ongoing2);
                        for (HashMap.Entry<String, HashMap<String, Object>> set
                                : ongoing2.getJewelleries().entrySet()) {

                            Object[] row = {
                                ongoing2.getCompanyName(),
                                set.getKey(),
                                set.getValue().get("maxPrice"),
                                set.getValue().get("quantity"),
                                set.getValue().get("doc"),
                                ongoing2.getAdmin().getUsername().toString()
                            };
                            model.addRow(row);
                        }
                    }
                }
            }
        }
    }

    public void setAssetAdminUsers() {
        ArrayList<String> asset = new ArrayList<>();
        for (int i = 0; i < this.ecosystem.getUserAccountDirectory().getUserAccountList().size(); i++) {
            UserAccount ongoing = this.ecosystem.getUserAccountDirectory().getUserAccountList().get(i);
            if (ongoing.getRole() instanceof AssetAgentRole) {
                this.assetsAdminUser.add(ongoing);
                asset.add(ongoing.getUsername());
            }
        }
        String[] assetSDropdown = asset.toArray(new String[asset.size()]);
        DefaultComboBoxModel<String> brandSDropdownModel = new DefaultComboBoxModel<>(assetSDropdown);
        this.adminComboBox.setModel(brandSDropdownModel);
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
        deletejLabel = new javax.swing.JLabel();
        serialNoJLabel = new javax.swing.JLabel();
        compnayNameJField = new javax.swing.JTextField();
        brandJLabel1 = new javax.swing.JLabel();
        adminComboBox = new javax.swing.JComboBox<>();
        serialNoJLabel2 = new javax.swing.JLabel();
        jewelleryNameJField = new javax.swing.JTextField();
        serialNoJLabel1 = new javax.swing.JLabel();
        maxUnitJField = new javax.swing.JTextField();
        serialNoJLabel3 = new javax.swing.JLabel();
        priceJField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Company Name", "Price", "Units", "Date of creation", "Admin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        deletejLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/delete.png"))); // NOI18N
        deletejLabel.setText("Delete");
        deletejLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletejLabelMouseClicked(evt);
            }
        });

        serialNoJLabel.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel.setText("Company Name(*):");

        compnayNameJField.setBackground(new java.awt.Color(238, 238, 238));
        compnayNameJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        compnayNameJField.setText("Enter here");
        compnayNameJField.setToolTipText("Click to enter your name.");
        compnayNameJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        compnayNameJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                compnayNameJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                compnayNameJFieldnameChangeHandler(evt);
            }
        });
        compnayNameJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compnayNameJFieldActionPerformed(evt);
            }
        });

        brandJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brandJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        brandJLabel1.setText("Admin (*):");

        adminComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                adminComboBoxItemStateChanged(evt);
            }
        });
        adminComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adminComboBoxFocusGained(evt);
            }
        });
        adminComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminComboBoxActionPerformed(evt);
            }
        });
        adminComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                adminComboBoxPropertyChange(evt);
            }
        });

        serialNoJLabel2.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel2.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel2.setText("Jewellery Name(*):");

        jewelleryNameJField.setBackground(new java.awt.Color(238, 238, 238));
        jewelleryNameJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jewelleryNameJField.setText("Enter here");
        jewelleryNameJField.setToolTipText("Click to enter your name.");
        jewelleryNameJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        jewelleryNameJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jewelleryNameJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jewelleryNameJFieldnameChangeHandler(evt);
            }
        });
        jewelleryNameJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jewelleryNameJFieldActionPerformed(evt);
            }
        });

        serialNoJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel1.setText("Max Unit(*):");

        maxUnitJField.setBackground(new java.awt.Color(238, 238, 238));
        maxUnitJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        maxUnitJField.setText("Enter here");
        maxUnitJField.setToolTipText("Click to enter your name.");
        maxUnitJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        maxUnitJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                maxUnitJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                maxUnitJFieldnameChangeHandler(evt);
            }
        });
        maxUnitJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxUnitJFieldActionPerformed(evt);
            }
        });

        serialNoJLabel3.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel3.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel3.setText("Price(*):");

        priceJField.setBackground(new java.awt.Color(238, 238, 238));
        priceJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        priceJField.setText("Enter here");
        priceJField.setToolTipText("Click to enter your name.");
        priceJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        priceJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                priceJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                priceJFieldnameChangeHandler(evt);
            }
        });
        priceJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceJFieldActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(200, 203, 178));
        jButton1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(67, 100, 100));
        jButton1.setText("EDIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(serialNoJLabel)
                    .addComponent(brandJLabel1)
                    .addComponent(serialNoJLabel2)
                    .addComponent(serialNoJLabel1)
                    .addComponent(serialNoJLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deletejLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(priceJField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maxUnitJField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jewelleryNameJField, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                            .addComponent(compnayNameJField))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialNoJLabel)
                    .addComponent(compnayNameJField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandJLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jewelleryNameJField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serialNoJLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialNoJLabel1)
                    .addComponent(maxUnitJField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialNoJLabel3)
                    .addComponent(priceJField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletejLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void compnayNameJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_compnayNameJFieldFocusGained
        if (compnayNameJField.getText().equals("Enter here")) {
            compnayNameJField.setText("");
        }
    }//GEN-LAST:event_compnayNameJFieldFocusGained

    private void compnayNameJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_compnayNameJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_compnayNameJFieldnameChangeHandler

    private void compnayNameJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compnayNameJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_compnayNameJFieldActionPerformed

    private void adminComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_adminComboBoxItemStateChanged
        _adminChnageHandler();
    }//GEN-LAST:event_adminComboBoxItemStateChanged

    public void _adminChnageHandler() {
        selectedDelIndex = this.adminComboBox.getSelectedIndex();
        if (selectedDelIndex != -1) {
            this.selectedUser = this.assetsAdminUser.get(selectedDelIndex);
        }
    }
    private void adminComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminComboBoxFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_adminComboBoxFocusGained

    private void adminComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminComboBoxActionPerformed

    private void adminComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_adminComboBoxPropertyChange
        this._adminChnageHandler();
    }//GEN-LAST:event_adminComboBoxPropertyChange

    private void jewelleryNameJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jewelleryNameJFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jewelleryNameJFieldFocusGained

    private void jewelleryNameJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jewelleryNameJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_jewelleryNameJFieldnameChangeHandler

    private void jewelleryNameJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jewelleryNameJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jewelleryNameJFieldActionPerformed

    private void maxUnitJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_maxUnitJFieldFocusGained
        if (maxUnitJField.getText().equals("Enter here")) {
            maxUnitJField.setText("");
        }
    }//GEN-LAST:event_maxUnitJFieldFocusGained

    private void maxUnitJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_maxUnitJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_maxUnitJFieldnameChangeHandler

    private void maxUnitJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxUnitJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxUnitJFieldActionPerformed

    private void priceJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_priceJFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_priceJFieldFocusGained

    private void priceJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_priceJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_priceJFieldnameChangeHandler

    private void priceJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceJFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (selectedOrganization != null) {

            HashMap<String, HashMap<String, Object>> jewelleries = new HashMap<>();
            HashMap<String, Object> jewelName = new HashMap<>();
            jewelName.put("maxPrice", this.priceJField.getText().toString());
            jewelName.put("quantity", this.maxUnitJField.getText().toString());
            jewelName.put("doc", new Date());
            jewelleries.put(this.jewelleryNameJField.getText(), jewelName);
            selectedJewelery.setAdmin(this.selectedUser);
            selectedJewelery.setJewelleries(jewelleries);
            selectedJewelery.setCompanyName(this.compnayNameJField.getText());
            _getData();
            JOptionPane.showMessageDialog(this, "Jewellery udpated successfully!", "Jewellery", INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select Jewellery to delete !", "Jewellery", ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        Integer selectedIndex = this.jTable1.getSelectedRow();
        if (selectedIndex != -1) {
            selectedJewelery = this.allJewellery.get(selectedIndex);
            this.compnayNameJField.setText(selectedJewelery.getCompanyName());
            for (HashMap.Entry<String, HashMap<String, Object>> set
                    : selectedJewelery.getJewelleries().entrySet()) {

                this.adminComboBox.setSelectedItem(selectedJewelery.getAdmin().getUsername().toString());
                jewelleryNameJField.setText(set.getKey());
                maxUnitJField.setText(set.getValue().get("quantity").toString());
                priceJField.setText(set.getValue().get("maxPrice").toString());
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void deletejLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletejLabelMouseClicked
        if (selectedOrganization != null) {
            for (int i = 0; i < ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
                Enterprise ongoing = ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().get(i);
                if (ongoing instanceof AssetMarketEnterprise) {
                    ongoing.getOrganizationDirectory().getOrganizationList().remove(selectedOrganization);
                }
            }
            _getData();
            JOptionPane.showMessageDialog(this, "Jewellery deleted successfully!", "Jewellery", INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select Jewellery to delete !", "Jewellery", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deletejLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> adminComboBox;
    private javax.swing.JLabel brandJLabel1;
    private javax.swing.JTextField compnayNameJField;
    private javax.swing.JLabel deletejLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jewelleryNameJField;
    private javax.swing.JTextField maxUnitJField;
    private javax.swing.JTextField priceJField;
    private javax.swing.JLabel serialNoJLabel;
    private javax.swing.JLabel serialNoJLabel1;
    private javax.swing.JLabel serialNoJLabel2;
    private javax.swing.JLabel serialNoJLabel3;
    // End of variables declaration//GEN-END:variables
}
