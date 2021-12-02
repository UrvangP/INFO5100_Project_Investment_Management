/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import java.util.HashMap;

/**
 *
 * @author harold
 */
public class Restaurant {

    private String name;
    private String managerUserName;
    private HashMap<String, Double> menu;
    private String location;
    private String contact;

    public String validateName(String city) {
        String isValid = "";
        if (city.equals("")) {
            isValid = "Restaurant name cannot be empty! \n";
        } else if (city.length() < 2 || city.length() > 30) {
            isValid = "Restaurant name should be of minimum 2 characters and maximum 30 character! \n";
        } else if (!city.matches("[a-zA-Z ]{2,30}")) {
            isValid = "Invalid Restaurant name! \n";
        } else if (city.equals("Enter here")) {
            isValid = "Contact No. is invalid! \n";
        }
        return isValid;
    }

    public String validateManagerName(String city) {
        String isValid = "";
        if (city.equals("")) {
            isValid = "Manager name cannot be empty! \n";
        } else if (city.equals("Enter here")) {
            isValid = "Contact No. is invalid! \n";
        }
        return isValid;
    }

    public String validateLocationName(String city) {
        String isValid = "";
        if (city.equals("")) {
            isValid = "Location name cannot be empty! \n";
        } else if (city.length() < 2 || city.length() > 30) {
            isValid = "Location name should be of minimum 2 characters and maximum 30 character! \n";
        } else if (!city.matches("[a-zA-Z ]{2,30}")) {
            isValid = "Invalid Location name! \n";
        } else if (city.equals("Enter here")) {
            isValid = "Contact No. is invalid! \n";
        }
        return isValid;
    }

    public String validateContact(String city) {
        String isValid = "";
        if (city.equals("")) {
            isValid = "Contact No. cannot be empty! \n";
        } else if (!city.matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$")) {
            isValid = "Invalid Contact No.! \n";
        } else if (city.equals("Enter here")) {
            isValid = "Contact No. is invalid! \n";
        }
        return isValid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the managerUserName
     */
    public String getManagerUserName() {
        return managerUserName;
    }

    /**
     * @param managerUserName the managerUserName to set
     */
    public void setManagerUserName(String managerUserName) {
        this.managerUserName = managerUserName;
    }

    /**
     * @return the menu
     */
    public HashMap<String, Double> getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(HashMap<String, Double> menu) {
        this.menu = menu;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }
}
