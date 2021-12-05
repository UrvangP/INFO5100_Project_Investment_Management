/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Enterprise;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.StockMarketEnterprise;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import userinterface.Network.NetworkCreateJPanel;

/**
 *
 * @author prathameshnemade
 */
public class EnterpriseCreateJPanel extends javax.swing.JPanel {

    EcoSystem ecosystem;
    UserAccount account;
    JSplitPane jSplitPane;
    private String selectedEnterprise;
    JPanel browsingJPanel;
    private HashMap<String, HashMap<String, Boolean>> enterpriseSelection = new HashMap<String, HashMap<String, Boolean>>();

    private HashMap<String, Boolean> stateSelected = new HashMap<String, Boolean>() {
        {
            put("companiesSelected", true);
            put("mutualFundsSelected", false);
            put("industriesSelected", true);
            put("realestateSelected", false);
            put("jewellerySelected", false);
            put("banksSelected", true);
            put("brokersSelected", false);
            put("walletSelected", true);
        }
    };

    public void resetSelected() {
        for (HashMap.Entry<String, Boolean> set
                : stateSelected.entrySet()) {
            stateSelected.put(set.getKey(), false);
        }
    }

    public EnterpriseCreateJPanel(EcoSystem ecosystem, UserAccount account, JSplitPane jSplitPane, JPanel browsingJPanel) {
        this.ecosystem = ecosystem;
        this.account = account;
        this.jSplitPane = jSplitPane;
        this.browsingJPanel = browsingJPanel;
        initComponents();
        this.selectedEnterprise = "StockMarket";
        this.typeJLabel.setText("StockMarket");

        Network ongoing = null;

        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            Network ongoing1 = this.ecosystem.getNetwork().getNetworkList().get(i);
            if (ongoing1.getIsSelected()) {
                ongoing = ongoing1;
            }
        }

        if (ongoing != null) {
            enterpriseSelection = ongoing.getEnterpriseDirectory().getEnterpriseSelection();
        } else {
            JOptionPane.showMessageDialog(this, "Please select/create a network first!", "Setup", ERROR_MESSAGE);
            NetworkCreateJPanel networkCreateJPanel = new NetworkCreateJPanel(ecosystem, account, jSplitPane, browsingJPanel);
            this.jSplitPane.setRightComponent(networkCreateJPanel);
        }
        this.assetChecked.setVisible(enterpriseSelection.get("AssetMarket") == null ? false : true);
        this.forexChecked.setVisible(enterpriseSelection.get("ForexMarket") == null ? false : true);
        this.cryptoChecked.setVisible(enterpriseSelection.get("CryptoMarket") == null ? false : true);
        this.stockChecked.setVisible(enterpriseSelection.get("StockMarket") == null ? false : true);

        this.assetMarketJPanel.setVisible(false);
        this.forexMarketJPanel.setVisible(false);
        this.cryptoMarketJPanel.setVisible(false);
        this.stockMarketJPanel.setVisible(false);

        this.companiesChecked.setVisible(enterpriseSelection.get("StockMarket") == null ? true : enterpriseSelection.get("StockMarket").get("Companies"));
        this.mutualChecked.setVisible(enterpriseSelection.get("StockMarket") == null ? false : enterpriseSelection.get("StockMarket").get("MutualFunds"));
        this.industriesChecked.setVisible(enterpriseSelection.get("AssetMarket") == null ? true : enterpriseSelection.get("AssetMarket").get("Industries"));
        this.realestateChecked.setVisible(enterpriseSelection.get("AssetMarket") == null ? false : enterpriseSelection.get("AssetMarket").get("RealEstate"));
        this.jewelleyChecked.setVisible(enterpriseSelection.get("AssetMarket") == null ? false : enterpriseSelection.get("AssetMarket").get("Jewellery"));
        this.banksChecked.setVisible(enterpriseSelection.get("ForexMarket") == null ? true : enterpriseSelection.get("ForexMarket").get("Banks"));
        this.brokersChecked.setVisible(enterpriseSelection.get("ForexMarket") == null ? false : enterpriseSelection.get("ForexMarket").get("Brokers"));
        this.walletChecked.setVisible(enterpriseSelection.get("CryptoMarket") == null ? true : enterpriseSelection.get("CryptoMarket").get("Wallet"));

