/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;

/**
 *
 * @author prathameshnemade
 */
public class SystemAdminAccount extends UserAccount {

    public SystemAdminAccount(Employee employee, String username, String password) {
        super(username, password, employee);
    }
}
