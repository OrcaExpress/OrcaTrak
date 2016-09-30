/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orcatrak.persistence;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author java ee
 */
@Named
@RequestScoped
@Entity
@Table(name="QUOTES")
public class Quote {
    private Date quoteDate;
    private Long bol;
    private Double quotePrice;
    private Item item;
    private User user;
    private Client client;

    public Quote() {
    }
    
    public Quote(Double quotePrice, Item item, User user) {
        this.quotePrice = quotePrice;
        this.item = item;
        this.user = user;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getQuoteDate() {
        return quoteDate;
    }

    public void setQuoteDate(Date quoteDate) {
        this.quoteDate = quoteDate;
    }

    @Id
    @GeneratedValue
    @Column(name="BOL_ID")
    public Long getBol() {
        return bol;
    }

    public void setBol(Long bol) {
        this.bol = bol;
    }

    public Double getQuotePrice() {
        return quotePrice;
    }

    public void setQuotePrice(Double quotePrice) {
        this.quotePrice = quotePrice;
    }

    @ManyToOne
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @ManyToOne
    @JoinColumn(name="USER_ID", referencedColumnName="CLIENT_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
