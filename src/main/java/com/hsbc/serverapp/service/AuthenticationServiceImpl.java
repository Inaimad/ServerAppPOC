package com.hsbc.serverapp.service;

import com.hsbc.serverapp.domain.User;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    /**
     * Stubbed out authentication just for POC purpose
     * @param user User
     * @return boolean
     */
    @Override
    public boolean authenticateUser(User user) {
        return user.getId().equalsIgnoreCase("admin") || user.getPassword().equalsIgnoreCase("admin");
    }
}
