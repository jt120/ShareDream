package com.jt.sd.dao;


import com.jt.sd.entity.Pager;
import com.jt.sd.entity.User;

public interface UserDao {
	
	public void add(User user);
	public void delete(int id);
	public void update(User user);
	public User load(String email);
	public Pager<User> list();
	public User login(String username, String password);
	public void uploadAvatar(User user);
}
