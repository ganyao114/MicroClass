package com.just.weike.dao.bean;

import java.io.Serializable;

public class UserInfoPrivate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String LoginName;
	private String LoginPassword;
	private String Mail;
        private String College;

    public String getCollege() {
        return College;
    }

    public void setCollege(String College) {
        this.College = College;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }
        private String Subject;
        private String Grade;
	public UserInfoPrivate() {
		// TODO Auto-generated constructor stub
	}
	public String getLoginName() {
		return LoginName;
	}
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}
	public String getLoginPassword() {
		return LoginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		LoginPassword = loginPassword;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
}
