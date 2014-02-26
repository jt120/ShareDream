/**
 * @author Administrator
 *
 * Feb 26, 2014
 */
package com.jt.sd.controller;

import java.io.File;
import java.net.URL;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;
import org.apache.tools.ant.types.EnumeratedAttribute;

public class SqlInit extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		String path = config.getInitParameter("sql");
		SQLExec sqlExec = new SQLExec();   
		//设置数据库参数   
		sqlExec.setDriver("org.h2.Driver");   
		sqlExec.setUrl("jdbc:h2:~/share");  
		sqlExec.setUserid("sa");   
		sqlExec.setPassword("");   
		//要执行的脚本   
		//sql/share_dream.sql
		URL url = SqlInit.class.getClassLoader().getResource(path);
		sqlExec.setSrc(new File(url.getFile()));  
		//有出错的语句该如何处理   
		sqlExec.setOnerror((SQLExec.OnError)(EnumeratedAttribute.getInstance(   
		SQLExec.OnError.class, "abort")));  
		sqlExec.setPrint(true); //设置是否输出  
		//输出到文件 sql.out 中；不设置该属性，默认输出到控制台   
//		sqlExec.setOutput(new File("src/sql.out"));   
		sqlExec.setProject(new Project()); // 要指定这个属性，不然会出错   
		sqlExec.execute();   
	}

}
