package incomplete;

import com.orcatrak.persistence.Customer;
import java.io.Serializable;

/**
 *
 * @author java ee
 */

public class Order implements Serializable {
    private Customer customer;
    private Item item;
    private ShippingCost shippingCost;
    private Billing billing;
//    private OrderStatus orderStatus;

    
}
