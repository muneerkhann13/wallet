package com.ziina.wallet.core.datasource.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "balance_tracker")
public class BalanceTracker {

    @Id private  @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private BigDecimal amount;
    private String currency;
    private @Column(name = "account_number") String accountNumber;
    private @Column(name = "created_on", nullable = false) Timestamp createdOn;
    private @Column(name = "updated_on", nullable = false) Date updatedOn;
}