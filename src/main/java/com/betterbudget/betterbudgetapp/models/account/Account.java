package com.betterbudget.betterbudgetapp.models.account;

import org.springframework.beans.factory.annotation.Autowired;

public class Account {
	private long id;
	private String name;
	private Double limit;
	private Double balance;
	private AccountType type;

	@Autowired
	public Account() {
		int min = 0;
		int max = 999999999;
		this.id = (long) Math.floor(Math.random() * (max - min + 1) + min);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLimit() {
		return limit;
	}

	public void setLimit(Double limit) {
		this.limit = limit;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

}
