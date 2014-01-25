package com.jt.sd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jt.sd.entity.Dream;
import com.jt.sd.entity.Group;
import com.jt.sd.utils.JDBCUtil;

public class GroupDaoImpl implements GroupDao {

	@Override
	public void add(Group group) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JDBCUtil.getConnection();
			String sql = "insert into t_group values (null,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, group.getName());
			ps.setInt(2, group.getDream().getId());
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
			String sql = "delete from t_group where id=?";
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
	public void update(Group group) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "update t_group set name=?" +
					"where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, group.getName());
			ps.setInt(2, group.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps);
			JDBCUtil.close(con);
		}
		
	}

	@Override
	public Group load(String name) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Group group = null;
		try {
			con = JDBCUtil.getConnection();
			
			String sql = "select * from t_group where name=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				group = new Group();
				group.setId(rs.getInt("id"));
				group.setName(rs.getString("name"));
				Dream dream = new Dream();
				dream.setId(rs.getInt("did"));
				group.setDream(dream);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(ps);
			JDBCUtil.close(con);
		}
		return group;
	}

	@Override
	public List<Group> list() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Group> groups = new ArrayList<Group>();
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from t_group";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Group group = new Group();
				group.setId(rs.getInt("id"));
				group.setName(rs.getString("name"));
				Dream dream = new Dream();
				dream.setId(rs.getInt("did"));
				group.setDream(dream);
				groups.add(group);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(ps);
			JDBCUtil.close(con);
		}
		return groups;
	}

}
