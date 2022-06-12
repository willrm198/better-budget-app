package com.betterbudget.betterbudgetapp.models.respons;

import java.util.ArrayList;
import java.util.List;

import com.betterbudget.betterbudgetapp.models.account.Account;
import com.betterbudget.betterbudgetapp.models.budget.Budget;
import com.betterbudget.betterbudgetapp.models.budget.BudgetItem;
import com.betterbudget.betterbudgetapp.models.transaction.Transaction;

public class BudgetResponse {

	private Budget budget;

	private List<BudgetItem> items = new ArrayList<>();
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

	public List<BudgetItem> getItems() {
		return items;
	}

	public void setItems(List<BudgetItem> items) {
		this.items = items;
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
