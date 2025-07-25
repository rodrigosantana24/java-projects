package model.entities;

import model.exceptions.DomainException;

public class Account {
	private Integer number;
	private String holder; 
	private Double balance; 
	private Double withdrawLimit; 
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		super();
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void deposit(Double amount) {
		this.balance += amount;
	}
	
	public void withdraw(Double amount) throws DomainException {
		if(amount > getWithdrawLimit()) {
			throw new DomainException("O valor ultrapassa o limite de saque");
		}
		if(amount > getBalance()) {
			throw new DomainException("Saldo insuficiente");
		}
		this.balance -= amount;
	}
	
}
