package com.cn.philips.service;

import java.util.ArrayList;
import java.util.List;

import com.cn.philips.pojo.UniformityResponse;
import com.cn.philips.pojo.CcdTestConfig;
import com.cn.philips.pojo.CcdTestData;
import com.cn.philips.pojo.CcdTestRule;

public interface RuleService {
	
	public List<CcdTestRule> GetCcdTestRuleList();
	
	public UniformityResponse GetUniformity(String planName) throws Exception;

}
