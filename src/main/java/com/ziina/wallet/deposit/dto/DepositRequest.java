package com.ziina.wallet.deposit.dto;

import java.math.BigDecimal;

public class DepositRequest {

    private BigDecimal amount;
    private String fundingSource;
    private String userId;
}
