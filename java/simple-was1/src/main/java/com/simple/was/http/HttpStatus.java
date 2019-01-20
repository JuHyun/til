package com.simple.was.http;

public enum HttpStatus {

    OK(200), NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500), FORBIDDEN(403),
    NOT_IMPLEMENTED(501);

    private final int statusCode;

    HttpStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
