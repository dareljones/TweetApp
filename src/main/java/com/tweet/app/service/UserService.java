package com.tweet.app.service;

import com.tweet.app.model.User;
import com.tweet.app.repo.UserDaoSqlImpl;
import com.tweet.app.util.DateUtil;


public class UserService {

	UserDaoSqlImpl repo = new UserDaoSqlImpl();
	
	public boolean validateUser(String email, String password) throws Exception {
		User existedUser = repo.getUser(email);
		if (existedUser != null) {
			if (existedUser.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
		} else {
			throw new Exception();
		}
	}
	
	public void saveUser(String fname, String lname, String gender, String dob, String email, String pwd) throws Exception {
		User newUser = new User(fname, lname, gender, DateUtil.convertToDate(dob), email, pwd);
		repo.saveUser(newUser);
	}
	
}