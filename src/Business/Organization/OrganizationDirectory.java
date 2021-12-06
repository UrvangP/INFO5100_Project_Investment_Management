/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;
import Business.Organization.Organization.Type;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ronak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type, String name, Date doc, UserAccount admin){
        Organization organization = null;
        if (type.getValue().equals(Type.Companies.getValue())){
            organization = new CompaniesOrganization(name, doc, admin);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.MutualFunds.getValue())){
            organization = new MutualFundsOrganization(name, doc);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Industries.getValue())){
            organization = new IndustriesOrganization(name, doc);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.RealEstate.getValue())){
            organization = new RealEstateOrganization(name, doc);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Jewellery.getValue())){
            organization = new JewelleryOrganization(name, doc);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Banks.getValue())){
            organization = new BanksOrganization(name, doc);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Brokers.getValue())){
            organization = new BrokersOrganization(name, doc);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Wallet.getValue())){
            organization = new WalletOrganization(name, doc);
            organizationList.add(organization);
        }

        return organization;
    }
    
    public void removeOrganization(Organization org){
        organizationList.remove(org);
    }
    
    public Organization getOrganization(String name){
        for(Organization o : organizationList){
            if(o.getName().equalsIgnoreCase(name)){
                return o;
            }
        }
        return null;
    }

}
