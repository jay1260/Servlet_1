package com.it.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	
	public Connection getConnect() throws Exception {
		String user = "hr";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		System.out.println("로딩 성공");
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		System.out.println("로그인 성공");
		
		return con;
	}
}
