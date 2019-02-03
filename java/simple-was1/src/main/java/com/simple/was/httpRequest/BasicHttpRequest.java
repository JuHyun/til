package com.simple.was.httpRequest;

import java.util.Map;

public interface BasicHttpRequest {

    String getMethod();

    String getRequestUrl();

    String getRequestFile();

    String getVersion();

    Map<String, Object> getParams();
}
