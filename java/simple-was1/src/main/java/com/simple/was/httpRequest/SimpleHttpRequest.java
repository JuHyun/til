package com.simple.was.httpRequest;

import java.util.Map;

public interface SimpleHttpRequest {

    String getMethod();

    String getRequestUrl();

    String getRequestFile();

    String getVersion();

    Map<String, String> getParams();
}
