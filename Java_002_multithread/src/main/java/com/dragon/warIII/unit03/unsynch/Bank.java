package com.dragon.warIII.unit03.unsynch;

/**
 * A bank with a number of bank accounts
 * @version 1.30 2004-08-01
 * @author Cay Horstmann
 */
public class Bank {

	private final double[] accounts;
	
	/**
	 * Constructs the bank
	 * @param n the number of accounts
	 * @param initialBalance the initial balance for each bank
	 */
	public Bank(int n, double initialBalance) {
		accounts = new double[n];
		for (int i=0; i< accounts.length; i++) {
			accounts[i] = initialBalance;
		}
	}
	
	/**
	 * Transfers money from one account to another
	 * @param from the account to transfer from
	 * @param to the account to transfer to 
	 * @param amount  the amount to transfer
	 */
	public void transfer(int from, int to, double amount) {
		if (accounts[from] < amount) {
			return;
		}
		System.out.println(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf("%10.2f from %d to %d", amount, from, to);
	}
}










