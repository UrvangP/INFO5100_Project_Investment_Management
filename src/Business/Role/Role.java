/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;

import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {

    public enum RoleType {        
        SysAdmin("Sysadmin"),
        Customer("Customer"),
        StockMarketAdmin("StockMarketAdmin"),
        AssetMarketAdmin("AssetMarketAdmin"),
        ForexMarketAdmin("ForexMarketAdmin"),
        CryptoMarketAdmin("CryptoMarketAdmin"),
        CompanyAgent("CompanyAgent"),
        MutualFundsAgent("MutualFundsAgent"),
        ForexAgent("ForexAgent"),
        CryptoAgent("CryptoAgent"),
        AssetAgent("AssetAgent");

        private String value;

        private RoleType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    RoleType roleType;

    public void Role(RoleType role) {
        this.roleType = role;
    }

    public abstract JPanel createWorkArea(JPanel userProcessContainer,
            UserAccount account,
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }

}
