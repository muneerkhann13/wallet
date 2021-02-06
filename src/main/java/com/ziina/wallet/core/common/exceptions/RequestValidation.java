package com.ziina.wallet.core.common.exceptions;

public class RequestValidation extends ValidationException {

    public RequestValidation(String respCode) {
        super(respCode);
    }
}
