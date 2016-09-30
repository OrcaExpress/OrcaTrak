package com.orcatrak.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Temporal;

/**
 * Represents a user
 */
public class User implements Serializable {

    /**
     * first name
     */
    private String firstName;

    /**
     * last name
     */
    private String lastName;

    /**
     * User's picture
     */
    private byte[] picture;

    /**
     * Birthday
     
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDate;*/

    /**
     * Default constructor
     */
    public User() {
        // empty
    }


    /**
     * Constructs a new user given basic information
     * @param firstName - first name
     * @param lastName - last name
     */
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns first name
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name
     * @param firstName - first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName.toUpperCase();
    }

    /**
     * Returns user's last name
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name
     * @param lastName - last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the birthday
     * @return birthday
     
    public Date getBirthDate() {
        return birthDate;
    }*/

    /**
     * Sets the birthday
     * @param birthDate - birth date
     
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }*/
}
