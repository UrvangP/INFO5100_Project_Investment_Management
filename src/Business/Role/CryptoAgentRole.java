/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.CryptoAgentRole.CryptoAgentJPanel;

/**
 *
 * @author harold
 */
public class CryptoAgentRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, EcoSystem business, JPanel browsingJPanel) {
        return new CryptoAgentJPanel(userProcessContainer, account, business, browsingJPanel);//To change body of generated methods, choose Tools | Templates.
    }

}
