package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Accounts {
	@Id
	private int account_no;
	private int pin;
	private double opening_balance;
	private double overdraft;
	
	public Accounts() {};
	
	public Accounts(int account_no, int pin, double opening_balance, double overdraft) {
		super();
		this.account_no = account_no;
		this.pin = pin;
		this.opening_balance = opening_balance;
		this.overdraft = overdraft;
	}
	
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public double getOpening_balance() {
		return opening_balance;
	}
	public void setOpening_balance(double opening_balance) {
		this.opening_balance = opening_balance;
	}
	public double getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}
}
