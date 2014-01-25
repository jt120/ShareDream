package com.jt.sd.service;

import com.jt.sd.dao.CommentDao;
import com.jt.sd.dao.CommentDaoImpl;
import com.jt.sd.entity.Comment;
import com.jt.sd.entity.Pager;
import com.jt.sd.utils.Clock;

public class CommentService {
	private Clock clock = Clock.DEFAULT;
	private CommentDao dao = new CommentDaoImpl();
	
	public Pager<Comment> list(int id) {
		return dao.list(id);
	}
	
	public void add(Comment comment) {
		comment.setReplyDate(clock.getCurrentDate());
		dao.add(comment);
	}

}
