/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author urvang
 */
public class EnterpriseDirectory {

    private HashMap<String, HashMap<String, Boolean>> enterpriseSelection = new HashMap<String, HashMap<String, Boolean>>();

    public ArrayList<Enterprise> getEnterpriseDir() {
        return enterpriseDir;
    }

    public void setEnterpriseDir(ArrayList<Enterprise> enterpriseDir) {
        this.enterpriseDir = enterpriseDir;
    }

    private ArrayList<Enterprise> enterpriseDir;

    public EnterpriseDirectory() {
        enterpriseDir = new ArrayList();
    }

    public Enterprise createAssetMarketEnterprise(String name, Date dateOfCreation, String country, UserAccount admin) {
        System.out.println("SDSD" + name + Enterprise.EnterpriseType.AssetMarket + dateOfCreation + country + admin);
        AssetMarketEnterprise enterprise = new AssetMarketEnterprise(name, Enterprise.EnterpriseType.AssetMarket, dateOfCreation, country, admin);
        this.enterpriseDir.add(enterprise);
        return enterprise;
    }

    public Enterprise createCryptoMarketEnterprise(String name, Date dateOfCreation, String country, UserAccount admin) {
        CryptoMarketEnterprise enterprise = new CryptoMarketEnterprise(name, Enterprise.EnterpriseType.CryptoMarket, dateOfCreation, country, admin);
        this.enterpriseDir.add(enterprise);
        return enterprise;
    }

    public Enterprise createForexMarketEnterprise(String name, Date dateOfCreation, String country, UserAccount admin) {
        ForexMarketEnterprise enterprise = new ForexMarketEnterprise(name, Enterprise.EnterpriseType.ForexMarket, dateOfCreation, country, admin);
        this.enterpriseDir.add(enterprise);
        return enterprise;
    }

    public Enterprise createStockMarketEnterprise(String name, Date dateOfCreation, String country, UserAccount admin) {
        StockMarketEnterprise enterprise = new StockMarketEnterprise(name, Enterprise.EnterpriseType.StockMarket, dateOfCreation, country, admin);
        this.enterpriseDir.add(enterprise);
        return enterprise;
    }

    public HashMap<String, HashMap<String, Boolean>> getEnterpriseSelection() {
        return enterpriseSelection;
    }

}
