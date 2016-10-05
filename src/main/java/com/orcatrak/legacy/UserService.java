package com.orcatrak.legacy;

import com.orcatrak.persistence.User;
import javax.ejb.Local;

/**
 * Manages users
 * Since we are running in the same container, this interface isn't necessary for
 * EJB 3.1 unless we wanted to "hide" public methods.
 */
@Local
public interface UserService {

    /**
     * Returns the user
     * @param userId - user
     * @return User
     */
    User getUser(long userId);

    /**
     * Sets the user
     * @param user - user
     */
    void createUser(User user);

}
