package com.jt.sd.dao;

import java.util.List;

import org.junit.Test;

import com.jt.sd.entity.Dream;
import com.jt.sd.entity.Pager;
import com.jt.sd.entity.User;

public class TestDreamDao {
	
	private DreamDao dd = new DreamDaoImpl();
	
	@Test
	public void testAdd() {
		Dream dream = new Dream();
		dream.setName("取经");
		User user = new User();
		user.setId(3);
		dream.setUser(user);
		dd.add(dream);
	}
	
	
	@Test
	public void testDelete() {
		Dream dream = new Dream();
		dream.setName("取经");
		dream.setId(1);
		dd.delete(dream.getId());
	}
	
	@Test
	public void testUpdate() {
		Dream dream = new Dream();
		dream.setName("取经2");
		dream.setId(2);
		dd.update(dream);
	}
	
	@Test
	public void testLoad() {
		Dream dream = new Dream();
		dream.setName("取经2");;
		dream = dd.load(dream.getName());
		System.out.println(dream);
	}
	
	@Test
	public void testList() {
		Pager<Dream> dreams = dd.list();
		for(Dream dream:dreams.getDatas()) {
			System.out.println(dream);
		}
	}


}
