/**
 * @author Administrator
 *
 * Feb 26, 2014
 */
package com.jt.sd.dao;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;
import org.apache.tools.ant.types.EnumeratedAttribute;
import org.junit.Test;

import com.jt.sd.utils.JDBCUtil;

public class TestH2 {
	
	@Test
	public void test01() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getH2Connection();
			String sql = "select * from test";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps);
			JDBCUtil.close(con);
			
		}
	}
	
	@Test
	public void test02() {
		SQLExec sqlExec = new SQLExec();   
		//设置数据库参数   
		sqlExec.setDriver("org.h2.Driver");   
		sqlExec.setUrl("jdbc:h2:~/share");  
		sqlExec.setUserid("sa");   
		sqlExec.setPassword("");   
		//要执行的脚本   
		URL url = JDBCUtil.class.getClassLoader().getResource("/sql/share_dream.sql");
		String p = url.getFile();
		System.out.println(p);
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
