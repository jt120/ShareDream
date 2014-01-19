package com.jt.sd.dao;

import java.util.List;

import org.junit.Test;

import com.jt.sd.entity.Pager;
import com.jt.sd.entity.User;
import com.jt.sd.service.UserService;
import com.jt.sd.utils.Clock;

public class TestUserDao {
	
	private UserDao ud = new UserDaoImpl();
	private Clock clock = Clock.DEFAULT;
	private UserService us = new UserService();
	
	@Test
	public void testAdd() {
		User u = new User();
		u.setEmail("mn1");
		u.setPlainPassword("123");
		u.setNickname("大圣");
		us.registerUser(u);
	}
	
	
	@Test
	public void testDelete() {
		User u = new User();
		u.setId(2);
		ud.delete(u.getId());
	}
	
	@Test
	public void testUpdate() {
		User u = new User();
		u.setId(3);
		u.setEmail("monkey");
		u.setPassword("1234");
		u.setNickname("大圣4");
		ud.update(u);
	}
	
	@Test
	public void testLoad() {
		User u = new User();
		u.setEmail("monkey");
		u = ud.load(u.getEmail());
		System.out.println(u);
	}
	
	@Test
	public void testList() {
		Pager<User> users = ud.list();
		for(User user:users.getDatas()) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testLogin() {
		User u = new User();
		u.setEmail("monkey");
		u.setPassword("12345");
		System.out.println(u);
	}

}
