package com.dragon.warIII.gson.entity;

public class Bank {
	
	private Integer id;
	private String bankName;
	
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bank(Integer id, String bankName) {
		super();
		this.id = id;
		this.bankName = bankName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
}
