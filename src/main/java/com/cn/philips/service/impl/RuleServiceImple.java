package com.cn.philips.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.philips.dao.CcdTestPlanMapper;
import com.cn.philips.dao.CcdTestRuleMapper;
import com.cn.philips.pojo.AvgTestData;
import com.cn.philips.pojo.UniformityResponse;
import com.cn.philips.pojo.CcdTestConfig;
import com.cn.philips.pojo.CcdTestData;
import com.cn.philips.pojo.CcdTestPlan;
import com.cn.philips.pojo.CcdTestRule;
import com.cn.philips.pojo.CcdTestRuleExample;
import com.cn.philips.service.DataHandleService;
import com.cn.philips.service.RuleService;

@Service("ruleService")
public class RuleServiceImple implements RuleService {

	@Resource
	private DataHandleService dataHandleService;

	@Resource
	private CcdTestRuleMapper ccdTestRuleMapper;

	@Override
	public UniformityResponse GetUniformity(String planName) throws Exception {

		ArrayList<CcdTestData> ccdTestDataList = dataHandleService.GetAllTestData(planName);
		AvgTestData avgTestData = dataHandleService.GetAvg(planName, ccdTestDataList);
		Double maxBri = dataHandleService.GetMaxBri(ccdTestDataList);
		CcdTestData[][] ccdTestDataArray = dataHandleService.convertCcdTesgDataListToArray(planName, ccdTestDataList);
		ArrayList<CcdTestData> effectiveTestDataList = dataHandleService.GetEffectiveTestData(planName, ccdTestDataList,
				maxBri);
		CcdTestPlan ccdTestPlan = dataHandleService.GetCcdTestPlanByName(planName);
		CcdTestRuleExample rulesExample = new CcdTestRuleExample();
		CcdTestRuleExample.Criteria criteria = rulesExample.createCriteria();
		criteria.andPlanidEqualTo(ccdTestPlan.getId());
		List<CcdTestRule> ruleList = ccdTestRuleMapper.selectByExample(rulesExample);
		CcdTestRule rule = ruleList.get(0);
		Integer overFlowBriConditionA = 0;
		Integer overFlowBriConditionB = 0;

		if (rule.getIsbriactivated() == 1) {
			for (int i = 0; i < ccdTestPlan.getPixelX(); i++) {
				for (int j = 0; j < ccdTestPlan.getPixelX(); j++) {

					if (!effectiveTestDataList.contains(ccdTestDataArray[i][j])) {
						continue;
					}
					if (Math.abs(ccdTestDataArray[i][j].getBri() - avgTestData.getAvgBri()) > rule.getBriconditiona()) {
						overFlowBriConditionA++;
					} else if (Math.abs(ccdTestDataArray[i][j].getBri() - avgTestData.getAvgBri()) > rule.getBriconditionb()) {
						overFlowBriConditionB++;
					}
				}
			}
		}
		UniformityResponse brightnessUniformityResponse = new UniformityResponse();
		brightnessUniformityResponse.setPlanName(ccdTestPlan.getPlanName());
		brightnessUniformityResponse.setBriConditionAResault(1.0 - Double.valueOf(overFlowBriConditionA)/effectiveTestDataList.size());
		brightnessUniformityResponse.setBriConditionBResault(1.0 - Double.valueOf(overFlowBriConditionB)/effectiveTestDataList.size());
		return brightnessUniformityResponse;
	}

}