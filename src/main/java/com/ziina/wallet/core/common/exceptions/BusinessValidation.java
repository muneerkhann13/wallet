package com.ziina.wallet.core.common.exceptions;

public class BusinessValidation extends ValidationException {
    public BusinessValidation(String respCode) {
        super(respCode);
    }
}
