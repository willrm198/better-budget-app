package com.betterbudget.betterbudgetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.betterbudget.betterbudgetapp.models.Account;
import com.betterbudget.betterbudgetapp.models.Budget;
import com.betterbudget.betterbudgetapp.models.BudgetResponse;
import com.betterbudget.betterbudgetapp.models.CreateBudgetRequest;
import com.betterbudget.betterbudgetapp.models.Expense;
import com.betterbudget.betterbudgetapp.models.Transaction;
import com.betterbudget.betterbudgetapp.repositories.AccountRepository;
import com.betterbudget.betterbudgetapp.repositories.BudgetRepository;
import com.betterbudget.betterbudgetapp.repositories.ExpenseRepository;
import com.betterbudget.betterbudgetapp.repositories.TransactionRepository;

@Service
public class BudgetService {

	@Autowired
	private BudgetRepository budgetRepo;

	@Autowired
	private AccountRepository accountRepo;

	@Autowired
	private ExpenseRepository expenseRepo;

	@Autowired
	private TransactionRepository transactionRepo;

	public String createBudget(CreateBudgetRequest request) {
		saveBudget(request.getBudget());
		if (!CollectionUtils.isEmpty(request.getAccounts())) {
			saveAccounts(request.getAccounts());
		}

		if (!CollectionUtils.isEmpty(request.getExpenses())) {
			saveExpenses(request.getExpenses());
		}

		return "Budget created!";
	}

	public String saveBudget(Budget budget) {
		budgetRepo.save(budget);
		return "Budget saved!";
	}

	public List<Budget> getBudgets() {
		return budgetRepo.findAll();
	}

	public BudgetResponse getFullBudget(int id) {
		Budget budget = getBudgetById(id);
		List<Expense> expenses = getExpenseByBudgetId(id);
		List<Account> accounts = getAccountsByBudgetId(id);
		List<Transaction> transactions = getTransactionsByBudgetId(id);
		BudgetResponse response = new BudgetResponse();
		response.setBudget(budget);
		response.setExpenses(expenses);
		response.setAccounts(accounts);
		response.setTransactions(transactions);
		return response;
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

	public String saveAccount(Account account) {
		accountRepo.save(account);
		return "Account saved!";
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

	public List<Account> getAccountsByBudgetId(int id) {
		return accountRepo.findByBudgetId(id);
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

	public String saveExpense(Expense expense) {
		expenseRepo.save(expense);
		return "Expense saved!";
	}

	public List<Expense> saveExpenses(List<Expense> expenses) {
		return expenseRepo.saveAll(expenses);
	}

	public List<Expense> getExpenses() {
		return expenseRepo.findAll();
	}

	public Expense getExpenseById(int id) {
		return expenseRepo.findById(id).orElse(null);
	}

	public List<Expense> getExpenseByBudgetId(int id) {
		return expenseRepo.findByBudgetId(id);
	}

	public String deleteExpense(int id) {
		expenseRepo.deleteById(id);
		return "Expense deleted!";
	}

	public Expense updateExpense(Expense expense) {
		Expense prevExpense = expenseRepo.findById(expense.getId()).orElse(null);
		prevExpense.setAmount(expense.getAmount());
		prevExpense.setDueDate(expense.getDueDate());
		prevExpense.setName(expense.getName());
		return expenseRepo.save(prevExpense);
	}

	public String saveTransaction(Transaction transaction) {
		transactionRepo.save(transaction);
		return "Transaction saved!";
	}

	public List<Transaction> getTransactions() {
		return transactionRepo.findAll();
	}

	public Transaction getTransactionById(int id) {
		return transactionRepo.findById(id).orElse(null);
	}

	public List<Transaction> getTransactionsByBudgetId(int id) {
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
