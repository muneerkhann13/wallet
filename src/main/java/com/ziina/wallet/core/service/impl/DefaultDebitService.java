package com.ziina.wallet.core.service.impl;

import com.ziina.wallet.core.common.enums.TransactionStatus;
import com.ziina.wallet.core.common.enums.TransactionType;
import com.ziina.wallet.core.common.exceptions.RequestValidation;
import com.ziina.wallet.core.common.exceptions.ValidationException;
import com.ziina.wallet.core.datasource.dataservice.TransactionDataService;
import com.ziina.wallet.core.datasource.model.BalanceTracker;
import com.ziina.wallet.core.datasource.model.Transactions;
import com.ziina.wallet.core.datasource.repository.BalanceTrackerRepository;
import com.ziina.wallet.core.datasource.repository.TransactionsRepository;
import com.ziina.wallet.core.dto.TransactionRequest;
import com.ziina.wallet.core.dto.TransactionResponse;
import com.ziina.wallet.core.service.CoreTransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

import static com.ziina.wallet.core.common.constants.ResponseCodesConstants.*;

@Slf4j
@AllArgsConstructor
@Service
public class DefaultDebitService implements CoreTransactionService {

    private final TransactionDataService transactionDataService;

    @Override
    public void requestValidation(TransactionRequest request) {
        if(request.getAmount().compareTo(BigDecimal.ZERO)<=0){
            throw new RequestValidation(INVALID_DEBIT_AMOUNT);
        }
    }

    @Override
    public Transactions performTransaction(TransactionRequest request) {
        return transactionDataService.debit(request);
    }
}
