package com.just.weike.dao.bean;

import java.io.Serializable;

public class UserInfoPublic implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5900939382645825277L;
	public String LoginName;
	public String Mail;
	public UserInfoPublic(String LoginName,String Mail) {
		// TODO Auto-generated constructor stub
		this.LoginName = LoginName;
		this.Mail = Mail;
	}
	public String getLoginName() {
		return LoginName;
	}
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
}
