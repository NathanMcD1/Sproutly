package Sproutly.Controllers;

import Sproutly.Models.Account;

/**
 * Interface for controllers that need access to the current user account.
 * Enables shared Account injection across scenes.
 */

public interface UserAware {
    void setUser(Account user);
}
