package com.jt.sd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jt.sd.entity.Comment;
import com.jt.sd.entity.Dream;
import com.jt.sd.entity.Pager;
import com.jt.sd.entity.User;
import com.jt.sd.service.CommentService;
import com.jt.sd.service.DreamService;
import com.jt.sd.utils.HTMLFilter;

public class DreamController extends BaseController {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5232603227914757966L;
	private DreamService dreamService = new DreamService();
	private CommentService commentService = new CommentService();
	
	public String dreamInput(HttpServletRequest req, HttpServletResponse resp) {
		
		return "dream/dreamInput.jsp";
	}
	
	public String post(HttpServletRequest req, HttpServletResponse resp) {
		String name = req.getParameter("name");
		String content = req.getParameter("content");
		content = HTMLFilter.filter(content);
		Dream dream = new Dream();
		dream.setName(name);
		dream.setContent(content);
		User user = (User) req.getSession().getAttribute("loginUser");
		if(user!=null) {
			dream.setUser(user);
			dreamService.add(dream);
			return redirectPath+"dream?method=list";
		} else {
			return redirectPath+"user?method=loginInput";
		}
	}
	
	public String list(HttpServletRequest request, HttpServletResponse resp) {
		String con = request.getParameter("con");
		if(con==null) con = "";
		Pager<Dream> pages = dreamService.list();
		List<Dream> dreams = pages.getDatas();
		request.setAttribute("dreams",dreams);
		request.setAttribute("pages", pages);
		return "dream/list.jsp";
	}
	
	public String detail(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		Dream dream = dreamService.loadById(Integer.parseInt(id));
		Pager<Comment> pComments = commentService.list(Integer.parseInt(id));
		req.setAttribute("dream", dream);
		req.setAttribute("pComments", pComments);
		return "dream/detail.jsp";
		
	}
	
	public String reply(HttpServletRequest req, HttpServletResponse resp) {
		User user = (User)req.getSession().getAttribute("loginUser");
		if(user==null) {
			return redirectPath+req.getContextPath()+"/user?method=loginInput";
		}
		Comment comment = new Comment();
		String content = req.getParameter("content");
		String d_id = req.getParameter("d_id");
		Dream dream = dreamService.loadById(Integer.parseInt(d_id));
		req.setAttribute("dream", dream);
		comment.setContent(content);
		comment.setUser(user);
		comment.setDream(dream);
		
		commentService.add(comment);
		return redirectPath+"dream?method=detail&id="+d_id;
	}
	
	

}
