package com.jt.sd.entity;

public class Dream {
	
	private int id;
	private String name;
	private String content;
	private User user;
	private int commentNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public int getCommentNumber() {
		return commentNumber;
	}
	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}
	@Override
	public String toString() {
		return "Dream [id=" + id + ", name=" + name + ", user=" + user + "]";
	}
	
}
