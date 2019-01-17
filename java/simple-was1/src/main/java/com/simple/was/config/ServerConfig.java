package com.simple.was.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ServerConfig {

    private int port;

    private List<VirtualHost> virtualHosts = new ArrayList<VirtualHost>();

    public static ServerConfig create(int port, List<VirtualHost> virtualHosts) {
        ServerConfig serverConfig = new ServerConfig();
        serverConfig.port = port;
        serverConfig.virtualHosts = virtualHosts;
        return serverConfig;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public List<VirtualHost> getVirtualHosts() {
        return virtualHosts;
    }

    public void setVirtualHosts(List<VirtualHost> virtualHosts) {
        this.virtualHosts = virtualHosts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServerConfig)) return false;
        ServerConfig that = (ServerConfig) o;
        return port == that.port &&
                Objects.equals(virtualHosts, that.virtualHosts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(port, virtualHosts);
    }
}
