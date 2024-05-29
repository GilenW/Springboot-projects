package com.example.banking_app.repository;

import com.example.banking_app.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByAccountIdOrderedByTimestampDesc(Long accountId);


}
