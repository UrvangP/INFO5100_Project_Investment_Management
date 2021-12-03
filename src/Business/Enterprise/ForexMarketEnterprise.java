/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author prathameshnemade
 */
public class ForexMarketEnterprise extends Enterprise {

    public ForexMarketEnterprise(String name, Enterprise.EnterpriseType type, Date dateOfCreation, String country, UserAccount admin) {
        super(Enterprise.EnterpriseType.ForexMarket);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
