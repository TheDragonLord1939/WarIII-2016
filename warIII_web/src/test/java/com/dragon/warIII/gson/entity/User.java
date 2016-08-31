package com.dragon.warIII.gson.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class User {
	
	private int id;
	private String name;
	private boolean isAdmin;
	private String[] tels;
	private List<Bank> banks;
	private Map doSome;

	public User() {
		super();
	}

	public User(int id, String name, boolean isAdmin, String[] tels,
			List<Bank> banks, Map doSome) {
		super();
		this.id = id;
		this.name = name;
		this.isAdmin = isAdmin;
		this.tels = tels;
		this.banks = banks;
		this.doSome = doSome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String[] getTels() {
		return tels;
	}

	public void setTels(String[] tels) {
		this.tels = tels;
	}

	public List<Bank> getBanks() {
		return banks;
	}

	public void setBanks(List<Bank> banks) {
		this.banks = banks;
	}

	public Map getDoSome() {
		return doSome;
	}

	public void setDoSome(Map doSome) {
		this.doSome = doSome;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", isAdmin=" + isAdmin
				+ ", tels=" + Arrays.toString(tels) + ", doSome=" + doSome
				+ "]";
	}
	
}
