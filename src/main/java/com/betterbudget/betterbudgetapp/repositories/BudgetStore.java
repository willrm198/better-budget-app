package com.betterbudget.betterbudgetapp.repositories;

import java.util.HashMap;
import java.util.List;

import com.betterbudget.betterbudgetapp.models.Account;
import com.betterbudget.betterbudgetapp.models.Budget;
import com.betterbudget.betterbudgetapp.models.CreateBudgetRequest;
import com.betterbudget.betterbudgetapp.models.Expense;
import com.betterbudget.betterbudgetapp.models.Transaction;

public class BudgetStore {
	private HashMap<String, Budget> budgets = new HashMap<>();
	private HashMap<String, Account> accounts = new HashMap<>();
	private HashMap<String, Expense> items = new HashMap<>();
	private HashMap<String, Transaction> transactions = new HashMap<>();

	public static BudgetStore getBudgetStore() {
		return new BudgetStore();
	}

	public void addBudget(CreateBudgetRequest request) {
		Budget budget = request.getBudget();
		budgets.put(String.valueOf(budget.getId()), budget);
		if (!request.getAccounts().isEmpty()) {
			addAccounts(request.getAccounts());
		}
		if (!request.getExpenses().isEmpty()) {
			addItems(request.getExpenses());
		}
	}

	public Budget getBudget(String id) {
		return budgets.get(id);
	}

	public void addAccount(Account account) {
		accounts.put(String.valueOf(account.getId()), account);
	}

	public void addAccounts(List<Account> accounts) {
		for (Account account : accounts) {
			this.accounts.put(String.valueOf(account.getId()), account);
		}
	}

	public Account getAccount(String id) {
		return accounts.get(id);
	}

	public void addBudgetItem(Expense item) {
		items.put(String.valueOf(item.getId()), item);
	}

	public Expense getBudgetItem(String id) {
		return items.get(id);
	}

	public void addItems(List<Expense> items) {
		for (Expense item : items) {
			this.items.put(String.valueOf(item.getId()), item);
		}
	}

	public void addTransaction(Transaction transaction) {
		transactions.put(String.valueOf(transaction.getId()), transaction);
	}

	public Transaction getTransaction(String id) {
		return transactions.get(id);
	}

}
