/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import Business.EcoSystem;
import Business.Enterprise.AssetMarketEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.IndustriesOrganization;
import Business.Organization.JewelleryOrganization;
import Business.Organization.Organization;
import Business.Organization.RealEstateOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AssetBuyWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author prathameshnemade
 */
public class CustomerAssetEditOrderJPanel extends javax.swing.JPanel {

    JSplitPane jSplitPane;
    UserAccount account;
    EcoSystem ecosystem;
    Network selectedNetwork;
    UserAccount selectedMarketAgent;
    Organization selectedOraganization;
    AssetBuyWorkRequest selectedRequest;
    ArrayList<AssetBuyWorkRequest> allRequests = new ArrayList<>();

    public CustomerAssetEditOrderJPanel(EcoSystem ecosystem, UserAccount account, JSplitPane jSplitPane1, Network selectedNetwork) {
        this.jSplitPane = jSplitPane1;
        this.account = account;
        this.ecosystem = ecosystem;
        this.selectedNetwork = selectedNetwork;
        initComponents();
        fetchData();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (int i = 0; i < this.ecosystem.getWorkQueue().getWorkRequestList().size(); i++) {
            WorkRequest ongoing = this.ecosystem.getWorkQueue().getWorkRequestList().get(i);
            if (ongoing instanceof AssetBuyWorkRequest) {
                AssetBuyWorkRequest temp = (AssetBuyWorkRequest) ongoing;
                allRequests.add(temp);
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

    public void fetchData() {
        ArrayList<String> companyName = new ArrayList<>();
        for (int i = 0; i < this.selectedNetwork.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
            Enterprise ongoing = this.selectedNetwork.getEnterpriseDirectory().getEnterpriseDir().get(i);
            if (ongoing instanceof AssetMarketEnterprise) {
                AssetMarketEnterprise temp = (AssetMarketEnterprise) this.selectedNetwork.getEnterpriseDirectory().getEnterpriseDir().get(i);
                for (int j = 0; j < temp.getOrganizationDirectory().getOrganizationList().size(); j++) {
                    Organization temp1 = temp.getOrganizationDirectory().getOrganizationList().get(j);

                    if (this.typeComboBox.getSelectedItem().toString() == "Industries") {
                        if (temp1 instanceof IndustriesOrganization) {
                            companyName.add(((IndustriesOrganization) temp1).getCompanyName().toString());
                            for (HashMap.Entry<String, HashMap<String, Object>> set
                                    : ((IndustriesOrganization) temp1).getIndustries().entrySet()) {
                                productNameJField.setText(set.getKey());
                            }
                        }
                    } else if (this.typeComboBox.getSelectedItem().toString() == "Jewellery") {
                        if (temp1 instanceof JewelleryOrganization) {
                            companyName.add(((JewelleryOrganization) temp1).getCompanyName().toString());
                            for (HashMap.Entry<String, HashMap<String, Object>> set
                                    : ((JewelleryOrganization) temp1).getJewelleries().entrySet()) {
                                productNameJField.setText(set.getKey());
                            }
                        }
                    } else if (this.typeComboBox.getSelectedItem().toString() == "Real Estate") {
                        if (temp1 instanceof RealEstateOrganization) {
                            companyName.add(((RealEstateOrganization) temp1).getCompanyName().toString());
                            for (HashMap.Entry<String, HashMap<String, Object>> set
                                    : ((RealEstateOrganization) temp1).getEstates().entrySet()) {
                                productNameJField.setText(set.getKey());
                            }
                        }
                    }
                }
            }
        }
        String[] temp1 = companyName.toArray(new String[companyName.size()]);
        DefaultComboBoxModel<String> temp11 = new DefaultComboBoxModel<>(temp1);
        this.companyNameComboBox.setModel(temp11);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        brandJLabel1 = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox<>();
        brandJLabel2 = new javax.swing.JLabel();
        companyNameComboBox = new javax.swing.JComboBox<>();
        brandJLabel3 = new javax.swing.JLabel();
        serialNoJLabel1 = new javax.swing.JLabel();
        unitJField = new javax.swing.JTextField();
        serialNoJLabel2 = new javax.swing.JLabel();
        priceJField = new javax.swing.JTextField();
        cardentifierJLabel1 = new javax.swing.JLabel();
        areaJLabel = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        productNameJField = new javax.swing.JTextField();
        maxUnitJField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        brandJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brandJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        brandJLabel1.setText("Select Type (*):");

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Industries", "Jewellery", "Real Estate" }));
        typeComboBox.setEnabled(false);
        typeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                typeComboBoxItemStateChanged(evt);
            }
        });
        typeComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                typeComboBoxFocusGained(evt);
            }
        });
        typeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComboBoxActionPerformed(evt);
            }
        });
        typeComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                typeComboBoxPropertyChange(evt);
            }
        });

        brandJLabel2.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brandJLabel2.setForeground(new java.awt.Color(67, 100, 100));
        brandJLabel2.setText("Company Name (*):");

        companyNameComboBox.setEnabled(false);
        companyNameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                companyNameComboBoxItemStateChanged(evt);
            }
        });
        companyNameComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                companyNameComboBoxFocusGained(evt);
            }
        });
        companyNameComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyNameComboBoxActionPerformed(evt);
            }
        });
        companyNameComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                companyNameComboBoxPropertyChange(evt);
            }
        });

        brandJLabel3.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brandJLabel3.setForeground(new java.awt.Color(67, 100, 100));
        brandJLabel3.setText("Invest in? (*):");

        serialNoJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel1.setText("Unit (*):");

        unitJField.setBackground(new java.awt.Color(238, 238, 238));
        unitJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        unitJField.setText("Enter here");
        unitJField.setToolTipText("Click to enter your name.");
        unitJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        unitJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                unitJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                unitJFieldnameChangeHandler(evt);
            }
        });
        unitJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitJFieldActionPerformed(evt);
            }
        });

        serialNoJLabel2.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel2.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel2.setText("Price (*):");

        priceJField.setBackground(new java.awt.Color(238, 238, 238));
        priceJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        priceJField.setText("Enter here");
        priceJField.setToolTipText("Click to enter your name.");
        priceJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        priceJField.setEnabled(false);
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

        cardentifierJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        cardentifierJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        cardentifierJLabel1.setText("Area :");

        areaJLabel.setEditable(false);
        areaJLabel.setBackground(new java.awt.Color(216, 220, 228));
        areaJLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        areaJLabel.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        areaJLabel.setText("N/A");
        areaJLabel.setToolTipText("This is your identifier.");
        areaJLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        areaJLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaJLabelActionPerformed(evt);
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

        productNameJField.setBackground(new java.awt.Color(238, 238, 238));
        productNameJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        productNameJField.setText("Enter here");
        productNameJField.setToolTipText("Click to enter your name.");
        productNameJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        productNameJField.setEnabled(false);
        productNameJField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                productNameJFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                productNameJFieldnameChangeHandler(evt);
            }
        });
        productNameJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameJFieldActionPerformed(evt);
            }
        });

        maxUnitJField.setBackground(new java.awt.Color(238, 238, 238));
        maxUnitJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        maxUnitJField.setText("Enter here");
        maxUnitJField.setToolTipText("Click to enter your name.");
        maxUnitJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        maxUnitJField.setEnabled(false);
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

        jLabel1.setText("/");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Edit a Asset Investment");

        jLabel3.setText("/ unit");

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 225, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cardentifierJLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(serialNoJLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(serialNoJLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(brandJLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(brandJLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(brandJLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(typeComboBox, 0, 359, Short.MAX_VALUE)
                            .addComponent(companyNameComboBox, 0, 359, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(unitJField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maxUnitJField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(priceJField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(areaJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productNameJField))
                        .addGap(0, 225, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandJLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandJLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productNameJField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandJLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialNoJLabel1)
                    .addComponent(unitJField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxUnitJField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialNoJLabel2)
                    .addComponent(priceJField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areaJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardentifierJLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void typeComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_typeComboBoxItemStateChanged
        fetchData();
    }//GEN-LAST:event_typeComboBoxItemStateChanged

    private void typeComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_typeComboBoxFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_typeComboBoxFocusGained

    private void typeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeComboBoxActionPerformed

    private void typeComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_typeComboBoxPropertyChange
//        todo();
    }//GEN-LAST:event_typeComboBoxPropertyChange

    private void companyNameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_companyNameComboBoxItemStateChanged
        //toodo();
    }//GEN-LAST:event_companyNameComboBoxItemStateChanged

    private void companyNameComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_companyNameComboBoxFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_companyNameComboBoxFocusGained

    private void companyNameComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyNameComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_companyNameComboBoxActionPerformed

    private void companyNameComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_companyNameComboBoxPropertyChange
//        fetchData();
    }//GEN-LAST:event_companyNameComboBoxPropertyChange

    private void unitJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_unitJFieldFocusGained
        if (unitJField.getText().equals("Enter here")) {
            unitJField.setText("");
        }
    }//GEN-LAST:event_unitJFieldFocusGained

    private void unitJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_unitJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_unitJFieldnameChangeHandler

    private void unitJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitJFieldActionPerformed

    private void priceJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_priceJFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_priceJFieldFocusGained

    private void priceJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_priceJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_priceJFieldnameChangeHandler

    private void priceJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceJFieldActionPerformed

    private void areaJLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaJLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_areaJLabelActionPerformed

    public Boolean validateItem() {
        String errorMEssage = "";
        if (this.companyNameComboBox.getSelectedItem() == null) {
            errorMEssage += "Select Company to proceed! \n";
        }
        if (!this.unitJField.getText().matches("[0-9]+")) {
            errorMEssage += "Units should be a number! \n";
        }
        if (!this.priceJField.getText().matches("[0-9]+")) {
            errorMEssage += "Please select a company! Or refresh!! \n";
        }

        if (this.unitJField.getText().matches("[0-9]+") && this.maxUnitJField.getText().matches("[0-9]+")) {
            if (Integer.valueOf(this.unitJField.getText()) > Integer.valueOf(this.maxUnitJField.getText())) {
                errorMEssage += "Entered units exceeds available \n";
            }
        }

        if (errorMEssage.equals("")) {
            return true;
        }

        JOptionPane.showMessageDialog(this, errorMEssage, "Invest", ERROR_MESSAGE);

        return false;
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Boolean valid = validateItem();
        if (valid) {
            this.selectedRequest.setQuantity(Integer.valueOf(this.unitJField.getText().toString()));
            JOptionPane.showMessageDialog(this, "Investment edited successfully!", "Investment", INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void productNameJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_productNameJFieldFocusGained
        if (this.productNameJField.getText().equals("Enter here")) {
            productNameJField.setText("");
        }
    }//GEN-LAST:event_productNameJFieldFocusGained

    private void productNameJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_productNameJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_productNameJFieldnameChangeHandler

    private void productNameJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productNameJFieldActionPerformed

    private void maxUnitJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_maxUnitJFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_maxUnitJFieldFocusGained

    private void maxUnitJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_maxUnitJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_maxUnitJFieldnameChangeHandler

    private void maxUnitJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxUnitJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxUnitJFieldActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        Integer selectedIndex = this.jTable1.getSelectedRow();
        if (selectedIndex != -1) {
            selectedRequest = this.allRequests.get(selectedIndex);
            typeComboBox.setSelectedItem(selectedRequest.getOraganization() instanceof IndustriesOrganization ? "Industries" : selectedRequest.getOraganization() instanceof JewelleryOrganization ? "Jewellery" : "Real Estate");
            companyNameComboBox.setSelectedItem(selectedRequest.getCompanyName());
            productNameJField.setText(selectedRequest.getAssetName());
            unitJField.setText(selectedRequest.getQuantity().toString());
            Organization temp1 = (Organization) selectedRequest.getOraganization();
            if (selectedRequest.getOraganization() instanceof IndustriesOrganization) {
                if (temp1 instanceof IndustriesOrganization) {
                    if (((IndustriesOrganization) temp1).getCompanyName().toString() == this.companyNameComboBox.getSelectedItem().toString()) {
                        for (HashMap.Entry<String, HashMap<String, Object>> set
                                : ((IndustriesOrganization) temp1).getIndustries().entrySet()) {
                            priceJField.setText(set.getValue().get("maxPrice").toString());
                            maxUnitJField.setText(set.getValue().get("quantity").toString());
                            areaJLabel.setText("N/A");
                        }
                    }
                }
            } else if (selectedRequest.getOraganization() instanceof JewelleryOrganization) {
                if (temp1 instanceof JewelleryOrganization) {
                    if (((JewelleryOrganization) temp1).getCompanyName().toString() == this.companyNameComboBox.getSelectedItem().toString()) {
                        for (HashMap.Entry<String, HashMap<String, Object>> set
                                : ((JewelleryOrganization) temp1).getJewelleries().entrySet()) {
                            priceJField.setText(set.getValue().get("maxPrice").toString());
                            maxUnitJField.setText(set.getValue().get("quantity").toString());
                            areaJLabel.setText("N/A");
                        }
                    }
                }
            } else if (selectedRequest.getOraganization() instanceof RealEstateOrganization) {
                if (temp1 instanceof RealEstateOrganization) {
                    if (((RealEstateOrganization) temp1).getCompanyName().toString() == this.companyNameComboBox.getSelectedItem().toString()) {
                        for (HashMap.Entry<String, HashMap<String, Object>> set
                                : ((RealEstateOrganization) temp1).getEstates().entrySet()) {
                            priceJField.setText(set.getValue().get("maxPrice").toString());
                            maxUnitJField.setText(set.getValue().get("quantity").toString());
                            areaJLabel.setText(set.getValue().get("area").toString());

                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areaJLabel;
    private javax.swing.JLabel brandJLabel1;
    private javax.swing.JLabel brandJLabel2;
    private javax.swing.JLabel brandJLabel3;
    private javax.swing.JLabel cardentifierJLabel1;
    private javax.swing.JComboBox<String> companyNameComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField maxUnitJField;
    private javax.swing.JTextField priceJField;
    private javax.swing.JTextField productNameJField;
    private javax.swing.JLabel serialNoJLabel1;
    private javax.swing.JLabel serialNoJLabel2;
    private javax.swing.JComboBox<String> typeComboBox;
    private javax.swing.JTextField unitJField;
    // End of variables declaration//GEN-END:variables
}
