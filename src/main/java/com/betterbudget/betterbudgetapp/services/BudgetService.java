package com.betterbudget.betterbudgetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.betterbudget.betterbudgetapp.models.Account;
import com.betterbudget.betterbudgetapp.models.Budget;
import com.betterbudget.betterbudgetapp.models.BudgetItem;
import com.betterbudget.betterbudgetapp.models.CreateBudgetRequest;
import com.betterbudget.betterbudgetapp.models.Transaction;
import com.betterbudget.betterbudgetapp.repositories.AccountRepository;
import com.betterbudget.betterbudgetapp.repositories.BudgetItemRepository;
import com.betterbudget.betterbudgetapp.repositories.BudgetRepository;
import com.betterbudget.betterbudgetapp.repositories.TransactionRepository;

@Service
public class BudgetService {

	@Autowired
	private BudgetRepository budgetRepo;

	@Autowired
	private AccountRepository accountRepo;

	@Autowired
	private BudgetItemRepository budgetItemRepo;

	@Autowired
	private TransactionRepository transactionRepo;

	public String createBudget(CreateBudgetRequest request) {
		saveBudget(request.getBudget());
		if (!CollectionUtils.isEmpty(request.getAccounts())) {
			saveAccounts(request.getAccounts());
		}

		if (!CollectionUtils.isEmpty(request.getItems())) {
			saveBudgetItems(request.getItems());
		}

		return "Budget created!";
	}

	public Budget saveBudget(Budget budget) {
		return budgetRepo.save(budget);
	}

	public List<Budget> getBudgets() {
		return budgetRepo.findAll();
	}

	public Budget getBudgetById(int id) {
		return budgetRepo.findById(id).orElse(null);
	}

	public List<Budget> getBudgetByType(String type) {
		return budgetRepo.findByBudgetType(type);
	}

	public String deleteBudget(int id) {
		budgetRepo.deleteById(id);
		return "Budget deleted!";
	}

	// TODO: Verify if this is needed
	public Budget updateBudget(Budget budget) {
		Budget prevBudget = budgetRepo.findById(budget.getId()).orElse(null);
		prevBudget.setBudgetType(budget.getBudgetType());
		prevBudget.setStartDate(budget.getStartDate());
		prevBudget.setEndDate(budget.getEndDate());

		return budgetRepo.save(prevBudget);
	}

	public Account saveAccount(Account account) {
		return accountRepo.save(account);
	}

	public List<Account> saveAccounts(List<Account> accounts) {
		return accountRepo.saveAll(accounts);
	}

	public List<Account> getAccounts() {
		return accountRepo.findAll();
	}

	public Account getAccountById(int id) {
		return accountRepo.findById(id).orElse(null);
	}

	public List<Account> getAccountByType(String type) {
		return accountRepo.findByAccountType(type);
	}

	public String deleteAccount(int id) {
		accountRepo.deleteById(id);
		return "Account deleted!";
	}

	public Account updateAccount(Account account) {
		Account prevAccount = accountRepo.findById(account.getId()).orElse(null);
		prevAccount.setAccountType(account.getAccountType());
		prevAccount.setBalance(account.getBalance());
		prevAccount.setLimitAmount(account.getLimitAmount());
		prevAccount.setName(account.getName());
		return accountRepo.save(prevAccount);
	}

	public BudgetItem saveBudgetItem(BudgetItem budgetItem) {
		return budgetItemRepo.save(budgetItem);
	}

	public List<BudgetItem> saveBudgetItems(List<BudgetItem> items) {
		return budgetItemRepo.saveAll(items);
	}

	public List<BudgetItem> getBudgetItems() {
		return budgetItemRepo.findAll();
	}

	public BudgetItem getBudgetItemById(int id) {
		return budgetItemRepo.findById(id).orElse(null);
	}

	public List<BudgetItem> getBudgetItemByBudgetId(int id) {
		return budgetItemRepo.findByBudgetId(id);
	}

	public String deleteBudgetItem(int id) {
		budgetItemRepo.deleteById(id);
		return "Account deleted!";
	}

	public BudgetItem updateBudgetItem(BudgetItem item) {
		BudgetItem prevItem = budgetItemRepo.findById(item.getId()).orElse(null);
		prevItem.setAmount(item.getAmount());
		prevItem.setDueDate(item.getDueDate());
		prevItem.setName(item.getName());
		return budgetItemRepo.save(prevItem);
	}

	public Transaction saveTransaction(Transaction budgetItem) {
		return transactionRepo.save(budgetItem);
	}

	public List<Transaction> getTransactions() {
		return transactionRepo.findAll();
	}

	public Transaction getTransactionById(int id) {
		return transactionRepo.findById(id).orElse(null);
	}

	public List<Transaction> getTransactionByBudgetId(int id) {
		return transactionRepo.findByBudgetId(id);
	}

	public List<Transaction> getTransactionByType(String type) {
		return transactionRepo.findByTransactionType(type);
	}

	public String deleteTransaction(int id) {
		transactionRepo.deleteById(id);
		return "Transaction deleted!";
	}

	public Transaction updateTransaction(Transaction transaction) {
		Transaction prevTransaction = transactionRepo.findById(transaction.getId()).orElse(null);
		prevTransaction.setAccountName(transaction.getAccountName());
		prevTransaction.setAmount(transaction.getAmount());
		prevTransaction.setCategory(transaction.getCategory());
		prevTransaction.setDescription(transaction.getDescription());
		prevTransaction.setTransactionDate(transaction.getTransactionDate());
		prevTransaction.setTransactionType(transaction.getTransactionType());
		return transactionRepo.save(prevTransaction);
	}

}
