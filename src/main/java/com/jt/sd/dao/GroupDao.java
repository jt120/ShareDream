package com.jt.sd.dao;

import java.util.List;

import com.jt.sd.entity.Group;

public interface GroupDao {
	
	public void add(Group group);
	public void delete(int id);
	public void update(Group group);
	public Group load(String name);
	public List<Group> list();

}
