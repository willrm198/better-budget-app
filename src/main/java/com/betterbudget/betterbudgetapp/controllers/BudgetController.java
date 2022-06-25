package com.betterbudget.betterbudgetapp.controllers;

import java.util.Arrays;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betterbudget.betterbudgetapp.errors.BBError;
import com.betterbudget.betterbudgetapp.errors.ErrorDetails;
import com.betterbudget.betterbudgetapp.models.Account;
import com.betterbudget.betterbudgetapp.models.BudgetResponse;
import com.betterbudget.betterbudgetapp.models.CreateBudgetRequest;
import com.betterbudget.betterbudgetapp.models.Expense;
import com.betterbudget.betterbudgetapp.models.GenericResponse;
import com.betterbudget.betterbudgetapp.models.Transaction;
import com.betterbudget.betterbudgetapp.services.BudgetService;

@RestController
@RequestMapping("/betterBudget/v1")
public class BudgetController {
	@Autowired
	private BudgetService budgetService;

	@PostMapping("/budget")
	public ResponseEntity<GenericResponse> createBudget(@RequestBody CreateBudgetRequest request) {
		GenericResponse response = new GenericResponse();
		try {
			if (!request.getBudget().isDateRangeValid()) {
				throw new ValidationException("Date range is invalid for budget type.");
			}
			String message = budgetService.createBudget(request);
			response.setMessage(message);
			return ResponseEntity.status(HttpStatus.OK).body(response);

		}
		catch (ValidationException ve) {
			ErrorDetails error = BBError.VALIDATION_ERROR.getErrorDetails();
			error.setInternalMessage(ve.getMessage());
			response.addError(error);
			response.setStatusCode(String.valueOf(BBError.VALIDATION_ERROR.getStatusCode()));
			return ResponseEntity.status(BBError.VALIDATION_ERROR.getStatusCode()).body(response);
		}
		catch (Exception e) {
			ErrorDetails error = BBError.UNKNOWN_PROCESSING_ERROR.getErrorDetails();
			error.setInternalMessage(e.getMessage());
			error.setErrorCode(e.getClass().getName());
			response.addError(error);
			response.setStatusCode(String.valueOf(BBError.UNKNOWN_PROCESSING_ERROR.getStatusCode()));
			return ResponseEntity.status(BBError.UNKNOWN_PROCESSING_ERROR.getStatusCode()).body(response);
		}
	}

