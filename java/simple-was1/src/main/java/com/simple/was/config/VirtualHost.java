package com.simple.was.config;

import java.util.Objects;

public class VirtualHost {

    private String serverName;

    private String documentRoot;

    private String forbidden;

    private String notFound;

    private String internalServerError;

    public static VirtualHost create(String serverName, String documentRoot, String forbidden, String notFound, String internalServerError) {
        VirtualHost virtualHost = new VirtualHost();
        virtualHost.setServerName(serverName);
        virtualHost.setDocumentRoot(documentRoot);
        virtualHost.setForbidden(forbidden);
        virtualHost.setNotFound(notFound);
        virtualHost.setInternalServerError(internalServerError);

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

    public String getForbidden() {
        return forbidden;
    }

    public void setForbidden(String forbidden) {
        this.forbidden = forbidden;
    }

    public String getNotFound() {
        return notFound;
    }

    public void setNotFound(String notFound) {
        this.notFound = notFound;
    }

    public String getInternalServerError() {
        return internalServerError;
    }

    public void setInternalServerError(String internalServerError) {
        this.internalServerError = internalServerError;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VirtualHost)) return false;
        VirtualHost that = (VirtualHost) o;
        return serverName.equals(that.serverName) &&
                documentRoot.equals(that.documentRoot) &&
                Objects.equals(forbidden, that.forbidden) &&
                Objects.equals(notFound, that.notFound) &&
                Objects.equals(internalServerError, that.internalServerError);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serverName, documentRoot, forbidden, notFound, internalServerError);
    }

    @Override
    public String toString() {
        return "VirtualHost{" +
                "serverName='" + serverName + '\'' +
                ", documentRoot='" + documentRoot + '\'' +
                ", forbidden='" + forbidden + '\'' +
                ", notFound='" + notFound + '\'' +
                ", internalServerError='" + internalServerError + '\'' +
                '}';
    }
}
