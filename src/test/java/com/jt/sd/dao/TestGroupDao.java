package com.jt.sd.dao;

import java.util.List;

import org.junit.Test;

import com.jt.sd.entity.Dream;
import com.jt.sd.entity.Group;

public class TestGroupDao {
	
	private GroupDao gd = new GroupDaoImpl();
	
	@Test
	public void testAdd() {
		
		Group group = new Group();
		group.setName("名誉");
		Dream dream = new Dream();
		dream.setId(2);
		group.setDream(dream);
		gd.add(group);
	
	}
	
	
	@Test
	public void testDelete() {
		Group group = new Group();
		group.setId(1);
		gd.delete(group.getId());
	}
	
	@Test
	public void testUpdate() {
		Group group = new Group();
		group.setName("财宝2");
		group.setId(2);
		gd.update(group);
	}
	
	@Test
	public void testLoad() {
		Group group = new Group();
		group.setName("财宝");
	
		group = gd.load(group.getName());
		System.out.println(group);
	}
	
	@Test
	public void testList() {
		List<Group> groups = gd.list();
		for(Group group:groups) {
			System.out.println(group);
		}
	}

}
