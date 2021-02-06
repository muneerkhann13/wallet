package com.ziina.wallet.core.datasource.repository;

import com.ziina.wallet.core.datasource.model.BalanceTracker;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface BalanceTrackerRepository extends CrudRepository<BalanceTracker,Long> {

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    @Query("SELECT c FROM BalanceTracker c WHERE c.accountNumber = ?1")
    Optional<BalanceTracker> findByAccountNumber(String accountNumber);
}
