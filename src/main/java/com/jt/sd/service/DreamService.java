package com.jt.sd.service;

import com.jt.sd.dao.DreamDao;
import com.jt.sd.dao.DreamDaoImpl;
import com.jt.sd.entity.Dream;
import com.jt.sd.entity.Pager;
import com.jt.sd.utils.Clock;

public class DreamService {
	private DreamDao dreamDao = new DreamDaoImpl();
	private Clock clock = Clock.DEFAULT;
	
	public void add(Dream dream) {
		dreamDao.add(dream);
	}
	
	public void deleteById(int id) {
		dreamDao.delete(id);
	}
	
	public void update(Dream dream) {
		dreamDao.update(dream);
	}
	
	public Pager<Dream> list() {
		return dreamDao.list();
	}
	
	public Dream loadById(int id) {
		return dreamDao.loadById(id);
	}

}
