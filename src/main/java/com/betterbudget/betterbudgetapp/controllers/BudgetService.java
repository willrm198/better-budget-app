package com.betterbudget.betterbudgetapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betterbudget.betterbudgetapp.models.budget.Budget;
import com.betterbudget.betterbudgetapp.models.budget.BudgetItem;
import com.betterbudget.betterbudgetapp.models.request.CreateBudgetRequest;
import com.betterbudget.betterbudgetapp.stores.BudgetStore;

@RestController
@RequestMapping("/betterBudget/v1")
public class BudgetService {
	BudgetStore store = BudgetStore.getBudgetStore();

	@PostMapping("/budget")
	public CreateBudgetRequest createBudget(@RequestBody CreateBudgetRequest budget) {
		store.addBudget(budget);
		return budget;
	}

	@GetMapping("/budget")
	public Budget getBudget(@RequestParam String id) {
		return store.getBudget(id);
	}

	@PostMapping("/transaction")
	public void addTransaction(@RequestBody Budget budget) {

	}

	@PostMapping("/budgetItem")
	public void addItem(@RequestBody BudgetItem item) {

	}
}
