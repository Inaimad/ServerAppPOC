package com.hsbc.serverapp.service;

import com.hsbc.serverapp.domain.Server;
import com.hsbc.serverapp.enums.OsType;

import java.util.List;

/**
 * A service to interact with available servers
 */
public interface ServerService {

    /**
     * Retrieve all available servers
     * @return List<Server>
     */
    List<Server> getAllServers();

    /**
     * A switch method to change server active status. An active server will be turned off and vice versa.
     * @param server Server
     */
    void changeServerStatus(Server server);

    /**
     * Just a funny method to have any filtering readily available.
     * @param osType OsType
     * @return List<Server>
     */
    List<Server> filterServersByOsType(OsType osType);
}
