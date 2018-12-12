package com.bitcamp.day3;

import java.util.ArrayList;
import java.util.List;

public class Account {

	private String accountNo;
	private String name;
	private long balance;
	List<Transaction> tsList;

	Account(String accountNo, String name) {
		this.accountNo = accountNo;
		this.name = name;
		this.balance = 0;
		this.tsList = new ArrayList<>();
	}

	void deposit(long amount) {
		this.balance += amount;
		tsList.add(new Transaction("입금", amount, balance));
	}

	void withdraw(long amount) {
	}

	long getBalance() {
		return balance;
	}

	List<Transaction> transcations() {
		return tsList;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", name=" + name + ", balance=" + balance + ", tsList=" + tsList
				+ "]";
	}
	
}