	@GetMapping("/budget")
	public ResponseEntity<BudgetResponse> getBudget(@RequestParam int id) {
		BudgetResponse response = new BudgetResponse();
		try {
			response = budgetService.getFullBudget(id);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		catch (ValidationException ve) {
			ErrorDetails error = BBError.VALIDATION_ERROR.getErrorDetails();
			error.setInternalMessage(ve.getMessage());
			response.addError(error);
			response.setStatusCode(String.valueOf(BBError.VALIDATION_ERROR.getStatusCode()));
			return ResponseEntity.status(BBError.VALIDATION_ERROR.getStatusCode()).body(response);
		}
		catch (Exception e) {
			ErrorDetails error = BBError.UNKNOWN_PROCESSING_ERROR.getErrorDetails();
			error.setInternalMessage(e.getMessage());
			error.setErrorCode(e.getClass().getName());
			response.addError(error);
			response.setStatusCode(String.valueOf(BBError.UNKNOWN_PROCESSING_ERROR.getStatusCode()));
			return ResponseEntity.status(BBError.UNKNOWN_PROCESSING_ERROR.getStatusCode()).body(response);
		}
	}

	@PostMapping("/transaction")
	public ResponseEntity<GenericResponse> addTransaction(@RequestBody Transaction transaction) {
		GenericResponse response = new GenericResponse();
		try {
			String message = budgetService.saveTransaction(transaction);
			response.setMessage(message);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		catch (ValidationException ve) {
			ErrorDetails error = BBError.VALIDATION_ERROR.getErrorDetails();
			error.setInternalMessage(ve.getMessage());
			response.addError(error);
			response.setStatusCode(String.valueOf(BBError.VALIDATION_ERROR.getStatusCode()));
			return ResponseEntity.status(BBError.VALIDATION_ERROR.getStatusCode()).body(response);
		}
		catch (Exception e) {
			ErrorDetails error = BBError.UNKNOWN_PROCESSING_ERROR.getErrorDetails();
			error.setInternalMessage(e.getMessage());
			error.setErrorCode(e.getClass().getName());
			response.addError(error);
			response.setStatusCode(String.valueOf(BBError.UNKNOWN_PROCESSING_ERROR.getStatusCode()));
			return ResponseEntity.status(BBError.UNKNOWN_PROCESSING_ERROR.getStatusCode()).body(response);
		}
	}

	@PutMapping("/transaction")
	public ResponseEntity<BudgetResponse> updateTransaction(@RequestBody Transaction transaction) {
		BudgetResponse response = new BudgetResponse();
		try {
			Transaction updatedTransaction = budgetService.updateTransaction(transaction);
			response.setTransactions(Arrays.asList(updatedTransaction));
			response.setMessage("Transaction updated!");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		catch (ValidationException ve) {
			ErrorDetails error = BBError.VALIDATION_ERROR.getErrorDetails();
			error.setInternalMessage(ve.getMessage());
			response.addError(error);
			response.setStatusCode(String.valueOf(BBError.VALIDATION_ERROR.getStatusCode()));
			return ResponseEntity.status(BBError.VALIDATION_ERROR.getStatusCode()).body(response);
		}
		catch (Exception e) {
			ErrorDetails error = BBError.UNKNOWN_PROCESSING_ERROR.getErrorDetails();
			error.setInternalMessage(e.getMessage());
			error.setErrorCode(e.getClass().getName());
			response.addError(error);
			response.setStatusCode(String.valueOf(BBError.UNKNOWN_PROCESSING_ERROR.getStatusCode()));
			return ResponseEntity.status(BBError.UNKNOWN_PROCESSING_ERROR.getStatusCode()).body(response);
		}
	}

	@DeleteMapping("/transaction")
	public ResponseEntity<GenericResponse> deleteTransaction(@RequestParam int id) {
		GenericResponse response = new GenericResponse();
		try {
			String message = budgetService.deleteTransaction(id);
			response.setMessage(message);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		catch (ValidationException ve) {
			ErrorDetails error = BBError.VALIDATION_ERROR.getErrorDetails();
			error.setInternalMessage(ve.getMessage());
			response.addError(error);
			response.setStatusCode(String.valueOf(BBError.VALIDATION_ERROR.getStatusCode()));
			return ResponseEntity.status(BBError.VALIDATION_ERROR.getStatusCode()).body(response);
		}
		catch (Exception e) {
			ErrorDetails error = BBError.UNKNOWN_PROCESSING_ERROR.getErrorDetails();
			error.setInternalMessage(e.getMessage());
			error.setErrorCode(e.getClass().getName());
			response.addError(error);
			response.setStatusCode(String.valueOf(BBError.UNKNOWN_PROCESSING_ERROR.getStatusCode()));
			return ResponseEntity.status(BBError.UNKNOWN_PROCESSING_ERROR.getStatusCode()).body(response);
		}
	}

	@PostMapping("/account")
	public ResponseEntity<GenericResponse> addAccount(@RequestBody Account account) {
		GenericResponse response = new GenericResponse();
		try {
			String message = budgetService.saveAccount(account);
			response.setMessage(message);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		catch (ValidationException ve) {
			ErrorDetails error = BBError.VALIDATION_ERROR.getErrorDetails();
			error.setInternalMessage(ve.getMessage());
			response.addError(error);
			response.setStatusCode(String.valueOf(BBError.VALIDATION_ERROR.getStatusCode()));
			return ResponseEntity.status(BBError.VALIDATION_ERROR.getStatusCode()).body(response);
		}
		catch (Exception e) {
			ErrorDetails error = BBError.UNKNOWN_PROCESSING_ERROR.getErrorDetails();
			error.setInternalMessage(e.getMessage());
			error.setErrorCode(e.getClass().getName());
			response.addError(error);
			response.setStatusCode(String.valueOf(BBError.UNKNOWN_PROCESSING_ERROR.getStatusCode()));
			return ResponseEntity.status(BBError.UNKNOWN_PROCESSING_ERROR.getStatusCode()).body(response);
		}
	}

	@PutMapping("/account")
	public ResponseEntity<BudgetResponse> updateAccount(@RequestBody Account account) {
		BudgetResponse response = new BudgetResponse();
		try {
			Account updatedAccount = budgetService.updateAccount(account);
			response.setAccounts(Arrays.asList(updatedAccount));
			response.setMessage("Account updated!");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		catch (ValidationException ve) {
			ErrorDetails error = BBError.VALIDATION_ERROR.getErrorDetails();
			error.setInternalMessage(ve.getMessage());
			response.addError(error);
			response.setStatusCode(String.valueOf(BBError.VALIDATION_ERROR.getStatusCode()));
			return ResponseEntity.status(BBError.VALIDATION_ERROR.getStatusCode()).body(response);
		}
		catch (Exception e) {
			ErrorDetails error = BBError.UNKNOWN_PROCESSING_ERROR.getErrorDetails();
			error.setInternalMessage(e.getMessage());
			error.setErrorCode(e.getClass().getName());
			response.addError(error);
			response.setStatusCode(String.valueOf(BBError.UNKNOWN_PROCESSING_ERROR.getStatusCode()));
			return ResponseEntity.status(BBError.UNKNOWN_PROCESSING_ERROR.getStatusCode()).body(response);
		}
	}

	@PostMapping("/expense")
	public ResponseEntity<GenericResponse> addExpense(@RequestBody Expense expense) {
		GenericResponse response = new GenericResponse();
		try {
			String message = budgetService.saveExpense(expense);
			response.setMessage(message);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		catch (ValidationException ve) {
			ErrorDetails error = BBError.VALIDATION_ERROR.getErrorDetails();
			error.setInternalMessage(ve.getMessage());
			response.addError(error);
			response.setStatusCode(String.valueOf(BBError.VALIDATION_ERROR.getStatusCode()));
			return ResponseEntity.status(BBError.VALIDATION_ERROR.getStatusCode()).body(response);
		}
		catch (Exception e) {
			ErrorDetails error = BBError.UNKNOWN_PROCESSING_ERROR.getErrorDetails();
			error.setInternalMessage(e.getMessage());
			error.setErrorCode(e.getClass().getName());
			response.addError(error);
			response.setStatusCode(String.valueOf(BBError.UNKNOWN_PROCESSING_ERROR.getStatusCode()));
			return ResponseEntity.status(BBError.UNKNOWN_PROCESSING_ERROR.getStatusCode()).body(response);
		}
	}

	@PutMapping("/expense")
	public ResponseEntity<BudgetResponse> updateExpense(@RequestBody Expense expense) {
		BudgetResponse response = new BudgetResponse();
		try {
			Expense updatedExpense = budgetService.updateExpense(expense);
			response.setExpenses(Arrays.asList(updatedExpense));
			response.setMessage("Expense updated!");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		catch (ValidationException ve) {
			ErrorDetails error = BBError.VALIDATION_ERROR.getErrorDetails();
			error.setInternalMessage(ve.getMessage());
			response.addError(error);
			response.setStatusCode(String.valueOf(BBError.VALIDATION_ERROR.getStatusCode()));
			return ResponseEntity.status(BBError.VALIDATION_ERROR.getStatusCode()).body(response);
		}
		catch (Exception e) {
			ErrorDetails error = BBError.UNKNOWN_PROCESSING_ERROR.getErrorDetails();
			error.setInternalMessage(e.getMessage());
			error.setErrorCode(e.getClass().getName());
			response.addError(error);
			response.setStatusCode(String.valueOf(BBError.UNKNOWN_PROCESSING_ERROR.getStatusCode()));
			return ResponseEntity.status(BBError.UNKNOWN_PROCESSING_ERROR.getStatusCode()).body(response);
		}
	}

	@DeleteMapping("/expense")
	public ResponseEntity<GenericResponse> deleteExpense(@RequestParam int id) {
		GenericResponse response = new GenericResponse();
		try {
			String message = budgetService.deleteExpense(id);
			response.setMessage(message);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		catch (ValidationException ve) {
			ErrorDetails error = BBError.VALIDATION_ERROR.getErrorDetails();
			error.setInternalMessage(ve.getMessage());
			response.addError(error);
			response.setStatusCode(String.valueOf(BBError.VALIDATION_ERROR.getStatusCode()));
			return ResponseEntity.status(BBError.VALIDATION_ERROR.getStatusCode()).body(response);
		}
		catch (Exception e) {
			ErrorDetails error = BBError.UNKNOWN_PROCESSING_ERROR.getErrorDetails();
			error.setInternalMessage(e.getMessage());
			error.setErrorCode(e.getClass().getName());
			response.addError(error);
			response.setStatusCode(String.valueOf(BBError.UNKNOWN_PROCESSING_ERROR.getStatusCode()));
			return ResponseEntity.status(BBError.UNKNOWN_PROCESSING_ERROR.getStatusCode()).body(response);
		}
	}
}
