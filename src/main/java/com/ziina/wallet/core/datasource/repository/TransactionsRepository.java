package com.ziina.wallet.core.datasource.repository;

import com.ziina.wallet.core.datasource.model.Transactions;
import org.springframework.data.repository.CrudRepository;

public interface TransactionsRepository extends CrudRepository<Transactions,Long> {
}
