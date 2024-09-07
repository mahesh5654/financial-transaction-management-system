package com.mybank.demo.repository;

import com.mybank.demo.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Find transactions by sender account or receiver account
    List<Transaction> findBySenderAccountIdOrReceiverAccountId(String senderAccountId, String receiverAccountId);

    // Find transactions by status
    List<Transaction> findByStatus(String status);

}