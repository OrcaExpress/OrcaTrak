package com.orcatrak.buslogic;

/**
 * after a quote for a shipping is performed the order is processed once client approves it
 * this stateless bean persists the quote done by the client
 * the QuoteService is a business process that needs to persist data.  here it needs to add a bid record to the database
 */
import com.orcatrak.persistence.Billing;
import com.orcatrak.persistence.Item;
import com.orcatrak.persistence.Order;
import com.orcatrak.persistence.Shipping;
import com.orcatrak.persistence.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface OrderProcessor {

    /**
     ********************************* Sets the user
     *
     * @param user - user
     */
    public void setUser(User user);

    /**
     ******************************** Sets the item
     *
     * @param item - item
     */

    public void setItem(Item item);

    /**
     ************************* Returns the shipping options
     *
     * @return shipping options
     */
    public List<Shipping> getShippingChoices();

    /**
     *************************** Sets the shipping option
     *
     * @param shipping - shipping option
     */
    public void setShipping(Shipping shipping);

    /**
     *********************** Returns the shipping option
     *
     * @return shipping option
     */
    public Shipping getShipping();

    /**
     ********************* Returns the billing choices
     *
     * @return billing choices
     */
    public List<Billing> getBillingChoices();

    /**
     *********************** Sets the billing information
     *
     * @param billing - billing information
     */
    public void setBilling(Billing billing);

    /**
     **************************** Places an order
     */
    public void placeOrder();

    /**
     ****************** Returns the shipping history for the user
     *
     * @param user - user
     * @return List of shipments
     */
    public List<Shipping> getShippingHistory(User user);

    /**
     ************************* Returns the billing history
     *
     * @param user - user
     * @return user
     */
    public List<Billing> getBillingHistory(User user);

    /**
     ****************** Updates the billing history for a user
     *
     * @param user - user
     * @param billing - billing information
     */
    public void updateBillingHistory(User user, Billing billing);

    /**
     ************************** Bills an order
     *
     * @param order - order to be billed
     * @throws BillingException - thrown if the order cannot be billed
     */
    public void bill(Order order) throws BillingException;

    /**
     ********************* Sends out notification of billing success
     *
     * @param order - order
     */
    public void notifyBillingSuccess(Order order);

    /**
     ************************** Saves an order
     *
     * @param order - order to be saved
     */
    public void saveOrder(Order order);

    /**
     ***************** Sends out a notification of billing failure
     *
     * @param be - billing exception that was generated
     * @param order - order on which billing failed
     */
    public void notifyBillingFailure(BillingException be, Order order);

    /**
     *********************** Updates the shipping history
     *
     * @param user - user
     * @param shipping - shipping
     */
    public void updateShippingHistory(User user, Shipping shipping);

    /**
     *********************** Calculates the shipping code
     *
     * @param shipping - shipping
     * @param item - item
     */
    public double calculateShippingCost(Shipping shipping, Item item);

    /**
     ******************** Filters the shipping choices
     *
     * @param shippingChoices - shipping choices
     * @param item - item
     * @return List of shipping choices
     */
    public List<Shipping> filterShippingChoices(List<Shipping> shippingChoices, Item item);

    /**
     **************************  Filters the billing choices
     *
     * @param billingChoices - billing choices
     * @param item - item
     * @return List of billings
     */
    public List<Billing> filterBillingChoices(List<Billing> billingChoices, Item item);

    /**
     **************************  Returns the user
     *
     * @return user
     */
    public User getUser();

    /**
     * ************************* Returns the item being processed
     *
     * @return item
     */
    public Item getItem();

    /**
     **************************  Sets the shipping choices
     *
     * @param shippingChoices - shipping choices
     */
    public void setShippingChoices(List<Shipping> shippingChoices);

    /**
     **************************  Sets the billing choices
     *
     * @param billingChoices - billing choices
     */
    public void setBillingChoices(List<Billing> billingChoices);

    /**
     **************************  Returns the selected billing choice
     *
     * @return billing choice
     */
    public Billing getBilling();
}
