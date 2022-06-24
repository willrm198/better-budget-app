package com.betterbudget.betterbudgetapp.models;

import java.util.ArrayList;
import java.util.List;

public class BudgetResponse {

	private Budget budget;
	private List<Expense> expenses = new ArrayList<>();
	private List<Account> accounts = new ArrayList<>();
	private List<Transaction> transactions = new ArrayList<>();

	public BudgetResponse() {

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

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}
