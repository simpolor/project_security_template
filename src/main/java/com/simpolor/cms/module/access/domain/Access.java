package com.simpolor.cms.module.access.domain;

public class Access{

	private int access_seq;
	private String access_url;
	private String access_roles;
	private String regi_id;
	private String regi_name;
	private String regi_date;
	private String modi_id;
	private String modi_name;
	private String modi_date;
	private String del_yn;
	
	public int getAccess_seq() {
		return access_seq;
	}
	public void setAccess_seq(int access_seq) {
		this.access_seq = access_seq;
	}
	public String getAccess_url() {
		return access_url;
	}
	public void setAccess_url(String access_url) {
		this.access_url = access_url;
	}
	public String getAccess_roles() {
		return access_roles;
	}
	public void setAccess_roles(String access_roles) {
		this.access_roles = access_roles;
	}
	public String getRegi_id() {
		return regi_id;
	}
	public void setRegi_id(String regi_id) {
		this.regi_id = regi_id;
	}
	public String getRegi_name() {
		return regi_name;
	}
	public void setRegi_name(String regi_name) {
		this.regi_name = regi_name;
	}
	public String getRegi_date() {
		return regi_date;
	}
	public void setRegi_date(String regi_date) {
		this.regi_date = regi_date;
	}
	public String getModi_id() {
		return modi_id;
	}
	public void setModi_id(String modi_id) {
		this.modi_id = modi_id;
	}
	public String getModi_name() {
		return modi_name;
	}
	public void setModi_name(String modi_name) {
		this.modi_name = modi_name;
	}
	public String getModi_date() {
		return modi_date;
	}
	public void setModi_date(String modi_date) {
		this.modi_date = modi_date;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	
}
