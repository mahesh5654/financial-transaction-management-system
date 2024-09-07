package com.mybank.demo.service.impl;

import com.mybank.demo.entity.Transaction;
import com.mybank.demo.repository.TransactionRepository;
import com.mybank.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    // Create a new transaction
    @Override
    public Transaction createTransaction(Transaction transaction) {
        transaction.setStatus("Pending");
        transaction.setTimestamp(java.time.LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    // Retrieve transaction history for an account
    @Override
    public List<Transaction> getTransactionHistory(String accountId) {
        return transactionRepository.findBySenderAccountIdOrReceiverAccountId(accountId, accountId);
    }

    // Retrieve a specific transaction by ID
    @Override
    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    // Update transaction status
    @Override
    public Transaction updateTransactionStatus(Long id, String status) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (transaction.isPresent()) {
            Transaction updatedTransaction = transaction.get();
            updatedTransaction.setStatus(status);
            return transactionRepository.save(updatedTransaction);
        }
        return null;
    }
}
