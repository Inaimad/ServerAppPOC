package com.hsbc.serverapp.service;

import com.hsbc.serverapp.domain.User;

/**
 * A service to provide user authentication on various app levels
 */
public interface AuthenticationService {
    boolean authenticateUser(User user);
}
