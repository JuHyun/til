package com.simple.was.requesthandler;


import com.simple.was.httpRequest.BasicHttpRequest;
import com.simple.was.httpRequest.BasicHttpResponse;

public interface BasicHandler {

    void service(BasicHttpRequest req, BasicHttpResponse response);
}
