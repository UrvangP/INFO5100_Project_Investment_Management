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
public class RealEstateOrganization extends Organization {

    private String companyName;
    private Organization.Type type;
    private String name;
    private UserAccount admin;
    private HashMap<String, HashMap<String, Object>> estates = new HashMap<String, HashMap<String, Object>>();

    public RealEstateOrganization(String companyName, Organization.Type type, String name, UserAccount admin, HashMap<String, HashMap<String, Object>> estates, Date doc) {
        super(companyName, Organization.Type.RealEstate.getValue(), doc, null);
        this.companyName = companyName;
        this.type = type;
        this.name = name;
        this.admin = admin;
        this.estates = estates;

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
     * @return the estates
     */
    public HashMap<String, HashMap<String, Object>> getEstates() {
        return estates;
    }

    /**
     * @param estates the estates to set
     */
    public void setEstates(HashMap<String, HashMap<String, Object>> estates) {
        this.estates = estates;
    }
}
