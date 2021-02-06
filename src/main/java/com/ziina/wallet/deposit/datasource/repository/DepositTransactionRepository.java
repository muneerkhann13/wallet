package com.ziina.wallet.deposit.datasource.repository;

import com.ziina.wallet.deposit.datasource.model.DepositTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositTransactionRepository extends JpaRepository<DepositTransaction,Long> {
}
