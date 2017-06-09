package com.cn.philips.service;

import java.util.List;

import com.cn.philips.pojo.UserCCD;

public interface UserCCDService {

	public List<UserCCD> getAllUsers();
	
	public UserCCD getUserById(int userId);
	
	public List<UserCCD> getUserByName(String userName);
}
