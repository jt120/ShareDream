package com.jt.sd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jt.sd.entity.User;
import com.jt.sd.service.UserService;
import com.jt.sd.utils.RequestUtil;

public class LoginController extends BaseController {
	
	private UserService userService = new UserService();
	
	public String loginInput(HttpServletRequest req, HttpServletResponse resp) {
		return "login/loginInput.jsp";
	}
	
	public String login(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		req.setAttribute("email", email);
		try {
			userService.login(email, password);
			User user = userService.loadByEmail(email);
			req.getSession().setAttribute("loginUser", user);
			return redirectPath+"user?method=home";
		} catch (Exception e) {
			req.setAttribute("msg", e.getMessage());
			return "login/loginInput.jsp";
		}
	}
	public String registerInput(HttpServletRequest req, HttpServletResponse resp) {
		return "login/registerInput.jsp";
	}
	
	public String register(HttpServletRequest req, HttpServletResponse resp) {
		User u = (User) RequestUtil.setParameters(User.class, req);
		User user = userService.loadByEmail(u.getEmail());
		req.setAttribute("email", u.getEmail());
		if(user!=null) {
			req.setAttribute("msg", "用户名已存在");
			return "login/registerInput.jsp";
		} else {
			u.setStatus(1);
			u.setType(3);
			userService.registerUser(u);
			req.setAttribute("msg", "注册成功");
			return redirectPath+"login?method=loginInput";
		}
	}
}
