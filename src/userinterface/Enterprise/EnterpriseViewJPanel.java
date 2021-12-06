/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Enterprise;

import Business.EcoSystem;
import Business.Enterprise.AssetMarketEnterprise;
import Business.Enterprise.CryptoMarketEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ForexMarketEnterprise;
import Business.Enterprise.StockMarketEnterprise;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import userinterface.Network.NetworkCreateJPanel;

/**
 *
 * @author prathameshnemade
 */
public class EnterpriseViewJPanel extends javax.swing.JPanel {

    EcoSystem ecosystem;
    UserAccount account;
    JSplitPane jSplitPane;
    private String selectedEnterprise;
    JPanel browsingJPanel;
    JButton assetMarketLeftButton;
    JButton stockMarketLeftButton;
    JButton forexMarketLeftButton;
    JButton cryptoMarketLeftBUtton;
    Network ongoingNetwrok;

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

    public EnterpriseViewJPanel(EcoSystem ecosystem, UserAccount account, JSplitPane jSplitPane, JPanel browsingJPanel, JButton assetMarketLeftButton, JButton stockMarketLeftButton, JButton forexMarketLeftButton, JButton cryptoMarketLeftBUtton) {
        this.ecosystem = ecosystem;
        this.account = account;
        this.jSplitPane = jSplitPane;
        this.browsingJPanel = browsingJPanel;
        this.assetMarketLeftButton = assetMarketLeftButton;
        this.stockMarketLeftButton = stockMarketLeftButton;
        this.forexMarketLeftButton = forexMarketLeftButton;
        this.cryptoMarketLeftBUtton = cryptoMarketLeftBUtton;
        initComponents();
        this.selectedEnterprise = "StockMarket";


        for (int i = 0; i < this.ecosystem.getNetwork().getNetworkList().size(); i++) {
            Network ongoing1 = this.ecosystem.getNetwork().getNetworkList().get(i);
            if (ongoing1.getIsSelected()) {
                ongoingNetwrok = ongoing1;
            }
        }

        if (ongoingNetwrok != null) {
            enterpriseSelection = ongoingNetwrok.getEnterpriseDirectory().getEnterpriseSelection();
        } else {
            JOptionPane.showMessageDialog(this, "Please select/create a network first!", "Setup", ERROR_MESSAGE);
            NetworkCreateJPanel networkCreateJPanel = new NetworkCreateJPanel(ecosystem, account, jSplitPane, browsingJPanel);
            this.jSplitPane.setRightComponent(networkCreateJPanel);
        }
        this.assetChecked.setVisible(enterpriseSelection.get("AssetMarket") == null ? false : true);
        this.forexChecked.setVisible(enterpriseSelection.get("ForexMarket") == null ? false : true);
        this.cryptoChecked.setVisible(enterpriseSelection.get("CryptoMarket") == null ? false : true);
        this.stockChecked.setVisible(enterpriseSelection.get("StockMarket") == null ? false : true);

        this.companiesChecked.setVisible(enterpriseSelection.get("StockMarket") == null ? false : enterpriseSelection.get("StockMarket").get("Companies"));
        this.mutualChecked.setVisible(enterpriseSelection.get("StockMarket") == null ? false : enterpriseSelection.get("StockMarket").get("MutualFunds"));
        this.industriesChecked.setVisible(enterpriseSelection.get("AssetMarket") == null ? false : enterpriseSelection.get("AssetMarket").get("Industries"));
        this.realestateChecked.setVisible(enterpriseSelection.get("AssetMarket") == null ? false : enterpriseSelection.get("AssetMarket").get("RealEstate"));
        this.jewelleyChecked.setVisible(enterpriseSelection.get("AssetMarket") == null ? false : enterpriseSelection.get("AssetMarket").get("Jewellery"));
        this.banksChecked.setVisible(enterpriseSelection.get("ForexMarket") == null ? false : enterpriseSelection.get("ForexMarket").get("Banks"));
        this.brokersChecked.setVisible(enterpriseSelection.get("ForexMarket") == null ? false : enterpriseSelection.get("ForexMarket").get("Brokers"));
        this.walletChecked.setVisible(enterpriseSelection.get("CryptoMarket") == null ? false : enterpriseSelection.get("CryptoMarket").get("Wallet"));

        if (enterpriseSelection.get("AssetMarket") != null) {
            for (int i = 0; i < ongoingNetwrok.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
                Enterprise ongoign1 = ongoingNetwrok.getEnterpriseDirectory().getEnterpriseDir().get(i);
                if (ongoign1 instanceof AssetMarketEnterprise) {
                    AssetMarketEnterprise temp = (AssetMarketEnterprise) ongoingNetwrok.getEnterpriseDirectory().getEnterpriseDir().get(i);
                    this.assetAdminComboBox.setText(temp.admin.getUsername());
                }
            }
        }

        if (enterpriseSelection.get("ForexMarket") != null) {
            for (int i = 0; i < ongoingNetwrok.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
                Enterprise ongoign1 = ongoingNetwrok.getEnterpriseDirectory().getEnterpriseDir().get(i);
                if (ongoign1 instanceof ForexMarketEnterprise) {
                    ForexMarketEnterprise temp = (ForexMarketEnterprise) ongoingNetwrok.getEnterpriseDirectory().getEnterpriseDir().get(i);
                    this.forexAdminComboBox.setText(temp.admin.getUsername());
                }
            }
        }

        if (enterpriseSelection.get("CryptoMarket") != null) {
            for (int i = 0; i < ongoingNetwrok.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
                Enterprise ongoign1 = ongoingNetwrok.getEnterpriseDirectory().getEnterpriseDir().get(i);
                if (ongoign1 instanceof CryptoMarketEnterprise) {
                    CryptoMarketEnterprise temp = (CryptoMarketEnterprise) ongoingNetwrok.getEnterpriseDirectory().getEnterpriseDir().get(i);
                    this.cryptoAdminComboBox.setText(temp.admin.getUsername());
                }
            }
        }

        if (enterpriseSelection.get("StockMarket") != null) {
            for (int i = 0; i < ongoingNetwrok.getEnterpriseDirectory().getEnterpriseDir().size(); i++) {
                Enterprise ongoign1 = ongoingNetwrok.getEnterpriseDirectory().getEnterpriseDir().get(i);
                if (ongoign1 instanceof StockMarketEnterprise) {
                    StockMarketEnterprise temp = (StockMarketEnterprise) ongoingNetwrok.getEnterpriseDirectory().getEnterpriseDir().get(i);
                    this.stockAdminComboBox.setText(temp.admin.getUsername());
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

        jLabel1 = new javax.swing.JLabel();
        stockMarketJLabel = new javax.swing.JLabel();
        assetMarketJLabel = new javax.swing.JLabel();
        stockChecked = new javax.swing.JLabel();
        assetChecked = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        exitJLabel = new javax.swing.JLabel();
        viewJLabel = new javax.swing.JLabel();
        viewJLabel1 = new javax.swing.JLabel();
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
        forexMarketJLabel = new javax.swing.JLabel();
        forexChecked = new javax.swing.JLabel();
        forexMarketJPanel = new javax.swing.JPanel();
        stockMarketJLabel6 = new javax.swing.JLabel();
        stockMarketJLabel8 = new javax.swing.JLabel();
        banksChecked = new javax.swing.JLabel();
        brokersChecked = new javax.swing.JLabel();
        cryptoMarketJLabel = new javax.swing.JLabel();
        cryptoChecked = new javax.swing.JLabel();
        cryptoMarketJPanel = new javax.swing.JPanel();
        stockMarketJLabel7 = new javax.swing.JLabel();
        walletChecked = new javax.swing.JLabel();
        brandJLabel1 = new javax.swing.JLabel();
        brandJLabel2 = new javax.swing.JLabel();
        brandJLabel3 = new javax.swing.JLabel();
        brandJLabel4 = new javax.swing.JLabel();
        assetAdminComboBox = new javax.swing.JTextField();
        stockAdminComboBox = new javax.swing.JTextField();
        cryptoAdminComboBox = new javax.swing.JTextField();
        forexAdminComboBox = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View a Enterprise");

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

        stockChecked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/checked.png"))); // NOI18N

        assetChecked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/checked.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        exitJLabel.setFont(new java.awt.Font("Zapf Dingbats", 1, 14)); // NOI18N
        exitJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/edit_all.png"))); // NOI18N
        exitJLabel.setText(" Edit Enterprises");
        exitJLabel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                exitJLabelFocusGained(evt);
            }
        });
        exitJLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitJLabelMouseClicked(evt);
            }
        });

        viewJLabel.setFont(new java.awt.Font("Zapf Dingbats", 1, 14)); // NOI18N
        viewJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/view_all.png"))); // NOI18N
        viewJLabel.setText(" View Enterprises");
        viewJLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewJLabelMouseClicked(evt);
            }
        });

        viewJLabel1.setFont(new java.awt.Font("Zapf Dingbats", 1, 14)); // NOI18N
        viewJLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/create.png"))); // NOI18N
        viewJLabel1.setText(" Create Enterprise");
        viewJLabel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                viewJLabel1FocusGained(evt);
            }
        });
        viewJLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewJLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewJLabel1)
                    .addComponent(exitJLabel)
                    .addComponent(viewJLabel))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewJLabel)
                .addGap(18, 18, 18)
                .addComponent(exitJLabel)
                .addGap(18, 18, 18)
                .addComponent(viewJLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        stockMarketJPanel.setBackground(new java.awt.Color(255, 255, 255));

        stockMarketJLabel1.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        stockMarketJLabel1.setText("Mutual Funds");
        stockMarketJLabel1.setEnabled(false);
        stockMarketJLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockMarketJLabel1MouseClicked(evt);
            }
        });

        stockMarketJLabel3.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        stockMarketJLabel3.setText("Companies");
        stockMarketJLabel3.setEnabled(false);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(stockMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(companiesChecked, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mutualChecked, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
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
        stockMarketJLabel2.setEnabled(false);
        stockMarketJLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockMarketJLabel2MouseClicked(evt);
            }
        });

        stockMarketJLabel4.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        stockMarketJLabel4.setText("Industries");
        stockMarketJLabel4.setEnabled(false);
        stockMarketJLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockMarketJLabel4MouseClicked(evt);
            }
        });

        stockMarketJLabel5.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        stockMarketJLabel5.setText("Jewellery");
        stockMarketJLabel5.setEnabled(false);
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
                .addGap(73, 73, 73)
                .addGroup(assetMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(industriesChecked, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(realestateChecked, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jewelleyChecked, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(16, Short.MAX_VALUE))
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

        forexMarketJLabel.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        forexMarketJLabel.setText("Forex Market");
        forexMarketJLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forexMarketJLabelMouseClicked(evt);
            }
        });

        forexChecked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/checked.png"))); // NOI18N

        forexMarketJPanel.setBackground(new java.awt.Color(255, 255, 255));

        stockMarketJLabel6.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        stockMarketJLabel6.setText("Banks");
        stockMarketJLabel6.setEnabled(false);
        stockMarketJLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockMarketJLabel6MouseClicked(evt);
            }
        });

        stockMarketJLabel8.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        stockMarketJLabel8.setText("Brokers");
        stockMarketJLabel8.setEnabled(false);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(forexMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(banksChecked, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(brokersChecked, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        forexMarketJPanelLayout.setVerticalGroup(
            forexMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(forexMarketJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(forexMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stockMarketJLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(banksChecked, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(forexMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(brokersChecked, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(stockMarketJLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        cryptoMarketJLabel.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        cryptoMarketJLabel.setText("Crypto Market");
        cryptoMarketJLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cryptoMarketJLabelMouseClicked(evt);
            }
        });

        cryptoChecked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/checked.png"))); // NOI18N

        cryptoMarketJPanel.setBackground(new java.awt.Color(255, 255, 255));

        stockMarketJLabel7.setFont(new java.awt.Font("Gurmukhi MN", 1, 18)); // NOI18N
        stockMarketJLabel7.setText("Wallet");
        stockMarketJLabel7.setEnabled(false);
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
                .addComponent(stockMarketJLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(walletChecked)
                .addContainerGap())
        );
        cryptoMarketJPanelLayout.setVerticalGroup(
            cryptoMarketJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(stockMarketJLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(walletChecked, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        brandJLabel1.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brandJLabel1.setForeground(new java.awt.Color(67, 100, 100));
        brandJLabel1.setText("Stock Admin (*):");

        brandJLabel2.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brandJLabel2.setForeground(new java.awt.Color(67, 100, 100));
        brandJLabel2.setText("Crypto Admin (*):");

        brandJLabel3.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brandJLabel3.setForeground(new java.awt.Color(67, 100, 100));
        brandJLabel3.setText("Forex Admin (*):");

        brandJLabel4.setFont(new java.awt.Font("PT Sans Caption", 0, 14)); // NOI18N
        brandJLabel4.setForeground(new java.awt.Color(67, 100, 100));
        brandJLabel4.setText("Asset Admin (*):");

        assetAdminComboBox.setEditable(false);
        assetAdminComboBox.setBackground(new java.awt.Color(216, 220, 228));
        assetAdminComboBox.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        assetAdminComboBox.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        assetAdminComboBox.setText("N/A");
        assetAdminComboBox.setToolTipText("This is your identifier.");
        assetAdminComboBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        assetAdminComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assetAdminComboBoxActionPerformed(evt);
            }
        });

        stockAdminComboBox.setEditable(false);
        stockAdminComboBox.setBackground(new java.awt.Color(216, 220, 228));
        stockAdminComboBox.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        stockAdminComboBox.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        stockAdminComboBox.setText("N/A");
        stockAdminComboBox.setToolTipText("This is your identifier.");
        stockAdminComboBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        stockAdminComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockAdminComboBoxActionPerformed(evt);
            }
        });

        cryptoAdminComboBox.setEditable(false);
        cryptoAdminComboBox.setBackground(new java.awt.Color(216, 220, 228));
        cryptoAdminComboBox.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        cryptoAdminComboBox.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        cryptoAdminComboBox.setText("N/A");
        cryptoAdminComboBox.setToolTipText("This is your identifier.");
        cryptoAdminComboBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        cryptoAdminComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cryptoAdminComboBoxActionPerformed(evt);
            }
        });

        forexAdminComboBox.setEditable(false);
        forexAdminComboBox.setBackground(new java.awt.Color(216, 220, 228));
        forexAdminComboBox.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        forexAdminComboBox.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        forexAdminComboBox.setText("N/A");
        forexAdminComboBox.setToolTipText("This is your identifier.");
        forexAdminComboBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        forexAdminComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forexAdminComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(stockMarketJLabel)
                                .addGap(59, 59, 59)
                                .addComponent(stockChecked))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(stockMarketJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cryptoMarketJPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cryptoMarketJLabel)
                                        .addGap(39, 39, 39)
                                        .addComponent(cryptoChecked)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(135, 135, 135)
                                        .addComponent(assetMarketJLabel)
                                        .addGap(59, 59, 59)
                                        .addComponent(assetChecked))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(137, 137, 137)
                                        .addComponent(forexMarketJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(112, 112, 112)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(brandJLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(brandJLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(brandJLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(brandJLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(stockAdminComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(cryptoAdminComboBox)
                                    .addComponent(forexAdminComboBox)
                                    .addComponent(assetAdminComboBox)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(assetMarketJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(495, 495, 495)
                        .addComponent(forexMarketJLabel)
                        .addGap(47, 47, 47)
                        .addComponent(forexChecked)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(stockChecked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stockMarketJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(forexChecked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(forexMarketJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stockMarketJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(forexMarketJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cryptoChecked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cryptoMarketJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(assetChecked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(assetMarketJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stockAdminComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brandJLabel1))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cryptoAdminComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(brandJLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(brandJLabel4)
                                    .addComponent(assetAdminComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(forexAdminComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(brandJLabel3)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cryptoMarketJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(assetMarketJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void stockMarketJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockMarketJLabelMouseClicked
        //todo
    }//GEN-LAST:event_stockMarketJLabelMouseClicked

    private void assetMarketJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assetMarketJLabelMouseClicked
        //todo
    }//GEN-LAST:event_assetMarketJLabelMouseClicked

    private void forexMarketJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forexMarketJLabelMouseClicked
        //todo
    }//GEN-LAST:event_forexMarketJLabelMouseClicked

    private void cryptoMarketJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cryptoMarketJLabelMouseClicked
        //todo
    }//GEN-LAST:event_cryptoMarketJLabelMouseClicked

    private void stockMarketJLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockMarketJLabel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_stockMarketJLabel1MouseClicked

    private void stockMarketJLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockMarketJLabel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_stockMarketJLabel2MouseClicked

    private void stockMarketJLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockMarketJLabel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_stockMarketJLabel3MouseClicked

    private void stockMarketJLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockMarketJLabel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_stockMarketJLabel4MouseClicked

    private void stockMarketJLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockMarketJLabel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_stockMarketJLabel5MouseClicked

    private void stockMarketJLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockMarketJLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_stockMarketJLabel6MouseClicked

    private void stockMarketJLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockMarketJLabel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_stockMarketJLabel7MouseClicked

    private void stockMarketJLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockMarketJLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_stockMarketJLabel8MouseClicked

    private void exitJLabelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_exitJLabelFocusGained
        //TODO
    }//GEN-LAST:event_exitJLabelFocusGained

    private void exitJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitJLabelMouseClicked
        EnterpriseEditJPanel enterpriseEditJPanel = new EnterpriseEditJPanel(ecosystem, account, jSplitPane, browsingJPanel, this.assetMarketLeftButton, this.stockMarketLeftButton, this.forexMarketLeftButton, this.cryptoMarketLeftBUtton);
        this.jSplitPane.setRightComponent(enterpriseEditJPanel);
    }//GEN-LAST:event_exitJLabelMouseClicked

    private void viewJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewJLabelMouseClicked
        EnterpriseViewJPanel enterpriseViewJPanel = new EnterpriseViewJPanel(ecosystem, account, jSplitPane, browsingJPanel, this.assetMarketLeftButton, this.stockMarketLeftButton, this.forexMarketLeftButton, this.cryptoMarketLeftBUtton);
        this.jSplitPane.setRightComponent(enterpriseViewJPanel);
    }//GEN-LAST:event_viewJLabelMouseClicked

    private void viewJLabel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_viewJLabel1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_viewJLabel1FocusGained

    private void viewJLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewJLabel1MouseClicked
        EnterpriseCreateJPanel enterpriseCreateJPanel = new EnterpriseCreateJPanel(ecosystem, account, jSplitPane, browsingJPanel, this.assetMarketLeftButton, this.stockMarketLeftButton, this.forexMarketLeftButton, this.cryptoMarketLeftBUtton);
        this.jSplitPane.setRightComponent(enterpriseCreateJPanel);
    }//GEN-LAST:event_viewJLabel1MouseClicked

    private void assetAdminComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assetAdminComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assetAdminComboBoxActionPerformed

    private void stockAdminComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockAdminComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockAdminComboBoxActionPerformed

    private void cryptoAdminComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cryptoAdminComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cryptoAdminComboBoxActionPerformed

    private void forexAdminComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forexAdminComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forexAdminComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField assetAdminComboBox;
    private javax.swing.JLabel assetChecked;
    private javax.swing.JLabel assetMarketJLabel;
    private javax.swing.JPanel assetMarketJPanel;
    private javax.swing.JLabel banksChecked;
    private javax.swing.JLabel brandJLabel1;
    private javax.swing.JLabel brandJLabel2;
    private javax.swing.JLabel brandJLabel3;
    private javax.swing.JLabel brandJLabel4;
    private javax.swing.JLabel brokersChecked;
    private javax.swing.JLabel companiesChecked;
    private javax.swing.JTextField cryptoAdminComboBox;
    private javax.swing.JLabel cryptoChecked;
    private javax.swing.JLabel cryptoMarketJLabel;
    private javax.swing.JPanel cryptoMarketJPanel;
    private javax.swing.JLabel exitJLabel;
    private javax.swing.JTextField forexAdminComboBox;
    private javax.swing.JLabel forexChecked;
    private javax.swing.JLabel forexMarketJLabel;
    private javax.swing.JPanel forexMarketJPanel;
    private javax.swing.JLabel industriesChecked;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jewelleyChecked;
    private javax.swing.JLabel mutualChecked;
    private javax.swing.JLabel realestateChecked;
    private javax.swing.JTextField stockAdminComboBox;
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
    private javax.swing.JLabel viewJLabel;
    private javax.swing.JLabel viewJLabel1;
    private javax.swing.JLabel walletChecked;
    // End of variables declaration//GEN-END:variables

}
