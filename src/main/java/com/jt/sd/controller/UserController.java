package com.jt.sd.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jt.sd.entity.Pager;
import com.jt.sd.entity.User;
import com.jt.sd.service.UserService;
import com.jt.sd.utils.RequestUtil;

public class UserController extends BaseController {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService userService = new UserService();
	
	public String loginInput(HttpServletRequest req, HttpServletResponse resp) {
		return "user/loginInput.jsp";
	}
	
	public String login(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		try {
			userService.login(email, password);
			User user = userService.loadByEmail(email);
			req.getSession().setAttribute("loginUser", user);
			return redirectPath+"user?method=home";
		} catch (Exception e) {
			req.setAttribute("msg", e.getMessage());
			return "user/loginInput.jsp";
		}
	}
	
	public String home(HttpServletRequest req, HttpServletResponse resp) {
		User user = (User)req.getSession().getAttribute("loginUser");
		if(user!=null) {
			return "user/home.jsp";
		} else {
			return "user/loginInput.jsp";
		}
	}

	public String registerInput(HttpServletRequest req, HttpServletResponse resp) {
		return "user/registerInput.jsp";
	}
	
	public String register(HttpServletRequest req, HttpServletResponse resp) {
		User u = (User) RequestUtil.setParameters(User.class, req);
		User user = userService.loadByEmail(u.getEmail());
		
		if(user!=null) {
			req.setAttribute("msg", "用户名已存在");
			return "user/registerInput.jsp";
		} else {
			u.setStatus(1);
			u.setType(3);
			userService.registerUser(u);
<<<<<<< HEAD
			req.setAttribute("msg", "注册成功");
=======
>>>>>>> 4113ab57663ce5ce5beef53d284714803e4ca6b1
			return redirectPath+"user?method=loginInput";
		}
	}
	
	public String list(HttpServletRequest req, HttpServletResponse resp) {
		User user = (User)req.getSession().getAttribute("loginUser");
		if(user!=null&&user.getType()==3) {
			Pager<User> pages = userService.list();
			List<User> users = pages.getDatas();
			req.setAttribute("users", users);
			req.setAttribute("pages", pages);
			return "user/list.jsp";
		}
		return redirectPath+"user?method=home";
	}
	
	public String logout(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().invalidate();
		return "user/loginInput.jsp";
	}
	
	public String delete(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		User u = (User) req.getSession().getAttribute("loginUser");
		if(u.getType()==3) {
			userService.delete(Integer.parseInt(id));
			req.setAttribute("msg", "删除成功");
			return "user/list.jsp";
		} else {
			req.setAttribute("msg", "没有权限");
			return "user/list.jsp";
		}
	}
	

}
