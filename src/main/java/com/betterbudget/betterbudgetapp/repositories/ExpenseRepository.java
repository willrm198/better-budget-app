package com.betterbudget.betterbudgetapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betterbudget.betterbudgetapp.models.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

	List<Expense> findByBudgetId(int id);

}
