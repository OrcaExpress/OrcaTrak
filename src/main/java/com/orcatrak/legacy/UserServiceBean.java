package com.orcatrak.legacy;

import com.orcatrak.persistence.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Manages users
 * Since we are running in the same container, this interface isn't necessary for
 * EJB 3.1 unless we wanted to "hide" public methods.
 */
@Stateless
public class UserServiceBean implements UserService {

    /**
     * Persistence Context
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Retrieves a user from the database
     * @param userId - user id
     * @return User
     */
    @Override
    public User getUser(long userId) {
        return entityManager.find(User.class,userId);
    }

    /**
     * Persists a user to the database
     * @param user - user
     */
    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }
}
