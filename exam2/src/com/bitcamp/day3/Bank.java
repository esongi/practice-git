package com.bitcamp.day3;

import java.util.ArrayList;
import java.util.List;

public class Bank {

	List<Account> accountList;
	private int totalAccount;

	public Bank() {
		accountList = new ArrayList<>();
		totalAccount = accountList.size();
	}

	void addAccount(String accountNo, String name) {
	}

	Account getAccount(String accountNo) {
		return null;
	}
	

	List<Account> findAccounts(String name){
		List<Account> result = new ArrayList<>();
		return result;
	}
	

	int getTotalAccount() {
		return totalAccount;
	}
}
