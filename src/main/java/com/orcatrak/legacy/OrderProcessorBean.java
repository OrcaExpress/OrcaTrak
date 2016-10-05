package com.orcatrak.legacy;

import com.orcatrak.persistence.Billing;
import com.orcatrak.persistence.Item;
import com.orcatrak.persistence.Order;
import com.orcatrak.persistence.OrderStatus;
import com.orcatrak.persistence.Shipping;
import com.orcatrak.persistence.User;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Asynchronous;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * Processes orders.  the OrderProcessor must add an order record.  this database change is performed through the Order entity.
 */
 
@Stateful
public class OrderProcessorBean implements OrderProcessor {

    /**
     * User
     */
    private User user;
    /**
     * Item being bid on
     */
    private Item item;
    /**
     * Shipping information
     */
    private Shipping shipping;
    /**
     * Available shipping choices
     */
    private List<Shipping> shippingChoices = new LinkedList<Shipping>();
    /**
     * Billing information
     */
    private Billing billing;
    /**
     * List of billing choices
     */
    private List<Billing> billingChoices = new LinkedList<Billing>();

    /**
     * Creates a new DefaultOrderProcessor instance.
     */
    public OrderProcessorBean() {
        billingChoices.add(new Billing());
        shippingChoices.add(new Shipping());
    }

    /**
     * Sets the user
     * @param user - user
     */
    @Override
    public void setUser(User user) {
        this.user = user;
        this.shippingChoices = getShippingHistory(user);
        this.billingChoices = getBillingHistory(user);
    }

    /**
     * Sets the item
     * @param item - item
     */
    @Override
    public void setItem(Item item) {
        this.item = item;
        this.shippingChoices = filterShippingChoices(shippingChoices, item);
        this.billingChoices = filterBillingChoices(billingChoices, item);
    }

    /**
     * Returns the shipping options
     * @return shipping options
     */
    @Override
    public List<Shipping> getShippingChoices() {
        return shippingChoices;
    }

    /**
     * Sets the shipping option
     * @param shipping - shipping option
     */
    @Override
    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
        updateShippingHistory(user, shipping);
        shipping.setCost(calculateShippingCost(shipping, item));
    }

    /**
     * Returns the shipping option
     * @return shipping option
     */
    @Override
    public Shipping getShipping() {
        return shipping;
    }

    /**
     * Returns the billing choices
     * @return billing choices
     */
    @Override
    public List<Billing> getBillingChoices() {
        return billingChoices;
    }

    /**
     * Sets the billing information
     * @param billing - billing information
     */
    @Override
    public void setBilling(Billing billing) {
        this.billing = billing;
        updateBillingHistory(user, billing);
    }

    /**
     * Places an order; 
     ***********@Asynchronous annotation, placed on the placeOrder method makes the method asynchronously invokable. This means that the bean will return control back to the client as soon as the innovation happens. The method is then executed as a lightweight background process. This is an important piece of functionality in this case, because the billing process can potentially take a long time. Instead of making the user wait for the billing process to finish, the @Asynchronous annotation means that the user gets an immediate order placement confirmation while the final step of the ordering process can finish in the background. 
     ***********@Remove annotation, placed on the placeOrder method. Although this annotation is optional, it’s critical from a server performance standpoint. The @Remove annotation marks the end of the workflow modeled by a stateful bean. In this case, you’re telling the container that there’s no longer a need to maintain the bean’s session with the client after the placeOrder method is invoked. If you didn’t tell the container what method invocation marked the end of the workflow, the container could wait for a long time until it could safely time out the session. Because stateful beans are guaranteed to be dedicated to a client for the duration of a session, this could mean a lot of orphaned state data consuming precious server resources for long time periods!
     */
    @Asynchronous
    @Remove
    @Override
    public void placeOrder() {
        Order order = new Order();
        order.setUser(user);
        order.setItem(item);
        order.setShipping(shipping);
        order.setBilling(billing);
        try {
            bill(order);
            notifyBillingSuccess(order);
            order.setStatus(OrderStatus.COMPLETE);
        } catch (BillingException be) {
            notifyBillingFailure(be, order);
            order.setStatus(OrderStatus.BILLING_FAILED);
        } finally {
            saveOrder(order);
        }
    }

    /**
     * Returns the shipping history for the user
     * @param user - user
     * @return List of shipments
     */
    @Override
    public List<Shipping> getShippingHistory(User user) {
        List<Shipping> shippingHistory = new LinkedList<Shipping>();
        shippingHistory.add(new Shipping());
        return shippingHistory;
    }

    /**
     * Returns the billing history
     * @param user - user
     * @return user
     */
    @Override
    public List<Billing> getBillingHistory(User user) {
        List<Billing> history = new LinkedList<Billing>();
        history.add(new Billing());
        return history;
    }

    /**
     * Updates the billing history for a user
     * @param user - user
     * @param billing - billing information
     */
    @Override
    public void updateBillingHistory(User user, Billing billing) {
    }

    /**
     * Bills an order
     * @param order - order to be billed
     * @throws BillingException - thrown if the order cannot be billed
     */
    @Override
    public void bill(Order order) throws BillingException {
        throw new BillingException();
    }

    /**
     * Sends out notification of billing success
     * @param order - order
     */
    @Override
    public void notifyBillingSuccess(Order order) {
    }

    /**
     * Saves an order
     * @param order - order to be saved
     */
    @Override
    public void saveOrder(Order order) {
    }

    /**
     * Sends out a notification of billing failure
     * @param be - billing exception that was generated
     * @param order - order on which billing failed
     */
    @Override
    public void notifyBillingFailure(BillingException be, Order order) {
    }

    /**
     * Updates the shipping history
     * @param user - user
     * @param shipping - shipping
     */
    @Override
    public void updateShippingHistory(User user, Shipping shipping) {
    }

    /**
     * Calculates the shipping code
     * @param shipping - shipping
     * @param item - item
     */
    @Override
    public double calculateShippingCost(Shipping shipping, Item item) {
        return 0;
    }

    /**
     * Filters the shipping choices
     * @param shippingChoices - shipping choices
     * @param item - item
     * @return List of shipping choices
     */
    @Override
    public List<Shipping> filterShippingChoices(List<Shipping> shippingChoices, Item item) {
        return shippingChoices;
    }

    /**
     * Filters the billing choices
     * @param billingChoices - billing choices
     * @param item - item
     * @return List of billings
     */
    @Override
    public List<Billing> filterBillingChoices(List<Billing> billingChoices, Item item) {
        return billingChoices;
    }

    /**
     * Returns the user
     * @return user
     */
    @Override
    public User getUser() {
        return user;
    }

    /**
     * Returns the item being processed
     * @return item
     */
    @Override
    public Item getItem() {
        return item;
    }

    /**
     * Sets the shipping choices
     * @param shippingChoices - shipping choices
     */
    @Override
    public void setShippingChoices(List<Shipping> shippingChoices) {
        this.shippingChoices = shippingChoices;
    }

    /**
     * Sets the billing choices
     * @param billingChoices - billing choices
     */
    @Override
    public void setBillingChoices(List<Billing> billingChoices) {
        this.billingChoices = billingChoices;
    }

    /**
     * Returns the selected billing choice
     * @return billing choice
     */
    @Override
    public Billing getBilling() {
        return billing;
    }
}
