package com.orcatrak.persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author java ee  
 *
 */

//@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

    @Column(name = "PICTURE")
    protected Byte[] picture; //use byte because integer is 32bits & 1byte is 8bits; useful when reading stream of bits i.e pics; 1 char is 1 byte or 8 bits. machines reads bytes

    @Id
    @GeneratedValue
    @Column(name = "CLIENT_ID")
    protected Long clientId;

    @NotNull(message = "Enter a valid first name. Must be between {min} and {max} characters")
    protected String firstName;

    @NotNull(message = "Enter a valid last name.  Must be between {min} and {max} characters")
    protected String lastName;

    protected String telephone;

    @Email
    protected String email;

    @Email(message = "recovery email is invalid")
    protected String recoveryEmail;

    protected String fax;

    protected Address address;

    public Client() {
    }

    public Client(Long clientId, String firstName, String lastName, String telephone, String email, String streetAddress, String city, String state, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.email = email;
    }

    public Byte[] getPicture() {
        return picture;
    }

    public void setPicture(Byte[] picture) {
        this.picture = picture;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRecoveryEmail() {
        return recoveryEmail;
    }

    public void setRecoveryEmail(String recoveryEmail) {
        this.recoveryEmail = recoveryEmail;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
