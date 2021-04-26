package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.UserEntity;

public interface UserDao {
	
	UserEntity getUser(int uid);
	
	List<UserEntity> getAllUser();
	
	String setUser();

}
