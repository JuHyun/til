package com.simple.was.html;

import com.simple.was.http.HttpStatus;

public class HtmlDrawFactory {

    public static ErrorHtml createHtml(int statusCode) {
        if (HttpStatus.NOT_FOUND.getStatusCode() == statusCode) {
            return new NotFoundErrorHtml();
        } else if (HttpStatus.FORBIDDEN.getStatusCode() == statusCode) {
            return new ForbidenErrorHtml();
        } else if (HttpStatus.NOT_IMPLEMENTED.getStatusCode() == statusCode) {
            return new NotImplementedErrorHtml();
        }

        return new InternalServerErrorHtml();
    }
}
