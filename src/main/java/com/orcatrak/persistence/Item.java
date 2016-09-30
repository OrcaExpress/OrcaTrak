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
@Entity
@Table(name = "ITEMS")
public class Item implements Serializable {
    private Long itemId;
    private String itemName;
    private Date quoteDate;
    private List<Quote> quotes;

    public Item() {
    }

    public Item(Long itemId) {
        this.itemId = itemId;
    }

    public Item(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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
    @Column(name = "ITEM_ID")
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public Quote addBid(Quote quote) {
        getQuotes().add(quote);
        return quote;
    }

    public Quote removeQuote(Quote quotes) {
        getQuotes().remove(quotes);
        return quotes;
    }
}
