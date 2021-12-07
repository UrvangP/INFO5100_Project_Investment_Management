/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.StockMarket;

import Business.Enterprise.EnterpriseDirectory;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author urvang
 */
public class Company {
    
    private String cName;
    private String cCountry;
    private Date cDateOfCreation;
    private UserAccount cCreatedBy;
    private UserAccount admin;
    
    public Company(String name, String country, UserAccount createdBy, UserAccount ad){
        cName = name;
        cCountry = country;
        //cDateOfCreation = doc;
        cCreatedBy = createdBy;
        admin = ad;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcCountry() {
        return cCountry;
    }

    public void setcCountry(String cCountry) {
        this.cCountry = cCountry;
    }

    public Date getcDateOfCreation() {
        return cDateOfCreation;
    }

    public void setcDateOfCreation(Date cDateOfCreation) {
        this.cDateOfCreation = cDateOfCreation;
    }

    public UserAccount getcCreatedBy() {
        return cCreatedBy;
    }

    public void setcCreatedBy(UserAccount cCreatedBy) {
        this.cCreatedBy = cCreatedBy;
    }

    public UserAccount getAdmin() {
        return admin;
    }

    public void setAdmin(UserAccount admin) {
        this.admin = admin;
    }
    
}
