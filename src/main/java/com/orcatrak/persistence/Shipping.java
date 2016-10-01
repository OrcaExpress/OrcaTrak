package com.orcatrak.persistence;

import java.io.Serializable;

/**
 * Shipping information
 */
public class Shipping implements Serializable {

    /**
     * Shipping cost
     */
    protected double cost;

    /**
     * Cost of the shipping
     *
     * @param cost - cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Returns the cost of the shipping
     *
     * @return shipping cost
     */
    public double getCost() {
        return cost;
    }

}
