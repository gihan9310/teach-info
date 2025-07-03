package com.gihanz.exceptions;


public enum RESPONSE_CODE {

    OK(200),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    private final int ERROR_CODE;

    private RESPONSE_CODE(int error_code) {
        ERROR_CODE = error_code;
    }

    public int getCode() {
        return ERROR_CODE;
    }

}
