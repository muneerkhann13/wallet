package com.ziina.wallet.core.service;

import com.ziina.wallet.core.common.enums.TransactionStatus;
import com.ziina.wallet.core.common.exceptions.BusinessValidation;
import com.ziina.wallet.core.common.exceptions.ValidationException;
import com.ziina.wallet.core.datasource.model.BalanceTracker;
import com.ziina.wallet.core.datasource.model.Transactions;
import com.ziina.wallet.core.dto.TransactionRequest;
import com.ziina.wallet.core.dto.TransactionResponse;

import static com.ziina.wallet.core.common.constants.ResponseCodesConstants.SUCCESS;

public  interface CoreTransactionService<T extends TransactionRequest,R extends TransactionResponse>{

     default R transaction(T request){
          try {
               requestValidation(request);
               Transactions transactions = performTransaction(request);
               return response(transactions);
          }catch (BusinessValidation e){
               return response(e.getRespCode());
          }
     }

     void requestValidation(T request);

     Transactions performTransaction(T request);

     default R response(Transactions transactions){
          TransactionResponse transactionResponse = new TransactionResponse();
          transactionResponse.setStatus(TransactionStatus.SUCCESS);
          transactionResponse.setResponseCode(SUCCESS);
          transactionResponse.setTransactionId(transactions.getId());
          transactionResponse.setUpdatedBalance(transactions.getClosingBalance());
          return (R) transactionResponse;
     }


     default R response(String responseCode){
          TransactionResponse transactionResponse = new TransactionResponse();
          transactionResponse.setStatus(TransactionStatus.FAILURE);
          transactionResponse.setResponseCode(responseCode);
          return (R) transactionResponse;
     }

}