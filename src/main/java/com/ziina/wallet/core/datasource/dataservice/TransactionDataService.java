package com.ziina.wallet.core.datasource.dataservice;

import com.ziina.wallet.core.datasource.model.BalanceTracker;
import com.ziina.wallet.core.datasource.model.Transactions;
import com.ziina.wallet.core.dto.TransactionRequest;

import java.util.Optional;

public interface TransactionDataService<T extends TransactionRequest> {

    Optional<BalanceTracker> fetchBalanceTracker(String accountNumber);

    Transactions debit(T request);

    Transactions credit(T request);
}
