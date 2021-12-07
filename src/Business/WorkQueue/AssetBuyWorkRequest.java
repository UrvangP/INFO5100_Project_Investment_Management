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
 * @author prathameshnemade
 */
public class AssetBuyWorkRequest extends WorkRequest {

    public enum StatusType {
        Initiated("INITIATED"),
        Completed("COMPLETED"),
        Cancelled("CANCELLED");

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
    private String assetName;
    private Object oraganization;

    public AssetBuyWorkRequest(
            UserAccount raisedBy,
            UserAccount raisedTo,
            WorkRequest.StatusType overAllStatus,
            Date requestDate,
            Date resolveDate,
            StatusType status,
            Integer price,
            Integer quantity,
            Date modifiedAt,
            String companyName,
            String assetName,
            Object oraganization) {
        super(raisedBy, raisedTo, overAllStatus, requestDate, resolveDate);
        this.statusType = status;
        this.price = price;
        this.quantity = quantity;
        this.modifiedAt = modifiedAt;
        this.companyName = companyName;
        this.assetName = assetName;
        this.oraganization = oraganization;
    }

    /**
     * @return the statusType
     */
    public StatusType getStatusType() {
        return statusType;
    }

    /**
     * @param statusType the statusType to set
     */
    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    /**
     * @return the price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the modifiedAt
     */
    public Date getModifiedAt() {
        return modifiedAt;
    }

    /**
     * @param modifiedAt the modifiedAt to set
     */
    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the assetName
     */
    public String getAssetName() {
        return assetName;
    }

    /**
     * @param assetName the assetName to set
     */
    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    /**
     * @return the oraganization
     */
    public Object getOraganization() {
        return oraganization;
    }

    /**
     * @param oraganization the oraganization to set
     */
    public void setOraganization(Object oraganization) {
        this.oraganization = oraganization;
    }

}
