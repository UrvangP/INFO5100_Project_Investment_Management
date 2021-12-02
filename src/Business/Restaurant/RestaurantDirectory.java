/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author harold
 */
public class RestaurantDirectory {

    private ArrayList<Restaurant> restaurantList;

    public RestaurantDirectory() {
        restaurantList = new ArrayList<>();
    }

    public ArrayList<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public Restaurant createrestaurant(String name, String managerUserName, HashMap<String, Double> menu, String location, String contact) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setManagerUserName(managerUserName);
        restaurant.setMenu(menu);
        restaurant.setLocation(location);
        restaurant.setContact(contact);
        restaurantList.add(restaurant);
        return restaurant;
    }

    public String validatePrice(String price) {
        String isValid = "";
        try {
            Double seat = Double.parseDouble(price);
        } catch (Exception e) {
            isValid = "Price should be a number! \n";
        }
        if (price.equals("Enter here")) {
            isValid = "Price is invalid! \n";
        }

        return isValid;
    }

    public String validateName(String city) {
        String isValid = "";
        if (city.equals("")) {
            isValid = "Menu name cannot be empty! \n";
        } else if (city.length() < 2 || city.length() > 30) {
            isValid = "Menu name should be of minimum 2 characters and maximum 30 character! \n";
        } else if (!city.matches("[a-zA-Z0-9 ]{2,30}")) {
            isValid = "Invalid Menu name! \n";
        } else if (city.equals("Enter here")) {
            isValid = "Name is invalid! \n";
        }
        return isValid;
    }
}
