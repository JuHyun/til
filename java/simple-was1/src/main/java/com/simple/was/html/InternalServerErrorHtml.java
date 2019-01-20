package com.simple.was.html;

public class InternalServerErrorHtml implements ErrorHtml {
    @Override
    public String load() {
        String body =
                new StringBuilder("<HTML>\r\n").append("<HEAD><TITLE>Internal Server Error" +
                        "</TITLE>\r\n").append("</HEAD>\r\n")
                .append("<BODY>")
                .append("<H1>HTTP Error 500: Internal Server Error</H1>\r\n")
                .append("</BODY></HTML>\r\n").toString();

        return body;
    }
}
