package com.ziina.wallet.core.datasource.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "transactions")
public class Transactions {

    @Id
    private @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private BigDecimal amount;
    private @Column(name = "closing_balance") BigDecimal closingBalance;
    private  @Column(name = "account_number") String accountNumber;
    private @Column(name = "transaction_type") String transactionType;
    private @Column(name = "transaction_remark") String remark;
    private @Column(name = "created_on", nullable = false) Timestamp createdOn;
    private @Column(name = "updated_on", nullable = false) Date updatedOn;

}