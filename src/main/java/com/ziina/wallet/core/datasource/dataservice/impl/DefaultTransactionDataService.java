package com.ziina.wallet.core.datasource.dataservice.impl;

import com.ziina.wallet.core.common.enums.TransactionType;
import com.ziina.wallet.core.common.exceptions.BusinessValidation;
import com.ziina.wallet.core.common.exceptions.ValidationException;
import com.ziina.wallet.core.datasource.dataservice.TransactionDataService;
import com.ziina.wallet.core.datasource.mapper.TransactionMapper;
import com.ziina.wallet.core.datasource.model.BalanceTracker;
import com.ziina.wallet.core.datasource.model.Transactions;
import com.ziina.wallet.core.datasource.repository.BalanceTrackerRepository;
import com.ziina.wallet.core.datasource.repository.TransactionsRepository;
import com.ziina.wallet.core.dto.TransactionRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

import static com.ziina.wallet.core.common.constants.ResponseCodesConstants.ACCOUNT_DOES_NOT_EXIST;
import static com.ziina.wallet.core.common.constants.ResponseCodesConstants.INSUFFICIENT_FUNDS;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultTransactionDataService implements TransactionDataService {

    private final BalanceTrackerRepository balanceTrackerRepository;
    private final TransactionsRepository transactionsRepository;

    @Override
    public Optional<BalanceTracker> fetchBalanceTracker(String accountNumber) {
        return balanceTrackerRepository.findByAccountNumber(accountNumber);
    }

    @Override
    @Transactional
    public Transactions debit( TransactionRequest request) {
        BalanceTracker balanceTracker = balanceTrackerRepository.findByAccountNumber(request.getAccountNumber()).orElseThrow(() -> {
            return new BusinessValidation(ACCOUNT_DOES_NOT_EXIST);
        });

        if(balanceTracker.getAmount().compareTo(request.getAmount())==-1){
            throw new BusinessValidation(INSUFFICIENT_FUNDS);
        }
        balanceTracker.setAmount(balanceTracker.getAmount().subtract(request.getAmount()));
        balanceTracker = balanceTrackerRepository.save(balanceTracker);

        Transactions transaction =  TransactionMapper.convert(request,TransactionType.DEBIT);
        transaction.setClosingBalance(balanceTracker.getAmount());
        return transactionsRepository.save(transaction);
    }

    @Override
    @Transactional
    public Transactions credit(TransactionRequest request) {

        BalanceTracker balanceTracker = balanceTrackerRepository.findByAccountNumber(request.getAccountNumber()).orElseThrow(() -> {
            return new BusinessValidation(ACCOUNT_DOES_NOT_EXIST);
        });

        balanceTracker.setAmount(balanceTracker.getAmount().add(request.getAmount()));
        balanceTrackerRepository.save(balanceTracker);

        Transactions transaction =  TransactionMapper.convert(request,TransactionType.CREDIT);
        transaction.setClosingBalance(balanceTracker.getAmount());
        return transactionsRepository.save(transaction);
    }

}
