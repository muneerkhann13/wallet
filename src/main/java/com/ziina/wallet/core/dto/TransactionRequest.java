package com.ziina.wallet.core.dto;

import com.ziina.wallet.core.common.enums.TransactionType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionRequest{

    private String accountNumber;
    private BigDecimal amount;
    private String remark;
}
