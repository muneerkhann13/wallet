package com.ziina.wallet.deposit.service;

import com.ziina.wallet.deposit.dto.DepositRequest;
import com.ziina.wallet.deposit.dto.DepositResponse;

public interface DepositService<R extends DepositResponse, T extends  DepositRequest> {

    R deposit(T request);
}
