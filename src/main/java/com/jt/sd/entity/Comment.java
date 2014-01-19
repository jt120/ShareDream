package com.jt.sd.entity;

import java.util.Date;

public class Comment {
	
	private int id;
	private String content;
	private Dream dream;
	private User user;
	private Date replyDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Dream getDream() {
		return dream;
	}
	public void setDream(Dream dream) {
		this.dream = dream;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
}
