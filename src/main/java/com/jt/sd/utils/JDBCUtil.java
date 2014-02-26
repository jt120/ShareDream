package com.jt.sd.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	
	private static String username = "root";
	private static String password = "root";
	private static String database = "share_dream";
	
	public static Connection getMysqlConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/"+database+"?zeroDateTimeBehavior=convertToNull";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getConnection() {
		Connection conn= null;
		String url = "jdbc:h2:~/test";
		try {
			Class.forName("org.h2.Driver");
	        conn = DriverManager.
	            getConnection(url, "sa", "");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection con) {
		try {
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement ps) {
		try {
			if(ps!=null) ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs!=null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
