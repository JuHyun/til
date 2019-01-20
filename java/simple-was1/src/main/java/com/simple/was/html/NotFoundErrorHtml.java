package com.simple.was.html;

public class NotFoundErrorHtml implements ErrorHtml {

    @Override
    public String load() {
        String body = new StringBuilder("<HTML>\r\n")
                .append("<HEAD><TITLE>File Not Found</TITLE>\r\n")
                .append("</HEAD>\r\n")
                .append("<BODY>")
                .append("<H1>HTTP Error 404: File Not Found</H1>\r\n")
                .append("</BODY></HTML>\r\n")
                .toString();
        return body;
    }
}
