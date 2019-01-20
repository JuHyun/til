package com.simple.was.httpRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Date;

public class SimpleHttpResponse implements BasicHttpResponse {

    private Writer out;
    private String contentType;
    private OutputStream outputStream;

    public SimpleHttpResponse(Writer out, OutputStream outputStream) {
        this.out = out;
        this.outputStream = outputStream;
    }

    @Override
    public void writeBody(String body) throws IOException {
        out.write(body);
        out.flush();
    }

    @Override
    public void writeBody(byte[] body) throws IOException {
        outputStream.write(body);
        outputStream.flush();
    }

    @Override
    public void sendHeader(String httpCode, String contentType, int length) throws IOException {
        out.write(httpCode + "\r\n");
        Date now = new Date();
        out.write("Date: " + now + "\r\n");
        out.write("Server: JHTTP 2.0\r\n");
        out.write("Content-length: " + length + "\r\n");
        out.write("Content-type: " + contentType + "\r\n\r\n");
        out.flush();
    }
}
