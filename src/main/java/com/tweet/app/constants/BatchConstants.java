package com.tweet.app.constants;

public class BatchConstants {

	public static final String DOB_FORMAT = "yyyy/MM/dd";
	
	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/tweet";
	public static final String SQL_USER = "root";
	public static final String SQL_PASSWORD = "rootroot";
	
	public static final String GET_ALL_TWEETS = "SELECT message FROM post ";
	public static final String GET_USER_TWEETS = "SELECT message FROM post WHERE email = ? ";
	public static final String SAVE_TWEET = "INSERT INTO post(message,email)values(?,?)";

	public static final String SAVE_USER = "INSERT INTO user (`first_name`, `last_name`, `gender`, `dob`, `email`, `password`)  VALUES (?,?,?,?,?,?)";
	public static final String GET_USER = "SELECT email, password from user where email = ?";
		

}