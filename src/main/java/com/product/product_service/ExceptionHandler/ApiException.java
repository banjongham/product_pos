package com.product.product_service.ExceptionHandler;

import com.product.product_service.Model.ErrorCodes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ApiException extends StatusCodeException {

    public ApiException(ErrorCodes code) {
        super(code.name(), code.getMessage());
    }

    public ApiException(ErrorCodes code, String moreDesc) {
        super(code.name(), code.getMessage() + " -> " + moreDesc);
    }

    public ApiException(ErrorCodes code, String value, String suffix) {
        super(code.name(), code.getMessage() +  value + suffix);
    }
}
