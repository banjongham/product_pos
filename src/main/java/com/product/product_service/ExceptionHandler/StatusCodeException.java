package com.product.product_service.ExceptionHandler;

public abstract class StatusCodeException extends RuntimeException {

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public StatusCodeException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

}
