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
public class ForexBuyWorkRequest extends WorkRequest {

    public enum StatusType {
        Initiated("INITIATED"),
        Awaiting("AWAITING"),
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
        this.forexName = assetName;
        this.oraganization = oraganization;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getForexName() {
        return forexName;
    }

    public void setForexName(String forexName) {
        this.forexName = forexName;
    }

    public Object getOraganization() {
        return oraganization;
    }

    public void setOraganization(Object oraganization) {
        this.oraganization = oraganization;
    }

}
