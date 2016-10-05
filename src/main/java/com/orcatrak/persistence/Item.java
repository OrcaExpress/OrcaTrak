package com.orcatrak.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Represents an item on which bidders bid.
 */
//@Entity
//@Table(name = "ITEMS")
public class Item implements Serializable {

    private String itemName;
    private String description;
    private String classificication;
    private int pcs;
    private byte weight;
    private boolean isStackable = false;
    private boolean isHazmat = false;

    public Item(String itemName, String description, String classificication, int pcs, byte weight, boolean isStackable, boolean isHazmat) {
        this.itemName = itemName;
        this.description = description;
        this.classificication = classificication;
        this.pcs = pcs;
        this.weight = weight;
        this.isStackable = isStackable;
        this.isHazmat = isHazmat;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClassificication() {
        return classificication;
    }

    public void setClassificication(String classificication) {
        this.classificication = classificication;
    }

    public int getPcs() {
        return pcs;
    }

    public void setPcs(int pcs) {
        this.pcs = pcs;
    }

    public byte getWeight() {
        return weight;
    }

    public void setWeight(byte weight) {
        this.weight = weight;
    }

    public boolean isIsStackable() {
        return isStackable;
    }

    public void setIsStackable(boolean isStackable) {
        this.isStackable = isStackable;
    }

    public boolean isIsHazmat() {
        return isHazmat;
    }

    public void setIsHazmat(boolean isHazmat) {
        this.isHazmat = isHazmat;
    }

//    private List<Quote> quotes; // i don't think this belongs here but the generated image is named quotes this is figure labeled quotes; the carriers compete and you will find a list of quotes by different carriers to ship item from origin to destination
//    public Item() {
//    }
//
//    public Item(Long itemId) {
//        this.itemId = itemId;
//    }
//
//    public Item(String itemName) {
//        this.itemName = itemName;
//    }
//
//    public String getItemName() {
//        return itemName;
//    }
//
//    public void setItemName(String itemName) {
//        this.itemName = itemName;
//    }
//
//    @Temporal(javax.persistence.TemporalType.DATE)
//    public Date getQuoteDate() {
//        return quoteDate;
//    }
//
//    public void setQuoteDate(Date quoteDate) {
//        this.quoteDate = quoteDate;
//    }
//
//    @Id
//    @GeneratedValue
//    @Column(name = "ITEM_ID")
//    public Long getItemId() {
//        return itemId;
//    }
//
//    public void setItemId(Long itemId) {
//        this.itemId = itemId;
//    }
//
//    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
//    public List<Quote> getQuotes() {
//        return quotes;
//    }
//
//    public void setQuotes(List<Quote> quotes) {
//        this.quotes = quotes;
//    }
//
//    public Quote addBid(Quote quote) {
//        getQuotes().add(quote);
//        return quote;
//    }
//
//    public Quote removeQuote(Quote quotes) {
//        getQuotes().remove(quotes);
//        return quotes;
//    }
}
