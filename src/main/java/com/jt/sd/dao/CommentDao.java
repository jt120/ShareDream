package com.jt.sd.dao;

import com.jt.sd.entity.Comment;
import com.jt.sd.entity.Pager;

public interface CommentDao {
	
	public void add(Comment comment);
	public void delete(int id);
	public void update(Comment comment);
	public Comment load(String name);
	public Comment loadById(int id);
	public Pager<Comment> list(int id);
	public int getCommentCounts(int id);
}
