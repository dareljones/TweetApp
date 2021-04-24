package com.tweet.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.tweet.app.constants.BatchConstants;


public class DbHandler {

	public static Connection getConnection() {
		
		Connection connection = null;
		try {
			String driver = BatchConstants.JDBC_DRIVER;
			String url = BatchConstants.URL;
			String username = BatchConstants.SQL_USER;
			String password = BatchConstants.SQL_PASSWORD;
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException classNotFoundException) {
			
			throw new RuntimeException("Class Not Found Exception caught");
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new RuntimeException("SQL Exception caught");
		}
		return connection;
	}
}