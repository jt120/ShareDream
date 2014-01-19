package com.jt.sd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jt.sd.entity.Pager;
import com.jt.sd.entity.SystemContext;
import com.jt.sd.entity.User;
import com.jt.sd.entity.UserException;
import com.jt.sd.utils.JDBCUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public void add(User user) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConnection();
			//判断用户是否存在
			String sql = "select count(*) from t_user where email=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			rs = ps.executeQuery();
			int count = 0;
			while(rs.next()) {
				count = rs.getInt(1);
			}
			if(count>0) throw new UserException("要添加的用户已经存在，不能添加!");
			//添加用户
			sql = "insert into t_user (email,password,nickname,salt,status,type,register_date) " +
					"values (?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1,user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3,user.getNickname());
			ps.setString(4, user.getSalt());
			ps.setInt(5, user.getStatus());
			ps.setInt(6, user.getType());
			ps.setTimestamp(7,new java.sql.Timestamp(user.getRegisterDate().getTime()));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(ps);
			JDBCUtil.close(con);
		}

	}

	@Override
	public void delete(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JDBCUtil.getConnection();
			String sql = "delete from t_user where id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps);
			JDBCUtil.close(con);
		}

	}

	@Override
	public void update(User user) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "update t_user set password=?, nickname=? " +
					"where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getNickname());
			ps.setInt(3, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps);
			JDBCUtil.close(con);
		}

	}

	@Override
	public User load(String email) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "select * from t_user where email=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setSalt(rs.getString("salt"));
				user.setStatus(rs.getInt("status"));
				user.setType(rs.getInt("type"));
				user.setRegisterDate(new java.util.Date(rs.getTimestamp("register_date").getTime()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(ps);
			JDBCUtil.close(con);
		}
		return user;
	}

	@Override
	public Pager<User> list() {
		int pageSize = SystemContext.getPageSize();
		int pageOffset = SystemContext.getPageOffset();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Pager<User> pager = new Pager<User>();
		List<User> users = new ArrayList<User>();
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from t_user";
			String sql2 = "select count(*) from t_user";
			sql += " limit ?,?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pageOffset);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setRegisterDate(rs.getTimestamp("register_date"));
				user.setStatus(rs.getInt("status"));
				user.setType(rs.getInt("type"));
				users.add(user);
			}
			ps = con.prepareStatement(sql2);
			rs = ps.executeQuery();
			int totalRecord = 0;
			while(rs.next()) {
				totalRecord = rs.getInt(1);
			}
			int totalPage = (totalRecord-1)/pageSize+1;
			pager.setPageSize(pageSize);
			pager.setOffset(pageOffset);
			pager.setTotalPage(totalPage);
			pager.setTotalRecord(totalRecord);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(ps);
			JDBCUtil.close(con);
		}
		pager.setDatas(users);
		return pager;
	}

	@Override
	public User login(String email, String password) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "select * from t_user where email=? and password=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setType(rs.getInt("type"));
				user.setStatus(rs.getInt("status"));
				user.setRegisterDate(rs.getTimestamp("register_date"));
			}
			if(user == null) {
				throw new UserException("用户名或密码错误");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(ps);
			JDBCUtil.close(con);
		}
		return user;
	}

}
