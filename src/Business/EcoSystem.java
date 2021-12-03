/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Organization.Organization;
import Business.Customer.CustomerDirectory;
import Business.DeliveryMan.DeliveryManDirectory;
import Business.Network.NetworkDirectory;
import Business.Restaurant.RestaurantDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author MyPC1
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private RestaurantDirectory restaurantDirectory;
    private CustomerDirectory customerDirectory;
    private DeliveryManDirectory deliveryManDirectory;
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

    public EcoSystem(RestaurantDirectory restaurantDirectory, CustomerDirectory customerDirectory, DeliveryManDirectory deliveryManDirectory, WorkQueue workQueue, NetworkDirectory networkList) {

        this.restaurantDirectory = restaurantDirectory;
        this.customerDirectory = customerDirectory;
        this.deliveryManDirectory = deliveryManDirectory;
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
        this.deliveryManDirectory = new DeliveryManDirectory();
        // networkList=new ArrayList<Network>();
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
}
