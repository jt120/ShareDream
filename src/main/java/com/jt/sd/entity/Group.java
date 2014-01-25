package com.jt.sd.entity;

public class Group {
	
	private int id;
	private String name;
	private Dream dream;
	
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
	public Dream getDream() {
		return dream;
	}
	public void setDream(Dream dream) {
		this.dream = dream;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", dream=" + dream + "]";
	}

}
