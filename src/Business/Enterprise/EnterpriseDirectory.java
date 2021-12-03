/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author urvang
 */
public class EnterpriseDirectory {

    public ArrayList<Enterprise> getEnterpriseDir() {
        return enterpriseDir;
    }

    public void setEnterpriseDir(ArrayList<Enterprise> enterpriseDir) {
        this.enterpriseDir = enterpriseDir;
    }
    
    private ArrayList<Enterprise> enterpriseDir;
    
    public EnterpriseDirectory(){
        enterpriseDir = new ArrayList();
    }
    
}
