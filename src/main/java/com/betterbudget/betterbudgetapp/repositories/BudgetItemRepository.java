package com.betterbudget.betterbudgetapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betterbudget.betterbudgetapp.models.BudgetItem;

public interface BudgetItemRepository extends JpaRepository<BudgetItem, Integer> {

	List<BudgetItem> findByBudgetId(int id);

}
