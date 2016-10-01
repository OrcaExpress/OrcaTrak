package com.orcatrak.buslogic;

import com.orcatrak.persistence.Item;
import javax.ejb.Local;

/**
 * Manages items
 */
@Local
public interface ItemService {

    /**
     * Retrieves an item from the database
     * @param itemId - item id
     * @return Item
     */
    Item getItem(long itemId);

    /**
     * Creates an item in the database
     * @param item - item to be created
     */
    public void createItem(Item item);
}
