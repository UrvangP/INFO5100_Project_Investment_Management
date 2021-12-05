/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ronak
 */
public class MutualFundsOrganization extends Organization{
    
    public MutualFundsOrganization(String name, Date doc){
        super(Organization.Type.MutualFunds.getValue(), name, doc);
        
    }

    @Override
    public ArrayList<Role> getSupportedRole() {

        return null;    
    }
    
}
