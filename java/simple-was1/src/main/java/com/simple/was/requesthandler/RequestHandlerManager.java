package com.simple.was.requesthandler;

import java.util.HashMap;
import java.util.Map;

public class RequestHandlerManager {

    private Map<String, BasicHandler> servletMap = new HashMap<String, BasicHandler>();

    public Map<String, BasicHandler> getServletMap() {
        return servletMap;
    }

    public void putServlet(BasicHandler handler) {
        if(handler == null) {
            throw new RuntimeException("can`t input null handler!");
        }
        servletMap.put(handler.getClass().getSimpleName(), handler);
    }
}
