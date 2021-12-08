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
public class WalletOrganization extends Organization{
    
    UserAccount admin;
    int price;
    long circulation;
    
    public WalletOrganization(String name, Date doc, String con, UserAccount admin, int price, long circulation){
        super(Organization.Type.Wallet.getValue(), name, doc, con);
        this.admin = admin;
        this.price = price;
        this.circulation = circulation;
    }

    public UserAccount getAdmin() {
        return admin;
    }

    public void setAdmin(UserAccount admin) {
        this.admin = admin;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getCirculation() {
        return circulation;
    }

    public void setCirculation(long circulation) {
        this.circulation = circulation;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {

        return null;    
    }
    
}
