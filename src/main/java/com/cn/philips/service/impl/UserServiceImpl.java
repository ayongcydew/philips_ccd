package com.cn.philips.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.philips.dao.UserMapper;
import com.cn.philips.pojo.User;
import com.cn.philips.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private UserMapper userMapper;
//	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userMapper.selectByPrimaryKey(userId);
	}

}
