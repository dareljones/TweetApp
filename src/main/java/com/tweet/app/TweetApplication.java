package com.tweet.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.tweet.app.constants.BatchConstants;
import com.tweet.app.model.Post;
import com.tweet.app.service.TweetService;
import com.tweet.app.service.UserService;

public class TweetApplication 
{
	public static void main(String[] args) {

		UserService userService = new UserService();
		TweetService tweetService = new TweetService();
		boolean islogin = false;
		boolean isexit = true;
		String username = null;

		while (isexit) {
			System.out.println("Select Choice :  ");
			System.out.println("1. Login");
			System.out.println("2. SignUp");
			System.out.println("3. Post a tweet");
			System.out.println("4. Show My Tweets");
			System.out.println("5. Show All Tweets");
			System.out.println("6. Logout");
			System.out.println("Press any other key to terminate TweetApp...");
			BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
			String choice;
			try {
				choice = sc.readLine().trim();
				switch (choice) {
				case "1": {
					if (islogin) {
						System.err.println("User already Logged in...");
					} else if (!islogin) {
						System.out.println("Enter email");
						String email = sc.readLine().trim();
						System.out.println("Enter password");
						String password = sc.readLine();
						try {
							if (userService.validateUser(email, password)) {
								username = email;
								islogin = true;
								System.out.println("login successfull");
							} else {
								System.err.println("incorrect credentials");
							}
						} catch (Exception e) {
							System.err.println("User not found...! Please signUp before logging in....");
						}
					}
					break;
				}

				case "2": {
					if (!islogin) {
						System.out.println("New User Registration form...");
						System.out.println("Enter firstname");
						String fname = sc.readLine().trim();
						System.out.println("Enter lastname");
						String lname = sc.readLine().trim();
						System.out.println("Enter gender (Male/Female)");
						String gender = sc.readLine().trim();
						System.out.println("Enter DateOfBirth " + BatchConstants.DOB_FORMAT);
						String dob = sc.readLine().trim();
						System.out.println("Enter email");
						String email = sc.readLine().trim();
						System.out.println("Enter password");
						String pwd = sc.readLine();
						try {
							userService.saveUser(fname, lname, gender, dob, email, pwd);
							System.out.println("User details Saved Successfully");
						} catch (Exception e) {
							System.err.println("email already exists.. select choice for login");
						}
					} else if (islogin) {
						System.err.println("user already logged in...");
					}
					break;
				}
				case "3": {
					if (!islogin) {
						System.err.println("Please login first to post a tweet");
					} else if (islogin) {
						System.out.println("Enter tweet message...!");
						try {
							String tweetMessage = sc.readLine().trim();
							tweetService.saveTweet(tweetMessage, username);
							System.out.println("Message saved successfully.....!");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					break;
				}

				case "4": {
					if (!islogin) {
						System.err.println("Please login first to get your Tweets");
					} else if (islogin) {
						try {
							List<Post> userTweets = tweetService.getUsertweets(username);
							System.out.println("Your tweets are : ");
							userTweets.forEach(tweet -> {
								System.out.println(tweet.getTweet());
							});
						} catch (Exception e) {
							System.err.println("No tweets found under " + username + "....!");
						}
					}
					break;
				}

				case "5": {
					List<Post> userTweets = tweetService.getAlltweets();
					System.out.println(" Tweets are : ");
					userTweets.forEach(tweet -> {
						System.out.println(tweet.getTweet());
					});
					break;
				}

				case "6": {
					if (!islogin) {
						System.err.println("Please login first...");
					} else if (islogin) {
						username = null;
						islogin = false;
						System.out.println("Logged out successfully");
					}
					break;
				}
				
				default: {
					isexit = false;
					sc.close();
					break;
				}
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
