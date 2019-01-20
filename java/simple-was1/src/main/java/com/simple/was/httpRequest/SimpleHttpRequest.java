package com.simple.was.httpRequest;

import java.util.Map;

public class SimpleHttpRequest implements BasicHttpRequest {

    private String method;
    private String requestUrl;
    private String requestFile;
    private String version;

    public SimpleHttpRequest(String method, String requestUrl, String version) {
        this.method = method;
        this.requestUrl = requestUrl;
        this.version = version;
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public String getRequestUrl() {
        return requestUrl;
    }

    @Override
    public String getRequestFile() {
        return requestFile;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public Map<String, String> getParams() {
        return null;
    }

    public void setRequestFile(String requestFile) {
        this.requestFile = requestFile;
    }
}
