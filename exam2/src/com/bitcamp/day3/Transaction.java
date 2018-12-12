package com.bitcamp.day3;

import java.util.Calendar;

public class Transaction {

	Calendar date = Calendar.getInstance();
	private String transactionDate;
	private String transactionTime;
	private String kind;
	private long amount;
	private long balance;

	Transaction(String kind, long amount, long balance) {
		this.transactionDate = date.get(Calendar.YEAR) + "-" + (date.get(Calendar.MONTH) + 1) + "-"
				+ date.get(Calendar.DATE);
		this.transactionTime = date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE) + ":"
				+ date.get(Calendar.SECOND);
		this.kind = kind;
		this.amount = amount;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Transaction [date=" + date + ", transactionDate=" + transactionDate + ", transactionTime="
				+ transactionTime + ", kind=" + kind + ", amount=" + amount + ", balance=" + balance + "]";
	}

}
