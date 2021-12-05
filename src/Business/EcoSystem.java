/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Organization.Organization;
import Business.Customer.CustomerDirectory;
import Business.Network.Network;
import Business.Network.NetworkDirectory;
import Business.Restaurant.RestaurantDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.WorkQueue.WorkQueue;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
        super(null, null, null, null, 0);
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

    public void generateBrowsingHistoryNetwork(JPanel browsingJPanel) {
        String value = "Not Selected";
        for (int i = 0; i < this.getNetwork().getNetworkList().size(); i++) {
            Network ongoing = this.getNetwork().getNetworkList().get(i);
            if (ongoing.getIsSelected()) {
                value = "Selected: " + ongoing.getNCountry() + " - " + ongoing.getNName();
            }
        }
        JLabel tempText = (JLabel) browsingJPanel.getComponent(0);
        tempText.setText("Network ( " + value + " ) -->");
    }
}
