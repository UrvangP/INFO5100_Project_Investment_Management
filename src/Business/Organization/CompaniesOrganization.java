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
public class CompaniesOrganization extends Organization{
    
    UserAccount admin;
    
    public CompaniesOrganization(String name, Date doc, UserAccount admin){
        super(Organization.Type.Companies.getValue(), name, doc);
        this.admin = admin;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {

        return null;    
    }
    
}
