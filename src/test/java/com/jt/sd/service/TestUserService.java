package com.jt.sd.service;

import org.junit.Test;

import com.jt.sd.entity.User;
import com.jt.sd.utils.Digests;
import com.jt.sd.utils.Encodes;

public class TestUserService {
	
	UserService us = new UserService();
	
	@Test
	public void testRegister() {
		User user = new User();
		user.setEmail("test2");
		user.setPlainPassword("test");
		user.setNickname("haha");
		us.registerUser(user);
	}
	
	@Test
	public void testLogin() {
		
		us.login("test2","test");
	}
	
	@Test
	public void testHex() {
		String salt = "ef70ae4326616f8f";
		byte[] s = Encodes.decodeHex(salt);
		String password = "123";
		String p = null;
		for(int i=0;i<10;i++) {
			byte[] tmp = Digests.sha1(password.getBytes(), s, 1024);
			p = Encodes.encodeHex(tmp);
			System.out.println(p);
		}
		
	}

}
