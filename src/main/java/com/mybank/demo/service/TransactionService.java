package com.mybank.demo.service;

import com.mybank.demo.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    // Create a new transaction
    Transaction createTransaction(Transaction transaction);

    // Retrieve transaction history for an account
    List<Transaction> getTransactionHistory(String accountId);

    // Retrieve a specific transaction by ID
    Optional<Transaction> getTransactionById(Long id);

    // Update transaction status
    Transaction updateTransactionStatus(Long id, String status);
}
