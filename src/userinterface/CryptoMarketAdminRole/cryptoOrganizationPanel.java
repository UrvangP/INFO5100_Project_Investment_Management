/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CryptoMarketAdminRole;

import Business.EcoSystem;
import Business.Enterprise.CryptoMarketEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.WalletOrganization;
import Business.Role.CompanyAgentRole;
import Business.Role.CryptoAgentRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import userinterface.StockMarketAdminRole.stockMarketDashboard;

/**
 *
 * @author urvang
 */
public class cryptoOrganizationPanel extends javax.swing.JPanel {

    /**
     * Creates new form cryptoOrganizationPanel
     */
    EcoSystem ecosystem;
    UserAccount account;
    JSplitPane jSplitPane;
    JPanel browsingJPanel;
    Network ongoing;
    UserAccount selectedUser;
    ArrayList<UserAccount> selectedDropDown;
    cryptoMarketDashboard parent;
    
    ArrayList<UserAccount> assetsAdminUser = new ArrayList<>();
    
    public cryptoOrganizationPanel(EcoSystem ecosystem, UserAccount account, JSplitPane jSplitPane, JPanel browsingJPanel, cryptoMarketDashboard parent) {
        
        this.ecosystem = ecosystem;
        this.account = account;
        this.jSplitPane = jSplitPane;
        this.browsingJPanel = browsingJPanel;
        this.parent = parent;
        
        initComponents();
        
        setStockAdminUsers();
        
        this.ongoing = null;

        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            Network ongoing1 = this.ecosystem.getNetwork().getNetworkList().get(i);
            if (ongoing1.getIsSelected()) {
                ongoing = ongoing1;
            }
        }
        
        initData();
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
        jLabel1 = new javax.swing.JLabel();
        brandJLabel = new javax.swing.JLabel();
        countryComboBox = new javax.swing.JComboBox<>();
        brandJLabel1 = new javax.swing.JLabel();
        adminComboBox = new javax.swing.JComboBox<>();
        cardentifierJLabel3 = new javax.swing.JLabel();
        cardentifierJLabel1 = new javax.swing.JLabel();
        dateOfCreationJLabel = new javax.swing.JTextField();
        cardentifierJLabel2 = new javax.swing.JLabel();
        createdByJLabel = new javax.swing.JTextField();
        addJButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        cardentifierJLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        cardentifierJLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add a Company");

        brandJLabel.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brandJLabel.setForeground(new java.awt.Color(67, 100, 100));
        brandJLabel.setText("Country (*):");

        countryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling Islands)", "Colombia", "Comoros", "Congo", "Cook Islands", "Costa Rica", "Cote D'Ivoire (Ivory Coast)", "Croatia (Hrvatska", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France", "Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and McDonald Islands", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea (North)", "Korea (South)", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and The Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovak Republic", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "S. Georgia and S. Sandwich Isls.", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom (Britain / UK)", "United States of America (USA)", "US Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City State (Holy See)", "Venezuela", "Viet Nam", "Virgin Islands (British)", "Virgin Islands (US)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zaire", "Zambia", "Zimbabwe" }));
        countryComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                countryComboBoxItemStateChanged(evt);
            }
        });
        countryComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                countryComboBoxFocusGained(evt);
            }
        });
        countryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryComboBoxActionPerformed(evt);
            }
        });
        countryComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                countryComboBoxPropertyChange(evt);
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

        cardentifierJLabel3.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        cardentifierJLabel3.setForeground(new java.awt.Color(67, 100, 100));
        cardentifierJLabel3.setText("Name:");

        cardentifierJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        cardentifierJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        cardentifierJLabel1.setText("Date of Creation:");

        dateOfCreationJLabel.setEditable(false);
        dateOfCreationJLabel.setBackground(new java.awt.Color(216, 220, 228));
        dateOfCreationJLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        dateOfCreationJLabel.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        dateOfCreationJLabel.setToolTipText("This is your identifier.");
        dateOfCreationJLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        dateOfCreationJLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateOfCreationJLabelActionPerformed(evt);
            }
        });

        cardentifierJLabel2.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        cardentifierJLabel2.setForeground(new java.awt.Color(67, 100, 100));
        cardentifierJLabel2.setText("Created By:");

        createdByJLabel.setEditable(false);
        createdByJLabel.setBackground(new java.awt.Color(216, 220, 228));
        createdByJLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        createdByJLabel.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        createdByJLabel.setToolTipText("This is your identifier.");
        createdByJLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        createdByJLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createdByJLabelActionPerformed(evt);
            }
        });

        addJButton.setBackground(new java.awt.Color(200, 203, 178));
        addJButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        addJButton.setForeground(new java.awt.Color(67, 100, 100));
        addJButton.setText("ADD");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        cardentifierJLabel4.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        cardentifierJLabel4.setForeground(new java.awt.Color(67, 100, 100));
        cardentifierJLabel4.setText("Crypto Price:");

        cardentifierJLabel5.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        cardentifierJLabel5.setForeground(new java.awt.Color(67, 100, 100));
        cardentifierJLabel5.setText("Circulation:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(467, 467, 467)
                .addComponent(addJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(337, 337, 337)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(brandJLabel)
                    .addComponent(brandJLabel1)
                    .addComponent(cardentifierJLabel3)
                    .addComponent(cardentifierJLabel1)
                    .addComponent(cardentifierJLabel2)
                    .addComponent(cardentifierJLabel4)
                    .addComponent(cardentifierJLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField3)
                    .addComponent(countryComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                    .addComponent(adminComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 183, Short.MAX_VALUE)
                    .addComponent(dateOfCreationJLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createdByJLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(400, 400, 400))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(12, 12, 12)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandJLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardentifierJLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateOfCreationJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardentifierJLabel1))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createdByJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardentifierJLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardentifierJLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardentifierJLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(addJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(645, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1034, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void countryComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_countryComboBoxItemStateChanged
        //TOdo
    }//GEN-LAST:event_countryComboBoxItemStateChanged

    private void countryComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_countryComboBoxFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_countryComboBoxFocusGained

    private void countryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countryComboBoxActionPerformed

    private void countryComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_countryComboBoxPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_countryComboBoxPropertyChange

    private void adminComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_adminComboBoxItemStateChanged
        _adminChnageHandler();
    }//GEN-LAST:event_adminComboBoxItemStateChanged

    private void adminComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminComboBoxFocusGained
        _adminChnageHandler();
    }//GEN-LAST:event_adminComboBoxFocusGained

    private void adminComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminComboBoxActionPerformed

    private void adminComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_adminComboBoxPropertyChange
        _adminChnageHandler();
    }//GEN-LAST:event_adminComboBoxPropertyChange

    private void dateOfCreationJLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateOfCreationJLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateOfCreationJLabelActionPerformed

    private void createdByJLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createdByJLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createdByJLabelActionPerformed

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        String companyName = jTextField1.getText();
        String companyCountry = countryComboBox.getSelectedItem().toString();
        String creationDate = dateOfCreationJLabel.getText();
        String price = jTextField2.getText();
        String revenue = jTextField3.getText();

        if(validateItem()){
            UserAccount createdBy = account;
            UserAccount admin = ecosystem.getUserAccountDirectory().getAccountOnUsername(adminComboBox.getSelectedItem().toString());

            //Company comp = new Company(companyName, companyCountry, createdBy, admin);

            for (int i = 0; i < ongoing.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
                Enterprise ep = ongoing.getEnterpriseDirectory().getEnterpriseDir().get(i);
                if (ep instanceof CryptoMarketEnterprise) {
                    ep.getOrganizationDirectory().createWalletOrganization(companyName, new Date(), companyCountry, admin, Integer.parseInt(price), Long.parseLong(revenue));
                }
            }

            this.ecosystem.generateBrowsingHistoryEnterprise(this.browsingJPanel);
            JOptionPane.showMessageDialog(this, "Organization edited successfully!", "Add Organization", INFORMATION_MESSAGE);

            parent.parseList();
        }
    }//GEN-LAST:event_addJButtonActionPerformed

    public void _adminChnageHandler() {
        Integer selectedDelIndex = this.adminComboBox.getSelectedIndex();
        if (selectedDelIndex != -1) {
            System.out.println(selectedDelIndex);
            this.selectedUser = this.selectedDropDown.get(selectedDelIndex);
        }
    }
    
    public void setStockAdminUsers() {
        ArrayList<String> asset = new ArrayList<>();
        for (int i = 0; i < this.ecosystem.getUserAccountDirectory().getUserAccountList().size(); i++) {
            UserAccount ongoing1 = this.ecosystem.getUserAccountDirectory().getUserAccountList().get(i);
            if (ongoing1.getRole() instanceof CryptoAgentRole) {
                Boolean found = false;
                for (int k = 0; k < this.ecosystem.getNetwork().getNetworkList().size(); k++) {
                    for (int j = 0; j < this.ecosystem.getNetwork().getNetworkList().get(k).getEnterpriseDirectory().getEnterpriseDir().size(); j++) {
                        Enterprise temp = this.ecosystem.getNetwork().getNetworkList().get(k).getEnterpriseDirectory().getEnterpriseDir().get(j);
                        if (temp instanceof CryptoMarketEnterprise) {
                            for (int p = 0; p < temp.getOrganizationDirectory().getOrganizationList().size(); p++) {
                                Organization temp1 = temp.getOrganizationDirectory().getOrganizationList().get(p);
                                if (temp1 instanceof WalletOrganization) {
                                    WalletOrganization temp3 = ((WalletOrganization) temp1);
                                    if (temp3.getAdmin() == ongoing1) {
                                        found = true;
                                    }
                                }
                            }
                        }
                    }
                }
                if (!found) {
                    this.assetsAdminUser.add(ongoing1);
                    asset.add(ongoing1.getUsername());
                }
            }
        }
        String[] assetSDropdown = asset.toArray(new String[asset.size()]);
        DefaultComboBoxModel<String> brandSDropdownModel = new DefaultComboBoxModel<>(assetSDropdown);
        this.adminComboBox.setModel(brandSDropdownModel);
    }

    private void initData(){
        dateOfCreationJLabel.setText(new Date().toString());
        createdByJLabel.setText(account.getUsername());
    }
    
    public Boolean validateItem() {
        String errorMEssage = "";
        if (this.adminComboBox.getSelectedItem() == null) {
            errorMEssage += "Select Admin to proceed! \n";
        }
        if (!this.jTextField1.getText().matches("[a-zA-Z0-9]+")) {
            errorMEssage += "Invalid Company Name! \n";
        }
        if (!this.jTextField3.getText().matches("[0-9]+")) {
            errorMEssage += "Circulation should be a number! \n";
        }
        if (!this.jTextField2.getText().matches("[0-9]+")) {
            errorMEssage += "Coin Price should be a number! \n";
        }
        if (errorMEssage.equals("")) {
            return true;
        }
        JOptionPane.showMessageDialog(this, errorMEssage, "Crypto Edit", ERROR_MESSAGE);
        return false;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JComboBox<String> adminComboBox;
    private javax.swing.JLabel brandJLabel;
    private javax.swing.JLabel brandJLabel1;
    private javax.swing.JLabel cardentifierJLabel1;
    private javax.swing.JLabel cardentifierJLabel2;
    private javax.swing.JLabel cardentifierJLabel3;
    private javax.swing.JLabel cardentifierJLabel4;
    private javax.swing.JLabel cardentifierJLabel5;
    private javax.swing.JComboBox<String> countryComboBox;
    private javax.swing.JTextField createdByJLabel;
    private javax.swing.JTextField dateOfCreationJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
