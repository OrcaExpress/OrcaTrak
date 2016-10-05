/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orcatrak.persistence;

import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * get quote; the quote is initiated by a stateless bean; no need to persist
 * this bean into an entity; it is discarded from memory once session is closed
 * unless user clicks the order button, at which point a bill of lading (bol)
 * number or internal tracking number is created; in the future the application
 * might be further developed to persist quotes.
 */
@Named
@RequestScoped
//@Entity
//@Table(name="QUOTES")
public class Quote {

    //ORIGIN   
    private String originShipmentZip;   //#{quote.originShipmentZip}
    private Zone pickupZone;//#{quote.zoning} is it a business zone or residence zone big trugs are not allowed into residentials.  items or commodity must be placed on smaller trucks 
    private Date pickupDate;
    private Accessories pickupRequirements;

    //DESTINATION
    private String destinationShipmentZip;
    private Zone deliveryZone;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date deliveryDate;

    private Accessories deliveryRequirements;

    //ITEM SHIPMENT
    /**
     * client can add more items to include in quote; the way this works is; 1 
     * pallet is 44 inches x 48 inches (12 inches is 1 m) an item sits on a
     * pallet the weight is taken into consideration and a price quote is given;
     * i have to get discount levels from shippers to finish the pricing
     * i made this a list because 1 quote can have more than 1 palletized item;
     * more items means price to ship goes up.  presentation layers shows you can add 
     * more items 
     */
    private List<Item> itemList;  

//    private Long bol;
    private Double quotePrice;

    /**
     * i have user and client; maybe i need one but not 2 .. reason i have 2 is
     * a client is a customer but not neccessarily uses our system; maybe he
     * owes money so we block him so hes just a client but can not use it you
     * tell me ??  i have a feeling the User field and/or client fields don't belong in this bean
     * but this quote definitely belongs to a certain user so maybe it should stay 
     * 
     *
     */
    private User user;
    private Client client;

    public Quote() {
    }

    public Quote(String originShipmentZip, Zone pickupZone, Date pickupDate, Accessories pickupRequirements, String destinationShipmentZip, Zone deliveryZone, Date deliveryDate, Accessories deliveryRequirements, List<Item> itemList) {
        this.originShipmentZip = originShipmentZip;
        this.pickupZone = pickupZone;
        this.pickupDate = pickupDate;
        this.pickupRequirements = pickupRequirements;
        this.destinationShipmentZip = destinationShipmentZip;
        this.deliveryZone = deliveryZone;
        this.deliveryDate = deliveryDate;
        this.deliveryRequirements = deliveryRequirements;
        this.itemList = itemList;
    }

    public String getOriginShipmentZip() {
        return originShipmentZip;
    }

    public void setOriginShipmentZip(String originShipmentZip) {
        this.originShipmentZip = originShipmentZip;
    }

    public Zone getPickupZone() {
        return pickupZone;
    }

    public void setPickupZone(Zone pickupZone) {
        this.pickupZone = pickupZone;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Accessories getPickupRequirements() {
        return pickupRequirements;
    }

    public void setPickupRequirements(Accessories pickupRequirements) {
        this.pickupRequirements = pickupRequirements;
    }

    public String getDestinationShipmentZip() {
        return destinationShipmentZip;
    }

    public void setDestinationShipmentZip(String destinationShipmentZip) {
        this.destinationShipmentZip = destinationShipmentZip;
    }

    public Zone getDeliveryZone() {
        return deliveryZone;
    }

    public void setDeliveryZone(Zone deliveryZone) {
        this.deliveryZone = deliveryZone;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Accessories getDeliveryRequirements() {
        return deliveryRequirements;
    }

    public void setDeliveryRequirements(Accessories deliveryRequirements) {
        this.deliveryRequirements = deliveryRequirements;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
