package com.betterbudget.betterbudgetapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betterbudget.betterbudgetapp.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	List<Transaction> findByBudgetId(int id);

	List<Transaction> findByTransactionType(String type);

}
