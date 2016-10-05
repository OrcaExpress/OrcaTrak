package com.orcatrak.legacy;

import com.orcatrak.persistence.Item;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Item service - retrieves items from the database.
 */
@Stateless
public class ItemServiceBean implements ItemService {

    /**
     * Persistence Context
     */
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Item getItem(long itemId) {
        return entityManager.find(Item.class,itemId);
    }

    /**
     * Creates an item in the database
     * @param item
     */
    @Override
    public void createItem(Item item) {
        entityManager.persist(item);
    }

}