        this.createdByJLabel.setText("Please select to see!");
        this.dateOfCreationJLabel.setText("Please select to seeÏ!");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        stockMarketJLabel = new javax.swing.JLabel();
        assetMarketJLabel = new javax.swing.JLabel();
        forexMarketJLabel = new javax.swing.JLabel();
        cryptoMarketJLabel = new javax.swing.JLabel();
        stockChecked = new javax.swing.JLabel();
        assetChecked = new javax.swing.JLabel();
        forexChecked = new javax.swing.JLabel();
        cryptoChecked = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        stockMarketJPanel = new javax.swing.JPanel();
        stockMarketJLabel1 = new javax.swing.JLabel();
        stockMarketJLabel3 = new javax.swing.JLabel();
        companiesChecked = new javax.swing.JLabel();
        mutualChecked = new javax.swing.JLabel();
        assetMarketJPanel = new javax.swing.JPanel();
        stockMarketJLabel2 = new javax.swing.JLabel();
        stockMarketJLabel4 = new javax.swing.JLabel();
        stockMarketJLabel5 = new javax.swing.JLabel();
        industriesChecked = new javax.swing.JLabel();
        realestateChecked = new javax.swing.JLabel();
        jewelleyChecked = new javax.swing.JLabel();
        forexMarketJPanel = new javax.swing.JPanel();
        stockMarketJLabel6 = new javax.swing.JLabel();
        stockMarketJLabel8 = new javax.swing.JLabel();
        banksChecked = new javax.swing.JLabel();
        brokersChecked = new javax.swing.JLabel();
        cryptoMarketJPanel = new javax.swing.JPanel();
        stockMarketJLabel7 = new javax.swing.JLabel();
        walletChecked = new javax.swing.JLabel();
        cardentifierJLabel1 = new javax.swing.JLabel();
        dateOfCreationJLabel = new javax.swing.JTextField();
        addJButton = new javax.swing.JButton();
        cardentifierJLabel2 = new javax.swing.JLabel();
        createdByJLabel = new javax.swing.JTextField();
        cardentifierJLabel3 = new javax.swing.JLabel();
        typeJLabel = new javax.swing.JTextField();
        brandJLabel = new javax.swing.JLabel();
        countryComboBox = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create a Enterprise");

