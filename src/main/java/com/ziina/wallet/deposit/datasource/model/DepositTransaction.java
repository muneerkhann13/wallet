package com.ziina.wallet.deposit.datasource.model;

import com.ziina.wallet.deposit.common.enums.DepositStates;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class DepositTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private  Long id;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING) private DepositStates state;
    private @Column(name = "account_number") String accountNumber;
    private @Column(name = "created_on", nullable = false) Timestamp createdOn;
    private @Column(name = "updated_on", nullable = false) Date updatedOn;

}
