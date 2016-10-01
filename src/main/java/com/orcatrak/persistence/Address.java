package com.orcatrak.persistence;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Represents an address
 */
@Embeddable
public class Address implements java.io.Serializable {

    protected String streetAddress;
    
    protected String city;
    
    @Column(name = "STATE_CODE")
    protected String state;
    
    @Column(name = "ZIP_CODE")
    protected String zipCode;
    
    protected String country;

    /**
     * No arg default constructor. Required for JPA.
     */
    public Address() {
        // No arg default constructor
    }

    public Address(String streetAddress, String city, String state, String zipCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
