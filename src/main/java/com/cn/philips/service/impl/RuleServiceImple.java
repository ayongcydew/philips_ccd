package com.cn.philips.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.cn.philips.dao.CcdTestPlanMapper;
import com.cn.philips.dao.RulesMapper;
import com.cn.philips.pojo.AvgTestData;
import com.cn.philips.pojo.CcdTestConfig;
import com.cn.philips.pojo.CcdTestData;
import com.cn.philips.pojo.CcdTestPlan;
import com.cn.philips.pojo.Rules;
import com.cn.philips.pojo.RulesExample;
import com.cn.philips.service.DataHandleService;
import com.cn.philips.service.RuleService;

public class RuleServiceImple implements RuleService {

	@Resource
	private DataHandleService dataHandleService;

	@Resource
	private RulesMapper rulesMapper;

	@Override
	public String GetBrightnessUniformity(String planName, ArrayList<CcdTestData> ccdTestDataList) {
		return null;
	}


}