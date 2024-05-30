package com.funfit.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConfig {
	
	public static Connection getDbConnection () {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/funfit", "root", "123456789");
			return con;
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

}
