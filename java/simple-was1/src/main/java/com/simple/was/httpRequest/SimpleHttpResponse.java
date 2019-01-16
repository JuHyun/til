package com.simple.was.httpRequest;

import java.io.IOException;

public interface SimpleHttpResponse {

    void writeBody(String body) throws IOException;

    void writeBody(byte[] body) throws IOException;

    void sendHeader(String httpCode, String contentType, int length) throws IOException;
}
