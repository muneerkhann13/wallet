package com.ziina.wallet.deposit.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DepositResponse  {

    private String status;
    private String responseCode;
    private BigDecimal updatedBalance;
}
