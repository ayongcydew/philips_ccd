package com.cn.philips.service;

import java.util.ArrayList;

import com.cn.philips.pojo.CcdTestConfig;
import com.cn.philips.pojo.CcdTestData;

public interface RuleService {
	
	public String GetBrightnessUniformity(String planName, ArrayList<CcdTestData> effectiveTestData);

}
