/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author ronak
 */
public class ForexBuyWorkRequest extends WorkRequest{

    public enum StatusType {
        Initiated("INITIATED"),
        Completed("COMPLETED"),
        Sold("SOLD"),
        Rejected("REJECTED");

        private String value;

        private StatusType(String value) {
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
    
    private StatusType statusType;
    private Integer price;
    private Integer quantity;
    private Date modifiedAt;
    private String companyName;
    private String forexName;
    private Object oraganization;

    public ForexBuyWorkRequest(
            UserAccount raisedBy,
            UserAccount raisedTo,
            Date requestDate,
            Date resolveDate,
            StatusType status,
            Integer price,
            Integer quantity,
            Date modifiedAt,
            String companyName,
            String assetName,
            Object oraganization) {
        super(raisedBy, raisedTo, requestDate, resolveDate);
        this.statusType = status;
        this.price = price;
        this.quantity = quantity;
        this.modifiedAt = modifiedAt;
        this.companyName = companyName;
        this.forexName = forexName;
        this.oraganization = oraganization;
    }
    
}
