package com.betterbudget.betterbudgetapp.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

public class CreateBudgetRequest {

	@NotNull(message = "Request must include a budget.")
	@Valid
	private Budget budget;
	private List<Expense> expenses = new ArrayList<>();
	private List<Account> accounts = new ArrayList<>();

	public CreateBudgetRequest() {

	}

	@Autowired
	public CreateBudgetRequest(Budget budget) {
		this.budget = budget;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
