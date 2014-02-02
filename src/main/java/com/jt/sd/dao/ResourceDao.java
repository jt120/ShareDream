package com.jt.sd.dao;


import com.jt.sd.entity.Pager;
import com.jt.sd.entity.Resource;

public interface ResourceDao {
	
	public void add(Resource resource);
	public void delete(int id);
	public void update(Resource resource);
	public Resource load(int id);
}
