package com.ziina.wallet.core.common.exceptions;

import lombok.Data;

@Data
public class ValidationException extends BaseException {

    private String respCode;

    public ValidationException(String respCode) {
        this.respCode = respCode;
    }
}
