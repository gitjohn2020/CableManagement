package org.demo.cbiz.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {

	public static void main(String[] args) {

		getConnection();

	}
	
 public static Connection getConnection() {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/cable_management?useSSL=false";//&serverTimeZone=UTC";
		String userName = "root";
		String password = "root";
		
		
		try {
			
			System.out.println("Connecting to database.... " + jdbcUrl);
			
			Class.forName("com.mysql.jdbc.Driver"); 
			
			Connection myConn = DriverManager.getConnection(jdbcUrl,userName,password);
			
			System.out.println("Connection Successful !!!");
			return myConn;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
