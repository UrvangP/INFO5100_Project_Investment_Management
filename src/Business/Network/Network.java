/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author urvang
 */
public class Network {
    
    private String NName;
    private String NCountry;
    private Date NDateOfCreation;
    private UserAccount NCreatedBy;
    private Boolean isSelected;
    private EnterpriseDirectory enterpriseDirectory = new EnterpriseDirectory();

    /**
     * @return the NName
     */
    public String getNName() {
        return NName;
    }

    /**
     * @param NName the NName to set
     */
    public void setNName(String NName) {
        this.NName = NName;
    }

    /**
     * @return the NCountry
     */
    public String getNCountry() {
        return NCountry;
    }

    /**
     * @param NCountry the NCountry to set
     */
    public void setNCountry(String NCountry) {
        this.NCountry = NCountry;
    }

    /**
     * @return the NDateOfCreation
     */
    public Date getNDateOfCreation() {
        return NDateOfCreation;
    }

    /**
     * @param NDateOfCreation the NDateOfCreation to set
     */
    public void setNDateOfCreation(Date NDateOfCreation) {
        this.NDateOfCreation = NDateOfCreation;
    }

    /**
     * @return the NCreatedBy
     */
    public UserAccount getNCreatedBy() {
        return NCreatedBy;
    }

    /**
     * @param NCreatedBy the NCreatedBy to set
     */
    public void setNCreatedBy(UserAccount NCreatedBy) {
        this.NCreatedBy = NCreatedBy;
    }

    /**
     * @return the enterpriseDirectory
     */
    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    /**
     * @param enterpriseDirectory the enterpriseDirectory to set
     */
    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
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
