package com.betterbudget.betterbudgetapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betterbudget.betterbudgetapp.models.Budget;

public interface BudgetRepository extends JpaRepository<Budget, Integer> {

	List<Budget> findByBudgetType(String type);

}
