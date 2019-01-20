package com.simple.servlet;

import com.simple.was.httpRequest.BasicHttpRequest;
import com.simple.was.httpRequest.BasicHttpResponse;
import com.simple.was.requesthandler.BasicHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class SimpleServlet implements BasicHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(Hello.class);

    public void service(BasicHttpRequest basicHttpRequest, BasicHttpResponse basicHttpResponse) {
        LOGGER.info("SimpleServlet start!!");

        try {
            LocalDateTime now = LocalDateTime.now();
            String body =
                    new StringBuilder("<HTML>\r\n")
                            .append("<HEAD><TITLE>Hello Servlet</TITLE>\r\n").append("</HEAD>\r\n")
                            .append("<BODY>")
                            .append("<H1>Now, ").append(now).append("</H1>\r\n")
                            .append("</BODY></HTML>\r\n").toString();
            if (basicHttpRequest.getVersion().startsWith("HTTP/")) { // send a MIME header
                basicHttpResponse.sendHeader("HTTP/1.0 200 OK", "text/html; charset=utf-8", body.length());
            }
            basicHttpResponse.writeBody(body);

            LOGGER.debug("SimpleServlet body : " + body);

        } catch (Exception e) {
            LOGGER.error("SimpleServlet Error", e);
        }
    }
}
