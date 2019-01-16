package com.simple.was.requesthandler;


import com.simple.was.httpRequest.SimpleHttpRequest;
import com.simple.was.httpRequest.SimpleHttpResponse;

public interface SimpleHandler {

    void service(SimpleHttpRequest req, SimpleHttpResponse response);
}
