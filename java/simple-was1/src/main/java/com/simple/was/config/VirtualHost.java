package com.simple.was.config;

import java.util.Objects;

public class VirtualHost {

    private String serverName;

    private String documentRoot;

    public static VirtualHost create(String serverName, String documentRoot) {
        VirtualHost virtualHost = new VirtualHost();
        virtualHost.setServerName(serverName);
        virtualHost.setDocumentRoot(documentRoot);

        return virtualHost;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getDocumentRoot() {
        return documentRoot;
    }

    public void setDocumentRoot(String documentRoot) {
        this.documentRoot = documentRoot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VirtualHost)) return false;
        VirtualHost that = (VirtualHost) o;
        return serverName.equals(that.serverName) &&
                documentRoot.equals(that.documentRoot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serverName, documentRoot);
    }
}
