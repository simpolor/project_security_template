package com.simpolor.app.domain;

public class Role{

	private long role_seq;
	private String role_code;
	private String role_name;
	
	public long getRole_seq() {
		return role_seq;
	}
	public void setRole_seq(long role_seq) {
		this.role_seq = role_seq;
	}
	public String getRole_code() {
		return role_code;
	}
	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

}
