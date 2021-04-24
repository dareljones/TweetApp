CREATE DATABASE tweet;

USE tweet;

CREATE TABLE user(
first_name varchar(60) not null,
last_name varchar(60) ,
gender varchar(60) not null,
dob date null,
email varchar(60),
password varchar(60) not null,
primary key(email));

CREATE TABLE post(
id int auto_increment,
message varchar(256) not null,
email varchar(60),
date_of_post timestamp DEFAULT CURRENT_TIMESTAMP,
primary key(id,email),
constraint user_tweet_fkey foreign key (email)
references user (email) on delete cascade );


INSERT INTO user  (`first_name`, `last_name`, `gender`, `dob`, `email`, `password`)
 VALUES ('abc', 'abc', 'Male', '1999-03-19', 'abc@gmail.com', '123456');

INSERT INTO user  (`first_name`, `last_name`, `gender`, `dob`, `email`, `password`)
 VALUES ('xyz', 'xyz', 'Male', '1999-03-19', 'xyz@gmail.com', '123456');


 INSERT INTO post(message,email)values('Hello All !!','abc@gmail.com');

 INSERT INTO post(message,email)values('Welcome...','xyz@gmail.com');
