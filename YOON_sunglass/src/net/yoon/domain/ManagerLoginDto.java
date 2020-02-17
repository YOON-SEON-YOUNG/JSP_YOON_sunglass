package net.yoon.domain;

public class ManagerLoginDto {
	private String manager_id;
	private String manager_pw;
	
	public ManagerLoginDto() {
		super();
	}

	public ManagerLoginDto(String manager_id, String manager_pw) {
		super();
		this.manager_id = manager_id;
		this.manager_pw = manager_pw;
	}

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	public String getManager_pw() {
		return manager_pw;
	}

	public void setManager_pw(String manager_pw) {
		this.manager_pw = manager_pw;
	}

	@Override
	public String toString() {
		return "ManagerLoginDto [manager_id=" + manager_id + ", manager_pw=" + manager_pw + "]";
	}

	
	
}
