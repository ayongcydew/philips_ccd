package com.cn.philips.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.philips.dao.UserCCDMapper;
import com.cn.philips.pojo.UserCCD;
import com.cn.philips.pojo.UserCCDExample;
import com.cn.philips.service.UserCCDService;

@Service("userCCDService")
public class UserCCDServiceImpl implements UserCCDService {
	@Resource
	private UserCCDMapper userCCDMapper;
	
	@Override
	public UserCCD getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userCCDMapper.selectByPrimaryKey(userId);
	}
	@Override
	public List<UserCCD> getUserByName(String userName) {
		UserCCDExample userCCDExample = new UserCCDExample();
		UserCCDExample.Criteria criteria = userCCDExample.createCriteria();
		criteria.andUserNameEqualTo(userName);
		criteria.andAgeEqualTo(24);
		// TODO Auto-generated method stub
		return  this.userCCDMapper.selectByExample(userCCDExample);
	}
	@Override
	public List<UserCCD> getAllUsers() {
		UserCCDExample userCCDExample = new UserCCDExample();
		UserCCDExample.Criteria criteria = userCCDExample.createCriteria();
		criteria.andIdIsNotNull();
		// TODO Auto-generated method stub
		return  this.userCCDMapper.selectByExample(userCCDExample);
	}

}
