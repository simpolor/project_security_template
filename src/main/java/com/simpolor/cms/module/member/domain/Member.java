package com.simpolor.cms.module.member.domain;

public class Member{

	private String member_id;
	private String member_pw;
	private String member_pw_confirm;
	private String member_name;
	private String member_email;
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_pw_confirm() {
		return member_pw_confirm;
	}
	public void setMember_pw_confirm(String member_pw_confirm) {
		this.member_pw_confirm = member_pw_confirm;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	
}
