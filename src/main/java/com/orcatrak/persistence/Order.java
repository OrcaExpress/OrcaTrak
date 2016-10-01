package com.orcatrak.persistence;

import java.io.Serializable;

/**
 * Represents an Order
 */
public class Order implements Serializable {

    /**
     * Person that bid
     */
    private User user;

    /**
     * Item on that was bid on
     */
    private Item item;

    /**
     * Shipping address
     */
    private Shipping shipping;

    /**
     * Billing address
     */
    private Billing billing;

    /**
     * Order status
     */
    private OrderStatus orderStatus;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    /**
     * Sets the order status
     *
     * @param orderStatus - order status
     */
    public void setStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Returns the order status
     *
     * @return order status
     */
    public OrderStatus getStatus() {
        return orderStatus;
    }
}
