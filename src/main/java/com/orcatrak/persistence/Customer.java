package com.orcatrak.persistence;

import com.orcatrak.constraints.Email;
import com.orcatrak.constraints.ZipCode;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author java ee
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

    @Column(name = "PICTURE")
    protected Byte[] picture; //use byte because integer is 32bits & 1byte is 8bits; useful when reading stream of bits i.e pics; 1 char is 1 byte or 8 bits. machines reads bytes

    @Id
    @GeneratedValue
    @Column(name = "CUSTOMER_ID")
    protected Long customerId;

    @NotNull(message = "Enter a valid first name. Must be between {min} and {max} characters")
    protected String firstName;

    @NotNull(message = "Enter a valid last name.  Must be between {min} and {max} characters")
    protected String lastName;
    
//    @Min(value = 18, message = "customer too young")
//    protected int age;

//    @Phone
    protected String telephone;

    @Email
    protected String email;
    
    @Email(message = "recovery email is invalid")
    protected String recoveryEmail;


//    @Phone
    protected String fax;

    @NotNull
    @Size(min = 2, max = 20)
    protected String streetAddress;

//    @City
    protected String city;

//    @State
    protected String state;

    @ZipCode
    protected String zip;

    public Customer() {
    }

    public Customer(Long customerId, String firstName, String telephone, String email, String streetAddress, String city, String state, String zip) {
        this.firstName = firstName;
        this.telephone = telephone;
        this.email = email;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Byte[] getPicture() {
        return picture;
    }

    public void setPicture(Byte[] picture) {
        this.picture = picture;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}