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
public class BanksOrganization extends Organization{
    
    private String bankName;
    private Organization.Type type;
    private String name;
    private UserAccount admin;
    private HashMap<String, HashMap<String, Object>> bank = new HashMap<String, HashMap<String, Object>>();
    
    public BanksOrganization(String bankName,Organization.Type type,String name, UserAccount admin, HashMap<String, HashMap<String, Object>> jewelleries, Date doc){
        super(Organization.Type.Banks.getValue(), name, doc, "");
        this.bankName=bankName;
        this.type = type;
        this.name = name;
        this.admin = admin;
        this.bank = bank;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {

        return null;    
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserAccount getAdmin() {
        return admin;
    }

    public void setAdmin(UserAccount admin) {
        this.admin = admin;
    }

    public HashMap<String, HashMap<String, Object>> getBank() {
        return bank;
    }

    public void setBank(HashMap<String, HashMap<String, Object>> bank) {
        this.bank = bank;
    }
    
    
}
