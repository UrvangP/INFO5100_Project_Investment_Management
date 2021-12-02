/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Restaurant.Restaurant;
import Business.UserAccount.UserAccount;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author raunak
 */
public abstract class WorkRequest {

    private String message; //use this for comments
    private Restaurant sender; //from order
    private UserAccount receiver; //to order
    private String status; //overall status of order - inprogress/completed
    private Date requestDate; //ordered date
    private Date resolveDate; //order completed date
    private HashMap<HashMap<String, Double>, Integer> orderedMenu; //ordered items
    private String address; //address to deliver

    public WorkRequest(String address,
            UserAccount customerName,
            HashMap<HashMap<String, Double>, Integer> orderGenerated,
            Restaurant selectedRestaurant,
            String mainOrderMessage,
            String overAllStatus,
            Date requestDate) {
        this.message = mainOrderMessage;
        this.sender = selectedRestaurant;
        this.receiver = customerName;
        this.status = overAllStatus;
        this.requestDate = requestDate;
        this.resolveDate = null;
        this.orderedMenu = orderGenerated;
        this.address = address;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Restaurant getSender() {
        return sender;
    }

    public void setSender(Restaurant sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    /**
     * @return the orderedMenu
     */
    public HashMap<HashMap<String, Double>, Integer> getOrderedMenu() {
        return orderedMenu;
    }

    /**
     * @param orderedMenu the orderedMenu to set
     */
    public void setOrderedMenu(HashMap<HashMap<String, Double>, Integer> orderedMenu) {
        this.orderedMenu = orderedMenu;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
