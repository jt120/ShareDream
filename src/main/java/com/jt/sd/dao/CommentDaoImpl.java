package com.jt.sd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jt.sd.entity.Comment;
import com.jt.sd.entity.Dream;
import com.jt.sd.entity.Pager;
import com.jt.sd.entity.SystemContext;
import com.jt.sd.entity.User;
import com.jt.sd.utils.JDBCUtil;

public class CommentDaoImpl implements CommentDao {

	@Override
	public void add(Comment comment) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JDBCUtil.getConnection();
			String sql = "insert into t_comment values (null,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, comment.getContent());
			ps.setTimestamp(2, new java.sql.Timestamp(comment.getReplyDate().getTime()));
			ps.setInt(3, comment.getUser().getId());
			ps.setInt(4, comment.getDream().getId());
			ps.executeUpdate();
			String sqlUpdate = "update t_dream set c_num=? where id=?";
			int count = getCommentCounts(comment.getDream().getId());
			ps = con.prepareStatement(sqlUpdate);
			ps.setInt(1, count);
			ps.setInt(2, comment.getDream().getId());
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
			String sql = "delete from t_comment where id=?";
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
	public void update(Comment comment) {
		// TODO Auto-generated method stub

	}

	@Override
	public Comment load(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment loadById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<Comment> list(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Pager<Comment> pager = new Pager<Comment>();
		List<Comment> comments = new ArrayList<Comment>();
		int pageOffset = SystemContext.getPageOffset();
		int pageSize = SystemContext.getPageSize();
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from t_comment where d_id=? limit ?,? ";
			String sqlCount = "select count(*) from t_comment where d_id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(2, pageOffset);
			ps.setInt(3, pageSize);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Comment comment = new Comment();
				comment.setId(rs.getInt("id"));
				comment.setContent(rs.getString("content"));
				comment.setReplyDate(rs.getTimestamp("reply_date"));
				User user = new User();
				user.setId(rs.getInt("u_id"));
				comment.setUser(user);
				Dream dream = new Dream();
				dream.setId(rs.getInt("d_id"));
				comment.setDream(dream);
				comments.add(comment);
			}
			ps = con.prepareStatement(sqlCount);
			ps.setInt(1, id);
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
		pager.setDatas(comments);
		return pager;
	}

	@Override
	public int getCommentCounts(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;;
		try {
			con = JDBCUtil.getConnection();
			String sql = "select count(*) from t_comment where d_id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps);
			JDBCUtil.close(rs);
			JDBCUtil.close(con);
		}
		return count;
	}

}
