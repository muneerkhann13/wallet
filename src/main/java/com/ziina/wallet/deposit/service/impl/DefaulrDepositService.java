package com.ziina.wallet.deposit.service.impl;

import com.ziina.wallet.deposit.dto.DepositRequest;
import com.ziina.wallet.deposit.dto.DepositResponse;
import com.ziina.wallet.deposit.service.DepositService;

public class DefaulrDepositService implements DepositService {


    @Override
    public DepositResponse deposit(DepositRequest request) {
        // initiate transaction
        // funding --> fail /pending
        // debit
        // credit
        // success
        return null;
    }
}
