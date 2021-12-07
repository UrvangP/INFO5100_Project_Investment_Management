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
import java.util.HashMap;

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

    public Organization createJewelleryOrganization(String companyName, Organization.Type type, String name, UserAccount admin, HashMap<String, HashMap<String, Object>> jewelleries, Date doc) {
        Organization organization = new JewelleryOrganization(companyName, type, name, admin, jewelleries, doc);
        organizationList.add(organization);
        return organization;
    }

    public Organization createRealEstateOrganization(String companyName, Organization.Type type, String name, UserAccount admin, HashMap<String, HashMap<String, Object>> estates, Date doc) {
        Organization organization = new RealEstateOrganization(companyName, type, name, admin, estates, doc);
        organizationList.add(organization);
        return organization;
    }


    public Organization createCompanyOrganization(String name, UserAccount admin, Date doc, String country, int price, long revenue) {
        Organization org = new CompaniesOrganization(name, doc, admin, country, price, revenue);
        organizationList.add(org);
        return org;
    }
    
    public Organization createMutualFundOrganization(String name, UserAccount admin, Date doc, String country, ArrayList<Organization> funds){
        Organization org = new MutualFundsOrganization(name, doc, admin, country, funds);
        organizationList.add(org);
        return org;
    }

    public Organization createIndustryOrganization(String companyName, Organization.Type type, String name, UserAccount admin, HashMap<String, HashMap<String, Object>> industries, Date doc) {
        Organization organization = new IndustriesOrganization(companyName, type, name, admin, industries, doc);
        organizationList.add(organization);
        return organization;
    }

    public Organization createOrganization(Type type, String name, Date doc) {
        Organization organization = null;
        if (type.getValue().equals(Type.Companies.getValue())) {
            //organization = new CompaniesOrganization(name, doc);
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.MutualFunds.getValue())) {
            //organization = new MutualFundsOrganization(name, doc);
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Industries.getValue())) {
            //organization = new IndustriesOrganization(name, doc);
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.RealEstate.getValue())) {
            //  organization = new RealEstateOrganization(name, doc);
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Jewellery.getValue())) {
//            organization = new JewelleryOrganization(name, doc);
//            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Banks.getValue())) {
            organization = new BanksOrganization(name, doc);
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Brokers.getValue())) {
            organization = new BrokersOrganization(name, doc);
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Wallet.getValue())) {
            organization = new WalletOrganization(name, doc);
            organizationList.add(organization);
        }

        return organization;
    }

    public void removeOrganization(Organization org) {
        organizationList.remove(org);
    }

    public Organization getOrganization(String name) {
        for (Organization o : organizationList) {
            if (o.getName().equalsIgnoreCase(name)) {
                return o;
            }
        }
        return null;
    }

}
