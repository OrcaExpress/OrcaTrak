package com.orcatrak.persistence;

import java.io.Serializable;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.CreditCardNumber;

/**
 * Billing information
 */
public class Billing implements Serializable {

    /**
     * Billing id
     */
    protected long billingId;

    /**
     * Account number
     */
    @CreditCardNumber
    protected String accountNumber;

    /**
     * Expiration date on the account
     */
    protected String expiryDate;

    /**
     * Security code on the card
     */
    protected String secretCode;

    /**
     * Address associated with the card
     */
    protected Address address;

    /**
     * Returns the billing id
     * @return billing id
     */
    public Long getBillingId() {
        return this.billingId;
    }

    /**
     * Returns the account number
     * @return account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Returns the expiration date
     * @return expiration date
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Returns the secret code
     * @return secret code
     */
    public String getSecretCode() {
        return secretCode;
    }

    /**
     * Returns the address
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Returns the billing id
     * @param billingId - billing id
     */
    public void setBillingId(Long billingId) {
        this.billingId = billingId;
    }

    /**
     * Sets the account number
     * @param accountNumber - account number
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Sets the expiration date
     * @param expiryDate - expiration date
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Sets the secret code
     * @param secretCode - secret code
     */
    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    /**
     * Sets the address
     * @param address - address
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}