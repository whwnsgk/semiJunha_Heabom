package com.heabom.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	//1. Connetcion 객체 생성 한후 해당 Connection 객체를 반환시켜주는 getConnction 메서드
	
	public static Connection getConnection() {
		// jdbc driver 등록 
		// 붙어먹고자하는 db의 url, 계정명 , 비밀번호를 제시해서 Connection 객체를 생성
		Connection conn = null ; //커넥션 객체 생성을 해야겠지
		
		Properties prop = new Properties(); //MAP 계열 collection key => value
		//읽어들이고자 하는 classes 폴더내에 driver.properties 파일의 파일 경로를 만들어줘야함
		String filepath = JDBCTemplate.class.getResource("/db/driver/driver.properties").getPath();
		//"c:05_server-workspace2/jspProject/webContent/classes/db/driver/driver-properties";
		//클래스파일의 경로를 찾아주는 .class.메서드
		//c:05_server-workspace2/jspProject/webContent/classes/db/driver/driver-properties
		
		
		
		
		
		try {
			prop.load(new FileInputStream(filepath)); // prop 에 경로 값 주기 
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
			try {
				Class.forName(prop.getProperty("driver")); 
				
				
				conn = DriverManager.getConnection(prop.getProperty("url"),
						prop.getProperty("username"),
						prop.getProperty("password")); // "이건 걍 외워;",계정명, 비밀번호
				
				//oracle클래스를 쓰는거기때문에 web-inf 안에 ojdbc6 을 꼭 넣어주도록 하자
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn; 
	
	}
	
	
	
	
	
	
	
	
	
	//2. Connection 객체 전달 받아서 commit 시켜주는 메서드 만들기
	public static void commit(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	
	//2.2 rollback 시켜주는 메서드
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	//3-1 Connection 객체를 전달 받아서 반납시켜주는 close 메서드
	public static void close(Connection conn) {
		try {
			if(conn!= null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//3-2 Statement 객체 전달 받아서 반납시켜주는 close 메서드
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	//3-3 ResultSet 객체 전달 받아서 반납시켜주는 close 메서드 
	
	public static void close(ResultSet rset) {
		try {
			if (rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
