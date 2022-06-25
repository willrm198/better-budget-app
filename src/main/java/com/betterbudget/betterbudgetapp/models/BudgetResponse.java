package com.betterbudget.betterbudgetapp.models;

import java.util.List;

public class BudgetResponse extends GenericResponse {

	private Budget budget;
	private List<Expense> expenses;
	private List<Account> accounts;
	private List<Transaction> transactions;

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
