package com.tweet.app.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tweet.app.constants.BatchConstants;
import com.tweet.app.model.User;
import com.tweet.app.util.DbHandler;

public class UserDaoSqlImpl {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public User getUser(String username) throws Exception {
		connection = DbHandler.getConnection();
		User user = new User();
		try {
			preparedStatement = connection.prepareStatement(BatchConstants.GET_USER);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
					String email = resultSet.getString("email");
					String password = resultSet.getString("password");
					user.setEmail(email);
					user.setPassword(password);
			} else {
				throw new Exception();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closedb();
			} catch (SQLException sqlException) {
				throw new RuntimeException("Connection is not closed properly");
			}
		}
		return user;
	}

	public void saveUser(User user) throws Exception {
		connection = DbHandler.getConnection();
		try {
			preparedStatement = connection.prepareStatement(BatchConstants.SAVE_USER);
			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getGender());
			preparedStatement.setDate(4, new Date(user.getDob().getTime()));
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closedb();
			} catch (SQLException sqlException) {
				throw new RuntimeException("Connection is not closed properly");
			}
		}	
	}

	public void closedb() throws SQLException {

		if (resultSet != null) {
			resultSet.close();
		}
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
}