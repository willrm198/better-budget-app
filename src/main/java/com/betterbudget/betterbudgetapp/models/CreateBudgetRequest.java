package com.betterbudget.betterbudgetapp.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CreateBudgetRequest {

	private Budget budget;
	private List<BudgetItem> items = new ArrayList<>();
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

}
