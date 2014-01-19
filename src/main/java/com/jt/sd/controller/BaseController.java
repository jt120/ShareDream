package com.jt.sd.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseController
 */
public class BaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String redirectPath = "redirect:";
       
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		try {
			Method m = this.getClass().getMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			String path = (String) m.invoke(this, request,response);
			if(path.startsWith(redirectPath)) {
				path = path.substring(redirectPath.length());
				response.sendRedirect(path);
			} else {
				request.getRequestDispatcher("/WEB-INF/"+path).forward(request, response);
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}

}
