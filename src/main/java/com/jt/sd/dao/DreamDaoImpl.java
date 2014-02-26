package com.jt.sd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jt.sd.entity.Dream;
import com.jt.sd.entity.Pager;
import com.jt.sd.entity.SystemContext;
import com.jt.sd.entity.User;
import com.jt.sd.utils.JDBCUtil;

public class DreamDaoImpl implements DreamDao {

	@Override
	public void add(Dream dream) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JDBCUtil.getConnection();
			String sql = "insert into t_dream (name,content,u_id) values (?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dream.getName());
			ps.setString(2, dream.getContent());
			ps.setInt(3, dream.getUser().getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
			String sql = "delete from t_dream where id=?";
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
	public void update(Dream dream) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "update t_dream set name=?,content=?" +
					"where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dream.getName());
			ps.setString(2, dream.getContent());
			ps.setInt(3, dream.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps);
			JDBCUtil.close(con);
		}
		
	}

	@Override
	public Dream load(String name) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Dream dream = null;
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "select * from t_dream where name=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				dream = new Dream();
				dream.setId(rs.getInt("id"));
				dream.setName(rs.getString("name"));
				dream.setContent(rs.getString("content"));
				User user = new User();
				user.setId(rs.getInt("u_id"));
				dream.setUser(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(ps);
			JDBCUtil.close(con);
		}
		return dream;
	}

	@Override
	public Pager<Dream> list() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Pager<Dream> pager = new Pager<Dream>();
		List<Dream> dreams = new ArrayList<Dream>();
		int pageOffset = SystemContext.getPageOffset();
		int pageSize = SystemContext.getPageSize();
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from t_dream limit ?,?";
			String sqlCount = "select count(*) from t_dream";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pageOffset);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while(rs.next()) {
				Dream dream = new Dream();
				dream.setId(rs.getInt("id"));
				dream.setName(rs.getString("name"));
				dream.setContent(rs.getString("content"));
				dream.setCommentNumber(rs.getInt("c_num"));
				User user = new User();
				user.setId(rs.getInt("u_id"));
				dream.setUser(user);
				dreams.add(dream);
			}
			ps = con.prepareStatement(sqlCount);
			rs = ps.executeQuery();
			int totalRecord = 0;
			while(rs.next()) {
				totalRecord = rs.getInt(1);
			}
			int totalPage = (totalRecord-1)/pageSize+1;
			pager.setOffset(pageOffset);
			pager.setPageSize(pageSize);
			pager.setTotalPage(totalPage);
			pager.setTotalRecord(totalRecord);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(ps);
			JDBCUtil.close(con);
		}
		pager.setDatas(dreams);
		return pager;
	}

	@Override
	public Dream loadById(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Dream dream = null;
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "select * from t_dream where id=?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				dream = new Dream();
				dream.setId(rs.getInt("id"));
				dream.setName(rs.getString("name"));
				dream.setContent(rs.getString("content"));
				User user = new User();
				user.setId(rs.getInt("u_id"));
				dream.setUser(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(ps);
			JDBCUtil.close(con);
		}
		return dream;
	}

}
