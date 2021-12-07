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
public class IndustriesOrganization extends Organization {

    private String companyName;
    private Organization.Type type;
    private String name;
    private UserAccount admin;
    private HashMap<String, HashMap<String, Object>> industries = new HashMap<String, HashMap<String, Object>>();

    public IndustriesOrganization(String companyName, Organization.Type type, String name, UserAccount admin, HashMap<String, HashMap<String, Object>> industries, Date doc) {
        super(companyName, Organization.Type.Industries.getValue(), doc, null);
        this.companyName = companyName;
        this.type = type;
        this.name = name;
        this.admin = admin;
        this.industries = industries;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {

        return null;
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

    /**
     * @param type the type to set
     */
    public void setType(Organization.Type type) {
        this.type = type;
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
     * @return the industries
     */
    public HashMap<String, HashMap<String, Object>> getIndustries() {
        return industries;
    }

    /**
     * @param industries the industries to set
     */
    public void setIndustries(HashMap<String, HashMap<String, Object>> industries) {
        this.industries = industries;
    }

}
