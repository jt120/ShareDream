package com.jt.sd.dao;

import com.jt.sd.entity.Dream;
import com.jt.sd.entity.Pager;

public interface DreamDao {
	
	public void add(Dream dream);
	public void delete(int id);
	public void update(Dream dream);
	public Dream load(String name);
	public Dream loadById(int id);
	public Pager<Dream> list();

}
