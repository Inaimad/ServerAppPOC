package com.hsbc.serverapp.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * A User domain object. Used for authentication and maybe other purpose in the future?
 */
@Getter @Setter
public class User {
    private String id;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
