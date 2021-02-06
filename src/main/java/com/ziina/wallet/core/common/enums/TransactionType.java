package com.ziina.wallet.core.common.enums;

import java.util.Optional;

public enum TransactionType {
    DEBIT,CREDIT;

    public static Optional<TransactionType> fromValue(String value){
        try {
            return Optional.ofNullable(TransactionType.valueOf(value));
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
