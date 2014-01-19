package com.jt.sd.entity;

import java.util.Date;

public class User {
	
	private int id;
	private String email;
	private String password;
	private String plainPassword;
	private String nickname;
	private String salt;
	/*
	 * 说明
	 * 1：普通用户
	 * 2：组长
	 * 3：管理员
	 */
	private int type;
	/* 说明
	 * 0:关闭
	 * 1:启动
	 * 
	 */
	private int status;
	
	
	private Date registerDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPlainPassword() {
		return plainPassword;
	}
	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password
				+ ", plainPassword=" + plainPassword + ", nickname=" + nickname
				+ ", salt=" + salt + ", registerDate=" + registerDate + "]";
	}
}
