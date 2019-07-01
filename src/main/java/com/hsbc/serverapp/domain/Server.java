package com.hsbc.serverapp.domain;

import com.hsbc.serverapp.enums.OsType;

/**
 * A Server Domain Object. Lombok seems to behave funky with Thymeleaf so I would suggest
 * staying with regular java getters and setters. Obviously we can add more attributes like IP for example.
 */
public class Server {
    private String serverName;
    private boolean isActive;
    private OsType osType;

    public Server(String serverName, boolean isActive, OsType osType) {
        this.serverName = serverName;
        this.isActive = isActive;
        this.osType = osType;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public OsType getOsType() {
        return osType;
    }

    public void setOsType(OsType osType) {
        this.osType = osType;
    }
}
