package com.simple.was.httpRequest;

import java.util.HashMap;
import java.util.Map;

public class SimpleHttpRequest implements BasicHttpRequest {

    private String method;
    private String requestUrl;
    private String requestFile;
    private String version;
    private Map<String, Object> params;

    public SimpleHttpRequest(String method, String requestUrl, String version, Map<String, Object> params) {
        this.method = method;
        this.requestUrl = requestUrl;
        this.version = version;
        this.params = params;
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
    public Map<String, Object> getParams() {
        return params;
    }

    public void setRequestFile(String requestFile) {
        this.requestFile = requestFile;
    }
}
