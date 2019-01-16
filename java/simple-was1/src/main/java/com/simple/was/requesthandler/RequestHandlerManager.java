package com.simple.was.requesthandler;

import java.util.HashMap;
import java.util.Map;

public class RequestHandlerManager {

    private Map<String, SimpleHandler> servletMap = new HashMap<String, SimpleHandler>();

    public Map<String, SimpleHandler> getServletMap() {
        return servletMap;
    }

    public void putServlet(SimpleHandler handler) {
        if(handler == null) {
            throw new RuntimeException("can`t input null handler!");
        }
        servletMap.put(handler.getClass().getSimpleName(), handler);
    }
}
