package com.jt.sd.service;


import com.jt.sd.dao.UserDao;
import com.jt.sd.dao.UserDaoImpl;
import com.jt.sd.entity.Pager;
import com.jt.sd.entity.User;
import com.jt.sd.entity.UserException;
import com.jt.sd.utils.Clock;
import com.jt.sd.utils.Digests;
import com.jt.sd.utils.Encodes;

public class UserService {
	
	private UserDao userDao = new UserDaoImpl();
	private Clock clock = Clock.DEFAULT;
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;
	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(User user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}
	
	public void registerUser(User user) {
		entryptPassword(user);
		user.setRegisterDate(clock.getCurrentDate());
		userDao.add(user);
	}
	
	public void login(String email, String password) {
		User u = userDao.load(email);
		byte[] salt = Encodes.decodeHex(u.getSalt());
		byte[] hashPassword = Digests.sha1(password.getBytes(), salt, HASH_INTERATIONS);
		String p = Encodes.encodeHex(hashPassword);
		String dbPassword = u.getPassword();
		
		
		if(p==dbPassword||p.equals(dbPassword)) {
			
		} else if(u.getStatus()==0){
			throw new UserException("用户已被禁用");
		} else {
			throw new UserException("用户名或密码错误");
		}
	}
	
	public User loadByEmail(String email) {
		User user = userDao.load(email);
		return user;
	}
	
	public void delete(int id) {
		userDao.delete(id);
	}
	
	public Pager<User> list() {
		return userDao.list();
	}
	

}
