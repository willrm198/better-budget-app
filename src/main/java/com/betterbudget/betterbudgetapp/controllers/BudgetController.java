package com.betterbudget.betterbudgetapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betterbudget.betterbudgetapp.models.Account;
import com.betterbudget.betterbudgetapp.models.BudgetResponse;
import com.betterbudget.betterbudgetapp.models.CreateBudgetRequest;
import com.betterbudget.betterbudgetapp.models.Expense;
import com.betterbudget.betterbudgetapp.models.Transaction;
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
	public BudgetResponse getBudget(@RequestParam int id) {
		return budgetService.getFullBudget(id);
	}

	@PostMapping("/transaction")
	public Transaction addTransaction(@RequestBody Transaction transaction) {
		return budgetService.saveTransaction(transaction);
	}

	@PutMapping("/transaction")
	public Transaction updateTransaction(@RequestBody Transaction transaction) {
		return budgetService.updateTransaction(transaction);
	}

	@DeleteMapping("/transaction")
	public String deleteTransaction(@RequestParam int id) {
		return budgetService.deleteTransaction(id);
	}

	@PostMapping("/account")
	public Account addAccount(@RequestBody Account account) {
		return budgetService.saveAccount(account);
	}

	@PutMapping("/account")
	public Account updateAccount(@RequestBody Account account) {
		return budgetService.updateAccount(account);
	}

	@PostMapping("/expense")
	public Expense addExpense(@RequestBody Expense expense) {
		return budgetService.saveExpense(expense);
	}

	@PutMapping("/expense")
	public Expense updateExpense(@RequestBody Expense expense) {
		return budgetService.updateExpense(expense);
	}

	@DeleteMapping("/expense")
	public String deleteExpense(@RequestParam int id) {
		return budgetService.deleteExpense(id);
	}
}
