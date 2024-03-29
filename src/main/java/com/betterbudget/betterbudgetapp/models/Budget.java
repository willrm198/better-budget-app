package com.betterbudget.betterbudgetapp.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
@Table(name = "budget")
public class Budget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Start date is required.")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate startDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "End date is required.")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate endDate;
	@NotNull(message = "Budget type is required.")
	private BudgetType budgetType;

	public Budget() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public BudgetType getBudgetType() {
		return budgetType;
	}

	public void setBudgetType(BudgetType budgetType) {
		this.budgetType = budgetType;
	}

	@JsonIgnore
	public boolean isDateRangeValid() {
		boolean valid = true;
		long days = ChronoUnit.DAYS.between(startDate, endDate);

		switch (budgetType) {
		case DAILY:
			if (days != 0) {
				valid = false;
			}
			break;
		case BI_WEEKLY:
			if (days != 14) {
				valid = false;
			}
			break;
		case MONTHLY:
			if (!(days >= 28 && days <= 31)) {
				valid = false;
			}
			break;
		case YEARLY:
			if (days != 365) {
				valid = false;
			}
			break;
		default:
		}
		return valid;
	}
}
