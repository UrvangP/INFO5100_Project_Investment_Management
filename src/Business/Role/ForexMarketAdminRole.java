/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.ForexMarketAdminRole.ForexMarketAdminJPanel;

/**
 *
 * @author harold
 */
public class ForexMarketAdminRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, EcoSystem business, JPanel browsingJPanel) {
        return new ForexMarketAdminJPanel(userProcessContainer, account, business, browsingJPanel);//To change body of generated methods, choose Tools | Templates.
    }

}
