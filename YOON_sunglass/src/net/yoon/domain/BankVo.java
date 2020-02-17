package net.yoon.domain;

public class BankVo {
	private String account;
	private String bank;
	private String name;
	
	public BankVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankVo(String account, String bank, String name) {
		super();
		this.account = account;
		this.bank = bank;
		this.name = name;
	}
	
	
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BankVo [account=" + account + ", bank=" + bank + ", name=" + name + "]";
	}
}
