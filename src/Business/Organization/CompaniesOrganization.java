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
    int stockPrice;
    long revenue;
    
    public CompaniesOrganization(String name, Date doc, UserAccount admin, String country, int stockPrice, long revenue){
        super(Organization.Type.Companies.getValue(), name, doc, country);
        this.admin = admin;
        this.stockPrice = stockPrice;
        this.revenue = revenue;
    }

    public int getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(int stockPrice) {
        this.stockPrice = stockPrice;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {

        return null;    
    }
    
}
