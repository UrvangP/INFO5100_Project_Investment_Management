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

/**
 *
 * @author ronak
 */
public class MutualFundsOrganization extends Organization{
    
    UserAccount admin;
    ArrayList<Organization> companyStocks;

    public ArrayList<Organization> getCompanyStocks() {
        return companyStocks;
    }

    public void setCompanyStocks(ArrayList<Organization> companyStocks) {
        this.companyStocks = companyStocks;
    }
    
    public MutualFundsOrganization(String name, Date doc, UserAccount admin, String country, ArrayList<Organization> funds){
        super(Organization.Type.MutualFunds.getValue(), name, doc, country);
        this.admin = admin;
        this.companyStocks = funds;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {

        return null;    
    }
    
    public MutualFundsOrganization(){
        companyStocks = new ArrayList();
    }
    
}
