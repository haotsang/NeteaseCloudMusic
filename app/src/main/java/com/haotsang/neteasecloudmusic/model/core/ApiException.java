package com.haotsang.neteasecloudmusic.model.core;

public class ApiException extends RuntimeException {

    private final int statusCode;
    private final String errorMessage;

    public ApiException(int statusCode, String errorMessage) {
        super("HTTP Status Code: " + statusCode + ", Error Message: " + errorMessage);
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}