        stockMarketJLabel.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        stockMarketJLabel.setText("Stock Market");
        stockMarketJLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockMarketJLabelMouseClicked(evt);
            }
        });

        assetMarketJLabel.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        assetMarketJLabel.setText("Asset Market");
        assetMarketJLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                assetMarketJLabelMouseClicked(evt);
            }
        });

        forexMarketJLabel.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        forexMarketJLabel.setText("Forex Market");
        forexMarketJLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forexMarketJLabelMouseClicked(evt);
            }
        });

        cryptoMarketJLabel.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        cryptoMarketJLabel.setText("Crypto Market");
        cryptoMarketJLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cryptoMarketJLabelMouseClicked(evt);
            }
        });

        stockChecked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/checked.png"))); // NOI18N

        assetChecked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/checked.png"))); // NOI18N

        forexChecked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/checked.png"))); // NOI18N

        cryptoChecked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/checked.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        stockMarketJPanel.setBackground(new java.awt.Color(255, 255, 255));

        stockMarketJLabel1.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        stockMarketJLabel1.setText("Mutual Funds");
        stockMarketJLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockMarketJLabel1MouseClicked(evt);
            }
        });

        stockMarketJLabel3.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        stockMarketJLabel3.setText("Companies");
        stockMarketJLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockMarketJLabel3MouseClicked(evt);
            }
        });

        companiesChecked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/tick2.png"))); // NOI18N

        mutualChecked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/tick2.png"))); // NOI18N

        javax.swing.GroupLayout stockMarketJPanelLayout = new javax.swing.GroupLayout(stockMarketJPanel);
        stockMarketJPanel.setLayout(stockMarketJPanelLayout);
        stockMarketJPanelLayout.setHorizontalGroup(
            stockMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stockMarketJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stockMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stockMarketJLabel3)
                    .addComponent(stockMarketJLabel1))
                .addGap(18, 18, 18)
                .addGroup(stockMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(companiesChecked)
                    .addComponent(mutualChecked))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        stockMarketJPanelLayout.setVerticalGroup(
            stockMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stockMarketJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stockMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(companiesChecked, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(stockMarketJLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(stockMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mutualChecked, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(stockMarketJLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        assetMarketJPanel.setBackground(new java.awt.Color(255, 255, 255));

        stockMarketJLabel2.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        stockMarketJLabel2.setText("Real Estate");
        stockMarketJLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockMarketJLabel2MouseClicked(evt);
            }
        });

        stockMarketJLabel4.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        stockMarketJLabel4.setText("Industries");
        stockMarketJLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockMarketJLabel4MouseClicked(evt);
            }
        });

        stockMarketJLabel5.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        stockMarketJLabel5.setText("Jewellery");
        stockMarketJLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockMarketJLabel5MouseClicked(evt);
            }
        });

        industriesChecked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/tick2.png"))); // NOI18N

        realestateChecked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/tick2.png"))); // NOI18N

        jewelleyChecked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/tick2.png"))); // NOI18N

        javax.swing.GroupLayout assetMarketJPanelLayout = new javax.swing.GroupLayout(assetMarketJPanel);
        assetMarketJPanel.setLayout(assetMarketJPanelLayout);
        assetMarketJPanelLayout.setHorizontalGroup(
            assetMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(assetMarketJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(assetMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stockMarketJLabel4)
                    .addComponent(stockMarketJLabel2)
                    .addComponent(stockMarketJLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(assetMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(industriesChecked)
                    .addComponent(realestateChecked)
                    .addComponent(jewelleyChecked))
                .addGap(45, 45, 45))
        );
        assetMarketJPanelLayout.setVerticalGroup(
            assetMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(assetMarketJPanelLayout.createSequentialGroup()
                .addGroup(assetMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(industriesChecked, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addGroup(assetMarketJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(stockMarketJLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30)
                .addGroup(assetMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(realestateChecked, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(stockMarketJLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(assetMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stockMarketJLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jewelleyChecked, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                .addContainerGap())
        );

        forexMarketJPanel.setBackground(new java.awt.Color(255, 255, 255));

        stockMarketJLabel6.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        stockMarketJLabel6.setText("Banks");
        stockMarketJLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockMarketJLabel6MouseClicked(evt);
            }
        });

        stockMarketJLabel8.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        stockMarketJLabel8.setText("Brokers");
        stockMarketJLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockMarketJLabel8MouseClicked(evt);
            }
        });

        banksChecked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/tick2.png"))); // NOI18N

        brokersChecked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/tick2.png"))); // NOI18N

        javax.swing.GroupLayout forexMarketJPanelLayout = new javax.swing.GroupLayout(forexMarketJPanel);
        forexMarketJPanel.setLayout(forexMarketJPanelLayout);
        forexMarketJPanelLayout.setHorizontalGroup(
            forexMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(forexMarketJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(forexMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stockMarketJLabel6)
                    .addComponent(stockMarketJLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(forexMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(banksChecked)
                    .addComponent(brokersChecked))
                .addGap(45, 45, 45))
        );
        forexMarketJPanelLayout.setVerticalGroup(
            forexMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(forexMarketJPanelLayout.createSequentialGroup()
                .addGroup(forexMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(banksChecked, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addGroup(forexMarketJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(stockMarketJLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30)
                .addGroup(forexMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(brokersChecked, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(stockMarketJLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        cryptoMarketJPanel.setBackground(new java.awt.Color(255, 255, 255));

        stockMarketJLabel7.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        stockMarketJLabel7.setText("Wallet");
        stockMarketJLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockMarketJLabel7MouseClicked(evt);
            }
        });

        walletChecked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/tick2.png"))); // NOI18N

        javax.swing.GroupLayout cryptoMarketJPanelLayout = new javax.swing.GroupLayout(cryptoMarketJPanel);
        cryptoMarketJPanel.setLayout(cryptoMarketJPanelLayout);
        cryptoMarketJPanelLayout.setHorizontalGroup(
            cryptoMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cryptoMarketJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stockMarketJLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(walletChecked)
                .addGap(45, 45, 45))
        );
        cryptoMarketJPanelLayout.setVerticalGroup(
            cryptoMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cryptoMarketJPanelLayout.createSequentialGroup()
                .addGroup(cryptoMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(walletChecked, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cryptoMarketJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(stockMarketJLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(assetMarketJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stockMarketJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(forexMarketJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cryptoMarketJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stockMarketJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(assetMarketJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(forexMarketJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cryptoMarketJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        addJButton.setBackground(new java.awt.Color(200, 203, 178));
        addJButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        addJButton.setForeground(new java.awt.Color(67, 100, 100));
        addJButton.setText("ADD");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
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

        cardentifierJLabel3.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        cardentifierJLabel3.setForeground(new java.awt.Color(67, 100, 100));
        cardentifierJLabel3.setText("Name/Type:");

        typeJLabel.setEditable(false);
        typeJLabel.setBackground(new java.awt.Color(216, 220, 228));
        typeJLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        typeJLabel.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        typeJLabel.setToolTipText("This is your identifier.");
        typeJLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        typeJLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeJLabelActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stockMarketJLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(assetMarketJLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(forexMarketJLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cryptoMarketJLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(forexChecked)
                    .addComponent(cryptoChecked)
                    .addComponent(assetChecked)
                    .addComponent(stockChecked))
                .addGap(138, 138, 138)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(brandJLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cardentifierJLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cardentifierJLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cardentifierJLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(typeJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(dateOfCreationJLabel)
                    .addComponent(createdByJLabel)
                    .addComponent(addJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countryComboBox, 0, 1, Short.MAX_VALUE))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(stockChecked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(stockMarketJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(assetChecked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(assetMarketJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(forexChecked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(forexMarketJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cryptoChecked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cryptoMarketJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(countryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brandJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(typeJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cardentifierJLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateOfCreationJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cardentifierJLabel1))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createdByJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cardentifierJLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(addJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void stockMarketJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockMarketJLabelMouseClicked
        this.assetChecked.setVisible(false);
        this.forexChecked.setVisible(false);
        this.cryptoChecked.setVisible(false);
        this.stockChecked.setVisible(true);

        this.stockMarketJPanel.setVisible(true);
        this.assetMarketJPanel.setVisible(false);
        this.forexMarketJPanel.setVisible(false);
        this.cryptoMarketJPanel.setVisible(false);

        this.selectedEnterprise = "StockMarket";
        this.typeJLabel.setText("StockMarket");

        this.createdByJLabel.setText(this.account.getUsername());
        this.dateOfCreationJLabel.setText(new Date().toString());
    }//GEN-LAST:event_stockMarketJLabelMouseClicked

    private void assetMarketJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assetMarketJLabelMouseClicked
        this.assetChecked.setVisible(true);
        this.forexChecked.setVisible(false);
        this.cryptoChecked.setVisible(false);
        this.stockChecked.setVisible(false);

        this.stockMarketJPanel.setVisible(false);
        this.assetMarketJPanel.setVisible(true);
        this.cryptoMarketJPanel.setVisible(false);
        this.forexMarketJPanel.setVisible(false);

        this.selectedEnterprise = "AssetMarket";
        this.typeJLabel.setText("AssetMarket");
        this.createdByJLabel.setText(this.account.getUsername());
        this.dateOfCreationJLabel.setText(new Date().toString());

    }//GEN-LAST:event_assetMarketJLabelMouseClicked

    private void forexMarketJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forexMarketJLabelMouseClicked
        this.assetChecked.setVisible(false);
        this.forexChecked.setVisible(true);
        this.cryptoChecked.setVisible(false);
        this.stockChecked.setVisible(false);

        this.stockMarketJPanel.setVisible(false);
        this.assetMarketJPanel.setVisible(false);
        this.forexMarketJPanel.setVisible(true);
        this.cryptoMarketJPanel.setVisible(false);
        this.selectedEnterprise = "ForexMarket";
        this.typeJLabel.setText("ForexMarket");
        this.createdByJLabel.setText(this.account.getUsername());
        this.dateOfCreationJLabel.setText(new Date().toString());

    }//GEN-LAST:event_forexMarketJLabelMouseClicked

    private void cryptoMarketJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cryptoMarketJLabelMouseClicked
        this.assetChecked.setVisible(false);
        this.forexChecked.setVisible(false);
        this.cryptoChecked.setVisible(true);
        this.stockChecked.setVisible(false);

        this.stockMarketJPanel.setVisible(false);
        this.assetMarketJPanel.setVisible(false);
        this.forexMarketJPanel.setVisible(false);
        this.cryptoMarketJPanel.setVisible(true);
        this.selectedEnterprise = "CryptoMarket";
        this.typeJLabel.setText("CryptoMarket");
        this.createdByJLabel.setText(this.account.getUsername());
        this.dateOfCreationJLabel.setText(new Date().toString());
    }//GEN-LAST:event_cryptoMarketJLabelMouseClicked

    private void stockMarketJLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockMarketJLabel1MouseClicked
        Boolean value = this.stateSelected.get("mutualFundsSelected");
        this.mutualChecked.setVisible(!value);
        this.stateSelected.put("mutualFundsSelected", !value);
    }//GEN-LAST:event_stockMarketJLabel1MouseClicked

    private void stockMarketJLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockMarketJLabel2MouseClicked
        Boolean value = this.stateSelected.get("realestateSelected");
        this.realestateChecked.setVisible(!value);
        this.stateSelected.put("realestateSelected", !value);
    }//GEN-LAST:event_stockMarketJLabel2MouseClicked

    private void stockMarketJLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockMarketJLabel3MouseClicked
        Boolean value = this.stateSelected.get("companiesSelected");
        this.companiesChecked.setVisible(!value);
        this.stateSelected.put("companiesSelected", !value);
    }//GEN-LAST:event_stockMarketJLabel3MouseClicked

    private void stockMarketJLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockMarketJLabel4MouseClicked
        Boolean value = this.stateSelected.get("industriesSelected");
        this.industriesChecked.setVisible(!value);
        this.stateSelected.put("industriesSelected", !value);
    }//GEN-LAST:event_stockMarketJLabel4MouseClicked

    private void stockMarketJLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockMarketJLabel5MouseClicked
        Boolean value = this.stateSelected.get("jewellerySelected");
        this.jewelleyChecked.setVisible(!value);
        this.stateSelected.put("jewellerySelected", !value);
    }//GEN-LAST:event_stockMarketJLabel5MouseClicked

    private void stockMarketJLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockMarketJLabel6MouseClicked
        Boolean value = this.stateSelected.get("banksSelected");
        this.banksChecked.setVisible(!value);
        this.stateSelected.put("banksSelected", !value);
    }//GEN-LAST:event_stockMarketJLabel6MouseClicked

    private void stockMarketJLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockMarketJLabel7MouseClicked
        Boolean value = this.stateSelected.get("walletSelected");
        this.walletChecked.setVisible(!value);
        this.stateSelected.put("walletSelected", !value);
    }//GEN-LAST:event_stockMarketJLabel7MouseClicked

    private void stockMarketJLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockMarketJLabel8MouseClicked
        Boolean value = this.stateSelected.get("brokersSelected");
        this.brokersChecked.setVisible(!value);
        this.stateSelected.put("brokersSelected", !value);
    }//GEN-LAST:event_stockMarketJLabel8MouseClicked

    private void dateOfCreationJLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateOfCreationJLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateOfCreationJLabelActionPerformed

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        Enterprise tempStorage;
        String name = null;
        Enterprise.EnterpriseType type = null;

        if (this.selectedEnterprise == "AssetMarket") {
            name = "AssetMarket";
            type = Enterprise.EnterpriseType.AssetMarket;
            enterpriseSelection.put("AssetMarket", new HashMap<String, Boolean>());
            HashMap<String, Boolean> visibility = enterpriseSelection.get("AssetMarket");
            visibility.put("Industries", this.industriesChecked.isVisible());
            visibility.put("RealEstate", this.realestateChecked.isVisible());
            visibility.put("Jewellery", this.jewelleyChecked.isVisible());
        } else if (this.selectedEnterprise == "CryptoMarket") {
            name = "CryptoMarket";
            type = Enterprise.EnterpriseType.CryptoMarket;
            enterpriseSelection.put("CryptoMarket", new HashMap<String, Boolean>());
            HashMap<String, Boolean> visibility = enterpriseSelection.get("CryptoMarket");
            visibility.put("Wallet", this.walletChecked.isVisible());
        } else if (this.selectedEnterprise == "ForexMarket") {
            name = "ForexMarket";
            type = Enterprise.EnterpriseType.ForexMarket;
            enterpriseSelection.put("ForexMarket", new HashMap<String, Boolean>());
            HashMap<String, Boolean> visibility = enterpriseSelection.get("ForexMarket");
            visibility.put("Banks", this.banksChecked.isVisible());
            visibility.put("Brokers", this.brokersChecked.isVisible());
        } else {
            name = "StockMarket";
            type = Enterprise.EnterpriseType.StockMarket;
            tempStorage = new StockMarketEnterprise("StockMarket", Enterprise.EnterpriseType.StockMarket, new Date(), this.countryComboBox.getSelectedItem().toString(), this.account);
            enterpriseSelection.put("StockMarket", new HashMap<String, Boolean>());
            HashMap<String, Boolean> visibility = enterpriseSelection.get("StockMarket");
            visibility.put("Companies", this.companiesChecked.isVisible());
            visibility.put("MutualFunds", this.mutualChecked.isVisible());
        }

        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            Network ongoing = this.ecosystem.getNetwork().getNetworkList().get(i);
            if (ongoing.getIsSelected()) {
                Integer index = this.ecosystem.getNetwork().getNetworkList().indexOf(ongoing);
                System.out.println("dfdsf" + index);
                System.out.println("name, new Date(), this.countryComboBox.getSelectedItem().toString(), account" + this.ecosystem.getNetwork().getNetworkList().get(index).getEnterpriseDirectory());
                this.ecosystem.getNetwork().getNetworkList().get(index).getEnterpriseDirectory().createAssetMarketEnterprise(name, new Date(), this.countryComboBox.getSelectedItem().toString(), account);
            }
        }
        this.ecosystem.generateBrowsingHistoryEnterprise(this.browsingJPanel);
        JOptionPane.showMessageDialog(this, "Enterprise edited successfully!", "Add Enterprise", INFORMATION_MESSAGE);
    }//GEN-LAST:event_addJButtonActionPerformed

    private void createdByJLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createdByJLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createdByJLabelActionPerformed

    private void typeJLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeJLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeJLabelActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JLabel assetChecked;
    private javax.swing.JLabel assetMarketJLabel;
    private javax.swing.JPanel assetMarketJPanel;
    private javax.swing.JLabel banksChecked;
    private javax.swing.JLabel brandJLabel;
    private javax.swing.JLabel brokersChecked;
    private javax.swing.JLabel cardentifierJLabel1;
    private javax.swing.JLabel cardentifierJLabel2;
    private javax.swing.JLabel cardentifierJLabel3;
    private javax.swing.JLabel companiesChecked;
    private javax.swing.JComboBox<String> countryComboBox;
    private javax.swing.JTextField createdByJLabel;
    private javax.swing.JLabel cryptoChecked;
    private javax.swing.JLabel cryptoMarketJLabel;
    private javax.swing.JPanel cryptoMarketJPanel;
    private javax.swing.JTextField dateOfCreationJLabel;
    private javax.swing.JLabel forexChecked;
    private javax.swing.JLabel forexMarketJLabel;
    private javax.swing.JPanel forexMarketJPanel;
    private javax.swing.JLabel industriesChecked;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jewelleyChecked;
    private javax.swing.JLabel mutualChecked;
    private javax.swing.JLabel realestateChecked;
    private javax.swing.JLabel stockChecked;
    private javax.swing.JLabel stockMarketJLabel;
    private javax.swing.JLabel stockMarketJLabel1;
    private javax.swing.JLabel stockMarketJLabel2;
    private javax.swing.JLabel stockMarketJLabel3;
    private javax.swing.JLabel stockMarketJLabel4;
    private javax.swing.JLabel stockMarketJLabel5;
    private javax.swing.JLabel stockMarketJLabel6;
    private javax.swing.JLabel stockMarketJLabel7;
    private javax.swing.JLabel stockMarketJLabel8;
    private javax.swing.JPanel stockMarketJPanel;
    private javax.swing.JTextField typeJLabel;
    private javax.swing.JLabel walletChecked;
    // End of variables declaration//GEN-END:variables

}
