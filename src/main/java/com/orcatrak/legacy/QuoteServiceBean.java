package com.orcatrak.legacy;

import com.orcatrak.persistence.Quote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * this stateless bean persists the quote done by the client
 * the QuoteService is a business process that needs to persist data.  here it needs to add a bid record to the database.  
 * The BidService uses the Bid entity to perform changes to the database.
 * 
 * Stateless session beans are used to model actions or processes that can be done in a single method call, such as placing a shippment quote on a commodity.  The vast majority of your business-tier components are likely to be stateless.  The addQuote bean method is called from the OrcaTrak web tier, when a user decides to place a quote.  The parameter to the method, the Quote object represents the quote to be placed.  The Quote object contains the ***USER*** placing the quote, the ***ITEM*** being quoted on and ***QUOTES*** from the freight companies.  This last piece has yet to be built.
 * 
 */
@Stateless
public class QuoteServiceBean implements QuoteService {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void addQuote(Quote quote) { 
        entityManager.persist(quote);
    }
}
