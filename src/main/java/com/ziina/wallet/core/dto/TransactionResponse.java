package com.ziina.wallet.core.dto;

import com.ziina.wallet.core.common.enums.TransactionStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionResponse {

    private BigDecimal updatedBalance;
    private TransactionStatus status;
    private Long transactionId;
    private String responseCode;

}
