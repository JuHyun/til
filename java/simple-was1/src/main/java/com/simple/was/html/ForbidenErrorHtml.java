package com.simple.was.html;

public class ForbidenErrorHtml implements ErrorHtml {
    @Override
    public String load() {
        String body = new StringBuilder("<HTML>\r\n")
                .append("<HEAD><TITLE>Forbidden</TITLE>\r\n").append("</HEAD>\r\n")
                .append("<BODY>")
                .append("<H1>HTTP Error 403: Forbidden Error</H1>\r\n")
                .append("</BODY></HTML>\r\n")
                .toString();

        return body;
    }
}
