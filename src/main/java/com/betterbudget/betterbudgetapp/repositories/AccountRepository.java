package com.betterbudget.betterbudgetapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betterbudget.betterbudgetapp.models.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	List<Account> findByAccountType(String type);

}
