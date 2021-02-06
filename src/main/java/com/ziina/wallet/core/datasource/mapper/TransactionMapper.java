package com.ziina.wallet.core.datasource.mapper;

import com.ziina.wallet.core.common.enums.TransactionType;
import com.ziina.wallet.core.datasource.model.Transactions;
import com.ziina.wallet.core.dto.TransactionRequest;

public class TransactionMapper {

    public static Transactions convert(TransactionRequest request,TransactionType type){
        Transactions transaction = new Transactions();
        transaction.setTransactionType(type.name());
        transaction.setRemark(request.getRemark());
        transaction.setAmount(request.getAmount());
        transaction.setAccountNumber(request.getAccountNumber());
        return transaction;
    }
}
