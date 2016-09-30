package incomplete;

import com.orcatrak.persistence.Client;
import java.io.Serializable;

/**
 *
 * @author java ee
 */

public class Order implements Serializable {
    private Client customer;
    private Item item;
    private ShippingCost shippingCost;
    private Billing billing;
//    private OrderStatus orderStatus;

    
}
