package com.jt.sd.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

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
	
	
	
	public String home(HttpServletRequest req, HttpServletResponse resp) {
		User user = (User)req.getSession().getAttribute("loginUser");
		if(user!=null) {
			return "user/home.jsp";
		} else {
			return "user/loginInput.jsp";
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
		return "login/loginInput.jsp";
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
	
	public String update(HttpServletRequest req, HttpServletResponse resp) {
		boolean isMutilpart = ServletFileUpload.isMultipartContent(req);
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			if(isMutilpart) {
				String upload = getServletContext().getInitParameter("upload");
				String path = getServletContext().getRealPath(upload);
				ServletFileUpload servletFileUpload = new ServletFileUpload();
				FileItemIterator fileItemIterator = servletFileUpload.getItemIterator(req);
				while(fileItemIterator.hasNext()) {
					FileItemStream fileItemStream = fileItemIterator.next();
					is = fileItemStream.openStream();
					if(fileItemStream.isFormField()) {
						System.out.println(fileItemStream.getFieldName());
						System.out.println(Streams.asString(is));
					} else {
						String originName = fileItemStream.getName();
						String name = UUID.randomUUID().toString();
						path = path + "\\" + name;
						path = path.replace("\\", "\\\\");
						File file = new File(path);
						fos = new FileOutputStream(file);
						int len = -1;
						byte[] buff = new byte[1024];
						while((len=is.read(buff))!=-1) {
							fos.write(buff, 0, len);
						}
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos!=null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(is!=null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return redirectPath+"user?method=home";
	}
}
