/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author raunak
 */
public abstract class WorkRequest {

    private UserAccount raisedBy;
    private UserAccount raisedTo;
    private Date requestDate;
    private Date resolveDate;

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

    private StatusType overAllStatus;

    public WorkRequest(UserAccount raisedBy, UserAccount raisedTo, StatusType overAllStatus, Date requestDate, Date resolveDate) {
        this.raisedBy = raisedBy;
        this.raisedTo = raisedTo;
        this.overAllStatus = overAllStatus;
        this.requestDate = requestDate;
        this.resolveDate = resolveDate;
    }

    /**
     * @return the raisedBy
     */
    public UserAccount getRaisedBy() {
        return raisedBy;
    }

    /**
     * @param raisedBy the raisedBy to set
     */
    public void setRaisedBy(UserAccount raisedBy) {
        this.raisedBy = raisedBy;
    }

    /**
     * @return the raisedTo
     */
    public UserAccount getRaisedTo() {
        return raisedTo;
    }

    /**
     * @param raisedTo the raisedTo to set
     */
    public void setRaisedTo(UserAccount raisedTo) {
        this.raisedTo = raisedTo;
    }

    /**
     * @return the overAllStatus
     */
    public StatusType getOverAllStatus() {
        return overAllStatus;
    }

    /**
     * @param overAllStatus the overAllStatus to set
     */
    public void setOverAllStatus(StatusType overAllStatus) {
        this.overAllStatus = overAllStatus;
    }

    /**
     * @return the requestDate
     */
    public Date getRequestDate() {
        return requestDate;
    }

    /**
     * @param requestDate the requestDate to set
     */
    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    /**
     * @return the resolveDate
     */
    public Date getResolveDate() {
        return resolveDate;
    }

    /**
     * @param resolveDate the resolveDate to set
     */
    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

}
