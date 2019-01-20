package com.simple.was.html;

public class NotImplementedErrorHtml implements ErrorHtml {

    @Override
    public String load() {
        String body = new StringBuilder("<HTML>\r\n").append("<HEAD><TITLE>Not Implemented</TITLE>\r\n").append("</HEAD>\r\n")
                .append("<BODY>")
                .append("<H1>HTTP Error 501: Not Implemented</H1>\r\n")
                .append("</BODY></HTML>\r\n").toString();

        return body;
    }
}
