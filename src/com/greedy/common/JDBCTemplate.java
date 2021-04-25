package com.greedy.common;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

	// Connection
	public static Connection getConnection() {
		Connection con = null;
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader("config/driver.properties"));
			
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, prop);
			
			con.setAutoCommit(false); // 자동 커밋 안함
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return con;
		
	}
	
	// Close
	public static void close(Connection con) {
		
		try {
			if(con !=null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ResultSet
	public static void close(ResultSet rset) {
		
		try {
			if(rset !=null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ResultSet, Statement 
	public static void close(Statement stmt) {
		
		try {
			if(stmt !=null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* 수동 Commit 이후 */
	// commit
	public static void commit(Connection con) {
		
		try {
			
			if(con != null && !con.isClosed()) {
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// rollback
	public static void rollback(Connection con) {
		
		try {
			
			if(con != null && !con.isClosed()) {
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}




}
