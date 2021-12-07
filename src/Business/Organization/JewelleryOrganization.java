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
public class JewelleryOrganization extends Organization {

    private String companyName;
    private Organization.Type type;
    private String name;
    private UserAccount admin;
    private HashMap<String, HashMap<String, Object>> jewelleries = new HashMap<String, HashMap<String, Object>>();

    public JewelleryOrganization(String companyName,Organization.Type type,String name, UserAccount admin, HashMap<String, HashMap<String, Object>> jewelleries, Date doc) {
        super(Organization.Type.Jewellery.getValue(), name, doc, "");
        this.companyName=companyName;
        this.type = type;
        this.name = name;
        this.admin = admin;
        this.jewelleries = jewelleries;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {

        return null;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the admin
     */
    public UserAccount getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(UserAccount admin) {
        this.admin = admin;
    }

    /**
     * @return the jewelleries
     */
    public HashMap<String, HashMap<String, Object>> getJewelleries() {
        return jewelleries;
    }

    /**
     * @param jewelleries the jewelleries to set
     */
    public void setJewelleries(HashMap<String, HashMap<String, Object>> jewelleries) {
        this.jewelleries = jewelleries;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
