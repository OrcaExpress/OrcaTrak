/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incomplete;

import java.io.Serializable;

/**
 *
 * @author java ee
 */
public class ShippingCost implements Serializable {
    
    protected double cost;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
}
