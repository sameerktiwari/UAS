package com.cg.uas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/************************************************************************************
 * File: User.java 
 * Package: com.cg.uas.entities 
 * Description: Login credential of
 * 				users which are applicable 
 * Version: 1.0 
 * Modifications: 
 * Author: Group5 Date:14th-Nov-2017 Change Description:
 ************************************************************************************/
@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "login_id")
	String loginId;
	@Column(name = "password")
	String password;
	@Column(name = "role")
	String role;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User(String loginId, String password, String role) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.role = role;
	}

	public User() {
		super();
	}
}
