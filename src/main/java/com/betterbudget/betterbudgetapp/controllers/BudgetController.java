package com.betterbudget.betterbudgetapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betterbudget.betterbudgetapp.models.Budget;
import com.betterbudget.betterbudgetapp.models.CreateBudgetRequest;
import com.betterbudget.betterbudgetapp.services.BudgetService;

@RestController
@RequestMapping("/betterBudget/v1")
public class BudgetController {
	@Autowired
	private BudgetService budgetService;

	@PostMapping("/budget")
	public CreateBudgetRequest createBudget(@RequestBody CreateBudgetRequest budget) {
		budgetService.createBudget(budget);
		return budget;
	}

	@GetMapping("/budget")
	public Budget getBudget(@RequestParam String id) {
		return budgetService.getBudgetById(Integer.parseInt(id));
	}

}
