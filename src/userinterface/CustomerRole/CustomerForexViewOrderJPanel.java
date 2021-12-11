/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ForexMarketEnterprise;
import Business.Network.Network;
import Business.Organization.BanksOrganization;
import Business.Organization.BrokersOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ForexBuyWorkRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JSplitPane;

/**
 *
 * @author ronak
 */
public class CustomerForexViewOrderJPanel extends javax.swing.JPanel {

    JSplitPane jSplitPane;
    UserAccount account;
    EcoSystem ecosystem;
    Network selectedNetwork;
    UserAccount selectedMarketAgent;
    Organization selectedOraganization;

    /**
     * Creates new form CustomerForexViewOrderJPanel
     */
    public CustomerForexViewOrderJPanel(EcoSystem ecosystem, UserAccount account, JSplitPane jSplitPane1, Network selectedNetwork) {
        initComponents();
        this.jSplitPane = jSplitPane1;
        this.account = account;
        this.ecosystem = ecosystem;
        this.selectedNetwork = selectedNetwork;
        fetchData();
    }

    public void fetchData() {
        ArrayList<String> companyName = new ArrayList<>();
        for (int i = 0; i < this.selectedNetwork.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
            Enterprise ongoing = this.selectedNetwork.getEnterpriseDirectory().getEnterpriseDir().get(i);
            if (ongoing instanceof ForexMarketEnterprise) {
                ForexMarketEnterprise temp = (ForexMarketEnterprise) this.selectedNetwork.getEnterpriseDirectory().getEnterpriseDir().get(i);
                for (int j = 0; j < temp.getOrganizationDirectory().getOrganizationList().size(); j++) {
                    Organization temp1 = temp.getOrganizationDirectory().getOrganizationList().get(j);

                    if (this.typeComboBox.getSelectedItem().toString() == "Bank") {
                        if (temp1 instanceof BanksOrganization) {
                            companyName.add(((BanksOrganization) temp1).getBankName().toString());
                            for (HashMap.Entry<String, HashMap<String, Object>> set
                                    : ((BanksOrganization) temp1).getBank().entrySet()) {
                                productNameJField.setText(set.getKey());
                            }
                        }
                    } else if (this.typeComboBox.getSelectedItem().toString() == "Broker") {
                        if (temp1 instanceof BrokersOrganization) {
                            companyName.add(((BrokersOrganization) temp1).getBrokerName().toString());
                            for (HashMap.Entry<String, HashMap<String, Object>> set
                                    : ((BrokersOrganization) temp1).getBroker().entrySet()) {
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

    public void fetchFields() {
        for (int i = 0; i < this.selectedNetwork.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
            Enterprise ongoing = this.selectedNetwork.getEnterpriseDirectory().getEnterpriseDir().get(i);
            if (ongoing instanceof ForexMarketEnterprise) {
                ForexMarketEnterprise temp = (ForexMarketEnterprise) this.selectedNetwork.getEnterpriseDirectory().getEnterpriseDir().get(i);
                for (int j = 0; j < temp.getOrganizationDirectory().getOrganizationList().size(); j++) {
                    Organization temp1 = temp.getOrganizationDirectory().getOrganizationList().get(j);
                    if (this.typeComboBox.getSelectedItem().toString() == "Bank") {
                        if (temp1 instanceof BanksOrganization) {
                            if (((BanksOrganization) temp1).getBankName().toString() == this.companyNameComboBox.getSelectedItem().toString()) {
                                for (HashMap.Entry<String, HashMap<String, Object>> set
                                        : ((BanksOrganization) temp1).getBank().entrySet()) {
                                    productNameJField.setText(set.getKey());
                                    priceJField.setText(set.getValue().get("maxPrice").toString());
                                    maxUnitJField.setText(set.getValue().get("quantity").toString());
                                    selectedMarketAgent = ((BanksOrganization) temp1).getAdmin();
                                    selectedOraganization = ((BanksOrganization) temp1);
                                }
                            }
                        }
                    } else if (this.typeComboBox.getSelectedItem().toString() == "Broker") {
                        if (temp1 instanceof BrokersOrganization) {
                            if (((BrokersOrganization) temp1).getBrokerName().toString() == this.companyNameComboBox.getSelectedItem().toString()) {
                                for (HashMap.Entry<String, HashMap<String, Object>> set
                                        : ((BrokersOrganization) temp1).getBroker().entrySet()) {
                                    productNameJField.setText(set.getKey());
                                    priceJField.setText(set.getValue().get("maxPrice").toString());
                                    maxUnitJField.setText(set.getValue().get("quantity").toString());
                                    selectedMarketAgent = ((BrokersOrganization) temp1).getAdmin();
                                    selectedOraganization = ((BrokersOrganization) temp1);
                                }
                            }
                        }
                    }
                }
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

        jPanel1 = new javax.swing.JPanel();
        brandJLabel1 = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox<>();
        brandJLabel2 = new javax.swing.JLabel();
        companyNameComboBox = new javax.swing.JComboBox<>();
        brandJLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        productNameJField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        serialNoJLabel1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        maxUnitJField = new javax.swing.JTextField();
        serialNoJLabel2 = new javax.swing.JLabel();
        priceJField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        unitJField = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        brandJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brandJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        brandJLabel1.setText("Select Type (*):");

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bank", "Brokers" }));
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
        brandJLabel2.setText("Bank/Broker Name (*):");

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
        brandJLabel3.setText("Currency (*):");

        jButton1.setBackground(new java.awt.Color(200, 203, 178));
        jButton1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(67, 100, 100));
        jButton1.setText("APPLY");
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

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Apply for Forex");

        serialNoJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel1.setText("Unit (*):");

        jLabel1.setText("/");

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

        jLabel3.setText("/ unit");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 147, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(brandJLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(brandJLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(brandJLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(serialNoJLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(serialNoJLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(typeComboBox, 0, 359, Short.MAX_VALUE)
                                .addComponent(companyNameComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(productNameJField))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(unitJField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(maxUnitJField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(priceJField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addGap(0, 147, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(416, 416, 416)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(395, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandJLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandJLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productNameJField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandJLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxUnitJField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serialNoJLabel1)
                    .addComponent(unitJField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceJField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serialNoJLabel2)
                    .addComponent(jLabel3))
                .addGap(32, 32, 32)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(265, 265, 265)
                    .addComponent(jLabel1)
                    .addContainerGap(255, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 818, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        fetchFields();
    }//GEN-LAST:event_companyNameComboBoxItemStateChanged

    private void companyNameComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_companyNameComboBoxFocusGained
        fetchFields();
    }//GEN-LAST:event_companyNameComboBoxFocusGained

    private void companyNameComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyNameComboBoxActionPerformed
        fetchFields();
    }//GEN-LAST:event_companyNameComboBoxActionPerformed

    private void companyNameComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_companyNameComboBoxPropertyChange
        //        fetchData();
    }//GEN-LAST:event_companyNameComboBoxPropertyChange


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Boolean valid = validateItem();
        if (valid) {
            ForexBuyWorkRequest newRequest = new ForexBuyWorkRequest(
                    this.account,
                    this.selectedMarketAgent,
                    new Date(),
                    null,
                    ForexBuyWorkRequest.StatusType.Initiated,
                    Integer.valueOf(this.priceJField.getText().toString()),
                    Integer.valueOf(this.unitJField.getText().toString()),
                    new Date(),
                    this.companyNameComboBox.getSelectedItem().toString(),
                    this.productNameJField.getText().toString(),
                    this.selectedOraganization
            );

            this.ecosystem.getWorkQueue().getWorkRequestList().add(newRequest);
            JOptionPane.showMessageDialog(this, "Investment leveraged successfully!", "Investment", INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void priceJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_priceJFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_priceJFieldFocusGained

    private void priceJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_priceJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_priceJFieldnameChangeHandler

    private void priceJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceJFieldActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brandJLabel1;
    private javax.swing.JLabel brandJLabel2;
    private javax.swing.JLabel brandJLabel3;
    private javax.swing.JComboBox<String> companyNameComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField maxUnitJField;
    private javax.swing.JTextField priceJField;
    private javax.swing.JTextField productNameJField;
    private javax.swing.JLabel serialNoJLabel1;
    private javax.swing.JLabel serialNoJLabel2;
    private javax.swing.JComboBox<String> typeComboBox;
    private javax.swing.JTextField unitJField;
    // End of variables declaration//GEN-END:variables
}
