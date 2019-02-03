package com.simple.servlet;


import com.simple.was.httpRequest.BasicHttpRequest;
import com.simple.was.httpRequest.BasicHttpResponse;
import com.simple.was.requesthandler.BasicHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hello implements BasicHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(Hello.class);

    public void service(BasicHttpRequest basicHttpRequest, BasicHttpResponse basicHttpResponse) {
        LOGGER.info("Hello start!!");

        try {
            String name = String.valueOf(basicHttpRequest.getParams().get("name"));
            String body =
                    new StringBuilder("<HTML>\r\n")
                            .append("<HEAD><TITLE>Hello Servlet</TITLE>\r\n").append("</HEAD>\r\n")
                            .append("<BODY>")
                            .append("<H1>Hello, " + name + "</H1>\n")
                            .append("</BODY></HTML>\r\n").toString();
            if (basicHttpRequest.getVersion().startsWith("HTTP/")) { // send a MIME header
                basicHttpResponse.sendHeader("HTTP/1.0 200 OK", "text/html; charset=utf-8", body.length());
            }
            basicHttpResponse.writeBody(body);

            LOGGER.debug("Hello body : " + body);

        } catch (Exception e) {
            LOGGER.error("Hello Error", e);
        }
    }
}
