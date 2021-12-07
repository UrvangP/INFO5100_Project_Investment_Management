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

/**
 *
 * @author prathameshnemade
 */
public class AssetRealEstateCreateJPanel extends javax.swing.JPanel {

    EcoSystem ecosystem;
    UserAccount account;
    JSplitPane jSplitPane;
    JPanel browsingJPanel;
    UserAccount selectedUser;
    Network ongoinNetwork;

    ArrayList<UserAccount> assetsAdminUser = new ArrayList<>();

    public AssetRealEstateCreateJPanel(EcoSystem ecosystem, UserAccount account, JSplitPane jSplitPane, JPanel browsingJPanel) {
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
        this.realestateDateOfCreationJLabel.setText(new Date().toString());
        setAssetAdminUsers();
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

        serialNoJLabel = new javax.swing.JLabel();
        realestateNameJField = new javax.swing.JTextField();
        cardentifierJLabel1 = new javax.swing.JLabel();
        realestateDateOfCreationJLabel = new javax.swing.JTextField();
        serialNoJLabel1 = new javax.swing.JLabel();
        realestateUnitJField = new javax.swing.JTextField();
        serialNoJLabel2 = new javax.swing.JLabel();
        nameJField = new javax.swing.JTextField();
        serialNoJLabel3 = new javax.swing.JLabel();
        realestateJField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        brandJLabel1 = new javax.swing.JLabel();
        realestateComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        serialNoJLabel4 = new javax.swing.JLabel();
        realestateLocationJField = new javax.swing.JTextField();
        serialNoJLabel5 = new javax.swing.JLabel();
        realestateAreaJField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

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

        cardentifierJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        cardentifierJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        cardentifierJLabel1.setText("Date of Creation:");

        realestateDateOfCreationJLabel.setEditable(false);
        realestateDateOfCreationJLabel.setBackground(new java.awt.Color(216, 220, 228));
        realestateDateOfCreationJLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        realestateDateOfCreationJLabel.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        realestateDateOfCreationJLabel.setToolTipText("This is your identifier.");
        realestateDateOfCreationJLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        realestateDateOfCreationJLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realestateDateOfCreationJLabelActionPerformed(evt);
            }
        });

        serialNoJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel1.setText("Unit(*):");

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

        serialNoJLabel2.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel2.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel2.setText("Name (*):");

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

        serialNoJLabel3.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        serialNoJLabel3.setForeground(new java.awt.Color(67, 100, 100));
        serialNoJLabel3.setText("Price(*):");

        realestateJField.setBackground(new java.awt.Color(238, 238, 238));
        realestateJField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        realestateJField.setText("Enter here");
        realestateJField.setToolTipText("Click to enter your name.");
        realestateJField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
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
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        brandJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brandJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        brandJLabel1.setText("Admin (*):");

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

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create a Real Estate");

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(serialNoJLabel)
                    .addComponent(brandJLabel1)
                    .addComponent(serialNoJLabel2)
                    .addComponent(serialNoJLabel4)
                    .addComponent(serialNoJLabel1)
                    .addComponent(serialNoJLabel3)
                    .addComponent(cardentifierJLabel1)
                    .addComponent(serialNoJLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(realestateDateOfCreationJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(realestateLocationJField, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameJField, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(realestateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(realestateNameJField, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(realestateAreaJField1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(realestateUnitJField, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(realestateJField, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(realestateNameJField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serialNoJLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(realestateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandJLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameJField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serialNoJLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(realestateLocationJField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serialNoJLabel4))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialNoJLabel5)
                    .addComponent(realestateAreaJField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialNoJLabel1)
                    .addComponent(realestateUnitJField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialNoJLabel3)
                    .addComponent(realestateJField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(realestateDateOfCreationJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardentifierJLabel1))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void realestateDateOfCreationJLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realestateDateOfCreationJLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateDateOfCreationJLabelActionPerformed

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
        if (!this.realestateLocationJField.getText().matches("[a-zA-Z0-9 ]+")) {
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
        Boolean valid = validateItem();
        if (valid) {
            HashMap<String, HashMap<String, Object>> estates = new HashMap<>();
            HashMap<String, Object> estate = new HashMap<>();
            estate.put("maxPrice", this.realestateJField.getText().toString());
            estate.put("quantity", this.realestateUnitJField.getText().toString());
            estate.put("area", this.realestateAreaJField1.getText().toString());
            estate.put("doc", new Date());
            estates.put(this.nameJField.getText(), estate);

            for (int i = 0; i < ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
                Enterprise ongoing = ongoinNetwork.getEnterpriseDirectory().getEnterpriseDir().get(i);
                if (ongoing instanceof AssetMarketEnterprise) {
                    ongoing.getOrganizationDirectory().createRealEstateOrganization(this.realestateNameJField.getText(), Organization.Type.RealEstate, this.nameJField.getText().toString(), this.selectedUser, estates, new Date());
                }
            }
            JOptionPane.showMessageDialog(this, "Real Estate created successfully!", "Real Estate ", INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void realestateComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_realestateComboBoxItemStateChanged
        _adminChnageHandler();
    }//GEN-LAST:event_realestateComboBoxItemStateChanged

    public void _adminChnageHandler() {
        Integer selectedDelIndex = this.realestateComboBox.getSelectedIndex();
        if (selectedDelIndex != -1) {
            this.selectedUser = this.assetsAdminUser.get(selectedDelIndex);
            System.out.println("!!!" + selectedUser.getUsername().toString());
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

    private void realestateLocationJFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_realestateLocationJFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateLocationJFieldFocusGained

    private void realestateLocationJFieldnameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_realestateLocationJFieldnameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateLocationJFieldnameChangeHandler

    private void realestateLocationJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realestateLocationJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateLocationJFieldActionPerformed

    private void realestateAreaJField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_realestateAreaJField1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateAreaJField1FocusGained

    private void realestateAreaJField1nameChangeHandler(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_realestateAreaJField1nameChangeHandler
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateAreaJField1nameChangeHandler

    private void realestateAreaJField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realestateAreaJField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_realestateAreaJField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brandJLabel1;
    private javax.swing.JLabel cardentifierJLabel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nameJField;
    private javax.swing.JTextField realestateAreaJField1;
    private javax.swing.JComboBox<String> realestateComboBox;
    private javax.swing.JTextField realestateDateOfCreationJLabel;
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
