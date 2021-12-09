/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author ronak
 */
public class BrokersOrganization extends Organization{
    
    private String brokerName;
    private Organization.Type type;
    private String name;
    private UserAccount admin;
    private HashMap<String, HashMap<String, Object>> broker = new HashMap<String, HashMap<String, Object>>();
    
     public BrokersOrganization(String brokerName,Organization.Type type,String name, UserAccount admin, HashMap<String, HashMap<String, Object>> broker, Date doc){
        super(Organization.Type.Brokers.getValue(), name, doc, "");
        this.brokerName=brokerName;
        this.type = type;
        this.name = name;
        this.admin = admin;
        this.broker = broker;
        
    }

    @Override
    public ArrayList<Role> getSupportedRole() {

        return null;    
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public UserAccount getAdmin() {
        return admin;
    }

    public void setAdmin(UserAccount admin) {
        this.admin = admin;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, HashMap<String, Object>> getBroker() {
        return broker;
    }

    public void setBroker(HashMap<String, HashMap<String, Object>> broker) {
        this.broker = broker;
    }
    
    
    
}
