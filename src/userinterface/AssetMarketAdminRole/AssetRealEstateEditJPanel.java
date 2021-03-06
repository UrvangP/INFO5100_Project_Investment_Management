/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AssetMarketAdminRole;

import Business.EcoSystem;
import Business.Enterprise.AssetMarketEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.RealEstateOrganization;
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
public class AssetRealEstateEditJPanel extends javax.swing.JPanel {

    EcoSystem ecosystem;
    UserAccount account;
    JSplitPane jSplitPane;
    JPanel browsingJPanel;
    Network ongoinNetwork;
    UserAccount selectedUser;
    Organization selectedOrganization;
    Integer selectedDelIndex;
    RealEstateOrganization selectedRealEstate;
    ArrayList<RealEstateOrganization> allEstates = new ArrayList<>();
    ArrayList<UserAccount> assetsAdminUser = new ArrayList<>();

    public AssetRealEstateEditJPanel(EcoSystem ecosystem, UserAccount account, JSplitPane jSplitPane, JPanel browsingJPanel) {
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
                    if (selectedOrganization instanceof RealEstateOrganization) {
                        RealEstateOrganization ongoing2 = (RealEstateOrganization) selectedOrganization;
                        allEstates.add(ongoing2);
                        for (HashMap.Entry<String, HashMap<String, Object>> set
                                : ongoing2.getEstates().entrySet()) {

                            Object[] row = {
                                ongoing2.getCompanyName(),
                                set.getKey(),
                                set.getValue().get("maxPrice"),
                                set.getValue().get("quantity"),
                                set.getValue().get("doc"),
                                ongoing2.getAdmin().getUsername().toString(),
                                set.getValue().get("area"),
                                set.getValue().get("location"),};
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
        this.realestateComboBox.setModel(brandSDropdownModel);
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
        realestateNameJField = new javax.swing.JTextField();
        brandJLabel1 = new javax.swing.JLabel();
        realestateComboBox = new javax.swing.JComboBox<>();
        serialNoJLabel2 = new javax.swing.JLabel();
        nameJField = new javax.swing.JTextField();
        serialNoJLabel1 = new javax.swing.JLabel();
        realestateUnitJField = new javax.swing.JTextField();
        serialNoJLabel3 = new javax.swing.JLabel();
        realestateJField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        serialNoJLabel4 = new javax.swing.JLabel();
        realestateLocationJField = new javax.swing.JTextField();
        serialNoJLabel5 = new javax.swing.JLabel();
        realestateAreaJField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Company Name", "Real Estate Name", "Price", "Units", "Date of creation", "Admin", "Area", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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

        realestateNameJField.setBackground(new java.awt.Color(238, 238, 238));
        realestateNameJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        realestateNameJField.setText("Enter here");
        realestateNameJField.setToolTipText("Click to enter your name.");
        realestateNameJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        realestateNameJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                realestateNameJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                realestateNameJFieldnameChangeHandler(evt);
            }
        });
        realestateNameJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realestateNameJFieldActionPerformed(evt);
            }
        });

        brandJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brandJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        brandJLabel1.setText("Admin (*):");

        realestateComboBox.setEnabled(false);
        realestateComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                realestateComboBoxItemStateChanged(evt);
            }
        });
        realestateComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                realestateComboBoxFocusGained(evt);
            }
        });
        realestateComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realestateComboBoxActionPerformed(evt);
            }
        });
        realestateComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                realestateComboBoxPropertyChange(evt);
            }
        });

        serialNoJLabel2.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel2.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel2.setText(" Name(*):");

        nameJField.setBackground(new java.awt.Color(238, 238, 238));
        nameJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nameJField.setText("Enter here");
        nameJField.setToolTipText("Click to enter your name.");
        nameJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        nameJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameJFieldnameChangeHandler(evt);
            }
        });
        nameJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJFieldActionPerformed(evt);
            }
        });

        serialNoJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel1.setText("Max Unit(*):");

        realestateUnitJField.setBackground(new java.awt.Color(238, 238, 238));
        realestateUnitJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        realestateUnitJField.setText("Enter here");
        realestateUnitJField.setToolTipText("Click to enter your name.");
        realestateUnitJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        realestateUnitJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                realestateUnitJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                realestateUnitJFieldnameChangeHandler(evt);
            }
        });
        realestateUnitJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realestateUnitJFieldActionPerformed(evt);
            }
        });

        serialNoJLabel3.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel3.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel3.setText("Price(*):");

        realestateJField.setBackground(new java.awt.Color(238, 238, 238));
        realestateJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        realestateJField.setText("Enter here");
        realestateJField.setToolTipText("Click to enter your name.");
        realestateJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        realestateJField.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                realestateJFieldHierarchyChanged(evt);
            }
        });
        realestateJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                realestateJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                realestateJFieldnameChangeHandler(evt);
            }
        });
        realestateJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realestateJFieldActionPerformed(evt);
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

        serialNoJLabel4.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel4.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel4.setText("Location (*):");

        realestateLocationJField.setBackground(new java.awt.Color(238, 238, 238));
        realestateLocationJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        realestateLocationJField.setText("Enter here");
        realestateLocationJField.setToolTipText("Click to enter your name.");
        realestateLocationJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        realestateLocationJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                realestateLocationJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                realestateLocationJFieldnameChangeHandler(evt);
            }
        });
        realestateLocationJField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                realestateLocationJFieldMouseClicked(evt);
            }
        });
        realestateLocationJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realestateLocationJFieldActionPerformed(evt);
            }
        });

        serialNoJLabel5.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel5.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel5.setText("Area (*):");

        realestateAreaJField1.setBackground(new java.awt.Color(238, 238, 238));
        realestateAreaJField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        realestateAreaJField1.setText("Enter here");
        realestateAreaJField1.setToolTipText("Click to enter your name.");
        realestateAreaJField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        realestateAreaJField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                realestateAreaJField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                realestateAreaJField1nameChangeHandler(evt);
            }
        });
        realestateAreaJField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                realestateAreaJField1MouseClicked(evt);
            }
        });
        realestateAreaJField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realestateAreaJField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("sq. ft.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(serialNoJLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(serialNoJLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(serialNoJLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(serialNoJLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(brandJLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(serialNoJLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deletejLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(realestateNameJField)
                            .addComponent(realestateComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameJField)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(realestateLocationJField, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(realestateAreaJField1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(realestateUnitJField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(serialNoJLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(realestateJField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(133, 133, 133)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialNoJLabel)
                    .addComponent(realestateNameJField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(realestateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandJLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameJField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serialNoJLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(realestateLocationJField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serialNoJLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialNoJLabel5)
                    .addComponent(realestateAreaJField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialNoJLabel1)
                    .addComponent(realestateUnitJField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serialNoJLabel3)
                    .addComponent(realestateJField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletejLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void realestateNameJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_realestateNameJFieldFocusGained
        if (realestateNameJField.getText().equals("Enter here")) {
            realestateNameJField.setText("");
        }
    }//GEN-LAST:event_realestateNameJFieldFocusGained

    private void realestateNameJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_realestateNameJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateNameJFieldnameChangeHandler

    private void realestateNameJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realestateNameJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateNameJFieldActionPerformed

    private void realestateComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_realestateComboBoxItemStateChanged
        _adminChnageHandler();
    }//GEN-LAST:event_realestateComboBoxItemStateChanged

    public void _adminChnageHandler() {
        selectedDelIndex = this.realestateComboBox.getSelectedIndex();
        if (selectedDelIndex != -1) {
            this.selectedUser = this.assetsAdminUser.get(selectedDelIndex);
        }
    }
    private void realestateComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_realestateComboBoxFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateComboBoxFocusGained

    private void realestateComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realestateComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateComboBoxActionPerformed

    private void realestateComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_realestateComboBoxPropertyChange
        this._adminChnageHandler();
    }//GEN-LAST:event_realestateComboBoxPropertyChange

    private void nameJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameJFieldFocusGained
        if (this.nameJField.getText().equals("Enter here")) {
            nameJField.setText("");
        }
    }//GEN-LAST:event_nameJFieldFocusGained

    private void nameJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_nameJFieldnameChangeHandler

    private void nameJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameJFieldActionPerformed

    private void realestateUnitJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_realestateUnitJFieldFocusGained
        if (realestateUnitJField.getText().equals("Enter here")) {
            realestateUnitJField.setText("");
        }
    }//GEN-LAST:event_realestateUnitJFieldFocusGained

    private void realestateUnitJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_realestateUnitJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateUnitJFieldnameChangeHandler

    private void realestateUnitJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realestateUnitJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateUnitJFieldActionPerformed

    private void realestateJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_realestateJFieldFocusGained
        if (this.realestateJField.getText().equals("Enter here")) {
            realestateJField.setText("");
        }
    }//GEN-LAST:event_realestateJFieldFocusGained

    private void realestateJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_realestateJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateJFieldnameChangeHandler

    private void realestateJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realestateJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateJFieldActionPerformed

    public Boolean validateItem() {
        String errorMEssage = "";
        if (this.realestateComboBox.getSelectedItem() == null) {
            errorMEssage += "Select Admin to proceed! \n";
        }
        if (!this.realestateNameJField.getText().matches("[a-zA-Z0-9]+")) {
            errorMEssage += "Invalid Real Estate Company Name! \n";
        }
        if (!this.realestateAreaJField1.getText().matches("[0-9]+")) {
            errorMEssage += "Invalid Real Estate Area should be a number! \n";
        }
        if (!this.realestateLocationJField.getText().matches("[a-zA-Z0-9]+")) {
            errorMEssage += "Invalid Location Name! \n";
        }

        if (!this.nameJField.getText().matches("[a-zA-Z]+")) {
            errorMEssage += "Invalid Real Estate Name! \n";
        }
        if (!this.realestateUnitJField.getText().matches("[0-9]+")) {
            errorMEssage += "Real Estate Unit should be a number! \n";
        }
        if (!this.realestateJField.getText().matches("[0-9]+")) {
            errorMEssage += "Real Estate Price should be a number! \n";
        }
        if (errorMEssage.equals("")) {
            return true;
        }
        JOptionPane.showMessageDialog(this, errorMEssage, "Real Estate Edit", ERROR_MESSAGE);
        return false;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (selectedOrganization != null) {
            Boolean valid = validateItem();
            if (valid) {
                HashMap<String, HashMap<String, Object>> estates = new HashMap<>();
                HashMap<String, Object> estate = new HashMap<>();
                estate.put("maxPrice", this.realestateJField.getText().toString());
                estate.put("quantity", this.realestateUnitJField.getText().toString());
                estate.put("doc", new Date());
                estate.put("area", this.realestateAreaJField1.getText().toString());
                estate.put("location", this.realestateLocationJField.getText().toString());
                estates.put(this.nameJField.getText(), estate);
                selectedRealEstate.setAdmin(this.selectedUser);
                selectedRealEstate.setEstates(estates);
                selectedRealEstate.setCompanyName(this.realestateNameJField.getText());
                _getData();
                JOptionPane.showMessageDialog(this, "Real Estate udpated successfully!", "Real Estate", INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select Real Estate to update !", "Real Estate", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        Integer selectedIndex = this.jTable1.getSelectedRow();
        if (selectedIndex != -1) {
            selectedRealEstate = this.allEstates.get(selectedIndex);
            this.realestateNameJField.setText(selectedRealEstate.getCompanyName());
            for (HashMap.Entry<String, HashMap<String, Object>> set
                    : selectedRealEstate.getEstates().entrySet()) {

                this.realestateComboBox.setSelectedItem(selectedRealEstate.getAdmin().getUsername().toString());
                nameJField.setText(set.getKey());
                realestateUnitJField.setText(set.getValue().get("quantity").toString());
                realestateJField.setText(set.getValue().get("maxPrice").toString());
                realestateAreaJField1.setText(set.getValue().get("area").toString());
                realestateLocationJField.setText(set.getValue().get("location").toString());
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void deletejLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletejLabelMouseClicked
        if (selectedRealEstate != null) {
            for (int i = 0; i < ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
                Enterprise ongoing = ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().get(i);
                if (ongoing instanceof AssetMarketEnterprise) {
                    ongoing.getOrganizationDirectory().getOrganizationList().remove(selectedOrganization);
                }
            }
            _getData();
            JOptionPane.showMessageDialog(this, "Real Estate deleted successfully!", "Real Estate", INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select Real Estate to delete !", "Real Estate", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deletejLabelMouseClicked

    private void realestateJFieldHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_realestateJFieldHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateJFieldHierarchyChanged

    private void realestateLocationJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_realestateLocationJFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateLocationJFieldFocusGained

    private void realestateLocationJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_realestateLocationJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateLocationJFieldnameChangeHandler

    private void realestateLocationJFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_realestateLocationJFieldMouseClicked
        if (this.realestateLocationJField.getText().equals("Enter here")) {
            realestateLocationJField.setText("");
        }
    }//GEN-LAST:event_realestateLocationJFieldMouseClicked

    private void realestateLocationJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realestateLocationJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateLocationJFieldActionPerformed

    private void realestateAreaJField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_realestateAreaJField1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateAreaJField1FocusGained

    private void realestateAreaJField1nameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_realestateAreaJField1nameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateAreaJField1nameChangeHandler

    private void realestateAreaJField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_realestateAreaJField1MouseClicked
        if (this.realestateAreaJField1.getText().equals("Enter here")) {
            realestateAreaJField1.setText("");
        }
    }//GEN-LAST:event_realestateAreaJField1MouseClicked

    private void realestateAreaJField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realestateAreaJField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateAreaJField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brandJLabel1;
    private javax.swing.JLabel deletejLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameJField;
    private javax.swing.JTextField realestateAreaJField1;
    private javax.swing.JComboBox<String> realestateComboBox;
    private javax.swing.JTextField realestateJField;
    private javax.swing.JTextField realestateLocationJField;
    private javax.swing.JTextField realestateNameJField;
    private javax.swing.JTextField realestateUnitJField;
    private javax.swing.JLabel serialNoJLabel;
    private javax.swing.JLabel serialNoJLabel1;
    private javax.swing.JLabel serialNoJLabel2;
    private javax.swing.JLabel serialNoJLabel3;
    private javax.swing.JLabel serialNoJLabel4;
    private javax.swing.JLabel serialNoJLabel5;
    // End of variables declaration//GEN-END:variables

}
