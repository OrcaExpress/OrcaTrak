package incomplete;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Represents an address
 */
@Embeddable
public class Address implements java.io.Serializable {

    /**
     * Street name - first line
     */
    protected String streetAddress;

    /**
     * City
     */
    protected String city;
    /**
     * State
     */
    protected String state;
    /**
     * Zip code
     */
    protected String zipCode;
    /**
     * Country
     */
    protected String country;

    /**
     * No arg default constructor. Required for JPA.
     */
    public Address() {
        // No arg default constructor
    }

    /**
     * Constructor
     * @param streetAddress 
     * @param city - city
     * @param state - state
     * @param zipCode - zip code
     * @param country - country
     */
    public Address(String streetAddress, String city, String state, String zipCode, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    /**
     * Returns the street address
     * @return street address
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Returns the city
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns the state
     * @return state
     */
    @Column(name = "STATE_CODE")
    public String getState() {
        return state;
    }

    /**
     * Returns the country
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Returns the zip code
     * @return zip code
     */
    @Column(name = "ZIP_CODE")
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the street name 
     * @param streetAddress 
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * Sets the city
     * @param city - city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets the state
     * @param state - state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Sets the country
     * @param country - country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Sets the zip code
     * @param zipCode - zip code
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
