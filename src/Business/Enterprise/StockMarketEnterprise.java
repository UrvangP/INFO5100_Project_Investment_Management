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
public class StockMarketEnterprise extends Enterprise {

    private Boolean isSelected;
    public String name;
    public Date dateOfCreation;
    public String country;
    public UserAccount createdBy;
    public UserAccount admin;

    public StockMarketEnterprise(String name, Enterprise.EnterpriseType type, Date dateOfCreation, String country, UserAccount createdBy, UserAccount admin) {
        super(EnterpriseType.StockMarket);
        this.name = name;
        this.dateOfCreation = dateOfCreation;
        this.country = country;
        this.createdBy = createdBy;
        this.admin = admin;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the isSelected
     */
    public Boolean getIsSelected() {
        return isSelected;
    }

    /**
     * @param isSelected the isSelected to set
     */
    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }
}
