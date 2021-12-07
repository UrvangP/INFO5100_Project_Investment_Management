/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Customer.CustomerDirectory;
import Business.Network.Network;
import Business.Network.NetworkDirectory;
import Business.Organization.Organization;
import Business.Restaurant.RestaurantDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author MyPC1
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private RestaurantDirectory restaurantDirectory;
    private CustomerDirectory customerDirectory;
    private NetworkDirectory networkList;
    private HashMap<String, String> roleList = new HashMap<String, String>() {
        {
            put("AssetAgentRole", "Business.Role.AssetAgentRole");
            put("AssetMarketAdminRole", "Business.Role.AssetMarketAdminRole");
            put("CompanyAgentRole", "Business.Role.CompanyAgentRole");
            put("CryptoAgentRole", "Business.Role.CryptoAgentRole");
            put("CryptoMarketAdminRole", "Business.Role.CryptoMarketAdminRole");
            put("CustomerRole", "Business.Role.CustomerRole");
            put("ForexAgentRole", "Business.Role.ForexAgentRole");
            put("ForexMarketAdminRole", "Business.Role.ForexMarketAdminRole");
            put("MutualFundsAgentRole", "Business.Role.MutualFundsAgentRole");
            put("StockMarketAdminRole", "Business.Role.StockMarketAdminRole");
            put("SystemAdminRole", "Business.Role.SystemAdminRole");

        }
    };

    public EcoSystem(RestaurantDirectory restaurantDirectory, CustomerDirectory customerDirectory, WorkQueue workQueue, NetworkDirectory networkList) {

        this.restaurantDirectory = restaurantDirectory;
        this.customerDirectory = customerDirectory;
        this.networkList = networkList;
    }

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public EcoSystem() {
        super(null, null, null, null);
        this.restaurantDirectory = new RestaurantDirectory();
        this.customerDirectory = new CustomerDirectory();
        this.networkList = new NetworkDirectory();
    }

    public RestaurantDirectory getRestaurantDirectory() {
        return this.restaurantDirectory;
    }

    public boolean checkIfUserIsUnique(String userName) {
        //
        return false;
    }

    public HashMap<String, String> getRolesList() {
        return roleList;
    }

    public NetworkDirectory getNetwork() {
        return networkList;
    }

    public Network createNetwork(Network network) {
        networkList.getNetworkList().add(network);
        return network;
    }

//    public void generateBrowsingHistoryNetwork(JPanel browsingJPanel) {
//        String value = "Not Selected";
//        for (int i = 0; i < this.getNetwork().getNetworkList().size(); i++) {
//            Network ongoing = this.getNetwork().getNetworkList().get(i);
//            if (ongoing.getIsSelected()) {
//                value = "Selected: " + ongoing.getNCountry() + " - " + ongoing.getNName();
//            }
//        }
//        JLabel tempText = (JLabel) browsingJPanel.getComponent(0);
//        tempText.setText("Network ( " + value + " )");
//    }
    public void generateBrowsingHistoryEnterprise(JPanel browsingJPanel) {
        String value = "Not Selected";
        Network ongoing = null;
        Integer index = null;
        for (int i = 0; i < this.getNetwork().getNetworkList().size(); i++) {
            Network ongoing1 = this.getNetwork().getNetworkList().get(i);
            if (ongoing1.getIsSelected()) {
                ongoing = ongoing1;
                index = i;
                value = "Selected: " + ongoing.getNCountry() + " - " + ongoing.getNName();
            }
        }

        if (ongoing == null || index == null) {
            JLabel tempText = (JLabel) browsingJPanel.getComponent(0);
            tempText.setText("Network ( " + value + " ) ---> ");
            return;
        }
        value = "Network ( " + value + " ) ---> ";
        ArrayList<String> value2 = new ArrayList<String>();
        this.networkList.getNetworkList().get(index).getEnterpriseDirectory().getEnterpriseSelection();
        for (HashMap.Entry<String, HashMap<String, Boolean>> out1
                : this.networkList.getNetworkList().get(index).getEnterpriseDirectory().getEnterpriseSelection().entrySet()) {
            ArrayList<String> temp1 = new ArrayList<String>();
            if (out1.getValue() != null) {
                for (Entry<String, Boolean> out2
                        : out1.getValue().entrySet()) {
                    if (out2.getValue()) {
                        temp1.add(out2.getKey());
                    }
                }
            }
            if (!temp1.isEmpty()) {
                value2.add(out1.getKey() + " : " + String.join("/", temp1));
            }

        }
        JLabel tempText = (JLabel) browsingJPanel.getComponent(0);
        String temp = value2.isEmpty() ? "Not Selected" : String.join(", ", value2);
        tempText.setText(value + "Enterprise ( " + temp + " )");
    }
}
