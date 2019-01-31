package com.simple.was.httpRequest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HttpRequestProcessorTest {

    @Test
    public void host() {
        HttpRequestProcessor httpRequestProcessor = new HttpRequestProcessor();
        assertEquals("a.com", httpRequestProcessor.host("a.com:8000"));
        assertEquals("a.com.en", httpRequestProcessor.host("a.com.en:8000"));
        assertEquals("a.b.com.en", httpRequestProcessor.host("a.b.com.en:8000"));
        assertEquals("a.b.com.en", httpRequestProcessor.host("a.b.com.en?name=Amy"));
        assertEquals("123-a.com", httpRequestProcessor.host("123-a.com/users/1234"));
    }
}
