package com.tweet.app.service;

import java.util.List;

import com.tweet.app.model.Post;
import com.tweet.app.repo.TweetDaoSqlImpl;

public class TweetService {

	TweetDaoSqlImpl repo = new TweetDaoSqlImpl();
	
	public void saveTweet(String message, String username) throws Exception { 
		repo.savePost(message, username);
	}
	
	public List<Post> getUsertweets(String username) throws Exception{
		return repo.getPostsByUser(username);
	}
	
	public List<Post> getAlltweets(){
		return repo.getPosts();
	}
	
}