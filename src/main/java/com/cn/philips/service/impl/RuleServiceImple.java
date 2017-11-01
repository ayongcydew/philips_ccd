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
		Integer overFlowColorConditionA = 0;
		Integer overFlowColorConditionB = 0;

		UniformityResponse UniformityResponse = new UniformityResponse();
		UniformityResponse.setPlanName(ccdTestPlan.getPlanName());
		
		if (rule.getIsbriactivated() == 1) {
			
			//for row
			for (int i = 0; i < ccdTestPlan.getPixelX(); i++) {
				for (int j = 1; j < ccdTestPlan.getPixelX(); j++) {

					if (!effectiveTestDataList.contains(ccdTestDataArray[i][j]) ||
							!effectiveTestDataList.contains(ccdTestDataArray[i][j-1])) {						
						continue;
					}
					
					Double deltaBri = Math.abs(ccdTestDataArray[i][j].getBri() - ccdTestDataArray[i][j-1].getBri());
					
					if (deltaBri > rule.getBriconditiona()) {
						overFlowBriConditionA++;
					} else if (deltaBri > rule.getBriconditionb()) {
						overFlowBriConditionB++;
					}
				}
			}
			
			//for line
			for (int j = 0; j < ccdTestPlan.getPixelX(); j++) {
				for (int i = 1; i < ccdTestPlan.getPixelX(); i++) {

					if (!effectiveTestDataList.contains(ccdTestDataArray[j][i]) ||
							!effectiveTestDataList.contains(ccdTestDataArray[j][i-1])) {						
						continue;
					}
					
					Double deltaBri = Math.abs(ccdTestDataArray[j][i].getBri() - ccdTestDataArray[j][i-1].getBri());
					
					if (deltaBri > rule.getBriconditiona()) {
						overFlowBriConditionA++;
					} else if (deltaBri > rule.getBriconditionb()) {
						overFlowBriConditionB++;
					}
				}
			}
						
			UniformityResponse.setBriConditionAResault(1.0 - Double.valueOf(0.5 * overFlowBriConditionA)/effectiveTestDataList.size());
			UniformityResponse.setBriConditionBResault(1.0 - Double.valueOf(0.5 * overFlowBriConditionB)/effectiveTestDataList.size());
		}
		if (rule.getIscoloractivated() == 1) {
			
			for (int i = 0; i < ccdTestPlan.getPixelX(); i++) {
				for (int j = 0; j < ccdTestPlan.getPixelX(); j++) {

					if (!effectiveTestDataList.contains(ccdTestDataArray[i][j])) {
						continue;
					}
										
					Double deltaUV = Math.sqrt(Math.pow((ccdTestDataArray[i][j].getU() - avgTestData.getAvgU()), 2) 
							+ Math.pow((ccdTestDataArray[i][j].getV() - avgTestData.getAvgV()), 2));
//					
//					if (Math.abs(deltaUV - avgTestData.getAvgDeltaUV()) > rule.getColorconditiona()) {
//						overFlowColorConditionA++;
//					} else if (Math.abs(deltaUV - avgTestData.getAvgDeltaUV()) > rule.getColorconditionb()) {
//						overFlowColorConditionB++;
//					}
								
					if (deltaUV > rule.getColorconditiona()) {
						overFlowColorConditionA++;
					} else if (deltaUV > rule.getColorconditionb()) {
						overFlowColorConditionB++;
					}
				}
			}
			UniformityResponse.setColorConditionAResault(1.0 - Double.valueOf(overFlowColorConditionA)/effectiveTestDataList.size());
			UniformityResponse.setColorConditionBResault(1.0 - Double.valueOf(overFlowColorConditionB)/effectiveTestDataList.size());
		}
		return UniformityResponse;
	}

	@Override
	public List<CcdTestRule> GetCcdTestRuleList() {
		CcdTestRuleExample ccdTestRuleExample = new CcdTestRuleExample();
		List<CcdTestRule> ccdTestRuleList = ccdTestRuleMapper.selectByExample(ccdTestRuleExample);
		return ccdTestRuleList;
	}

}