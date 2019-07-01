package com.hsbc.serverapp.service;

import com.hsbc.serverapp.domain.Server;
import com.hsbc.serverapp.enums.OsType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServerServiceImpl implements ServerService {

    private static final Logger logger = LoggerFactory.getLogger(ServerServiceImpl.class);

    /**
     * Just a stubbed list to have any server data readily available. I would assume that
     * a real server list will get retrieved by a GET method from the server. Another service might
     * be required to develop
     */
    private final List<Server> serverList;

    public ServerServiceImpl() {
        serverList = fetchServerList();
    }

    @Override
    public List<Server> getAllServers() {
        return serverList;
    }

    @Override
    public void changeServerStatus(Server server) {
        logger.info("Changing status of server: {}", server.getServerName());
        server.setActive(!server.isActive());
        logger.info("Server active status is now: {}", server.isActive());
    }

    @Override
    public List<Server> filterServersByOsType(OsType osType) {
        return serverList.stream()
                .filter(server -> osType.equals(server.getOsType()))
                .collect(Collectors.toList());
    }

    /**
     * Prepare stubbed data, easy to delete/replace.
     */
    private List<Server> fetchServerList() {
        List<Server> serverList = new ArrayList<>();
        serverList.add(new Server("SRV1LINUX", true, OsType.RHEL));
        serverList.add(new Server("SRV2LINUX", true, OsType.RHEL));
        serverList.add(new Server("SRV3LINUX", false, OsType.RHEL));
        serverList.add(new Server("SRV1SLES", true, OsType.SLES));
        serverList.add(new Server("SRV1WIN", true, OsType.WindowsServer));
        serverList.add(new Server("SRV2WIN", true, OsType.WindowsServer));
        serverList.add(new Server("SRV3WIN", false, OsType.WindowsServer));
        serverList.add(new Server("SRV4WIN", false, OsType.WindowsServer));
        return serverList;
    }
}
