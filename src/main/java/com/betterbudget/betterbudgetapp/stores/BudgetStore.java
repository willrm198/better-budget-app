package com.betterbudget.betterbudgetapp.stores;

import java.util.HashMap;
import java.util.List;

import com.betterbudget.betterbudgetapp.models.account.Account;
import com.betterbudget.betterbudgetapp.models.budget.Budget;
import com.betterbudget.betterbudgetapp.models.budget.BudgetItem;
import com.betterbudget.betterbudgetapp.models.request.CreateBudgetRequest;
import com.betterbudget.betterbudgetapp.models.transaction.Transaction;

public class BudgetStore {
	private HashMap<String, Budget> budgets = new HashMap<>();
	private HashMap<String, Account> accounts = new HashMap<>();
	private HashMap<String, BudgetItem> items = new HashMap<>();
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
		if (!request.getItems().isEmpty()) {
			addItems(request.getItems());
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

	public void addBudgetItem(BudgetItem item) {
		items.put(String.valueOf(item.getId()), item);
	}

	public BudgetItem getBudgetItem(String id) {
		return items.get(id);
	}

	public void addItems(List<BudgetItem> items) {
		for (BudgetItem item : items) {
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
