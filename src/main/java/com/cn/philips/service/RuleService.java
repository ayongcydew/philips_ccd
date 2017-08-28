package com.cn.philips.service;

import java.util.ArrayList;

import com.cn.philips.pojo.UniformityResponse;
import com.cn.philips.pojo.CcdTestConfig;
import com.cn.philips.pojo.CcdTestData;

public interface RuleService {
	
	public UniformityResponse GetUniformity(String planName) throws Exception;

}
