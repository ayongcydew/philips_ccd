package com.cn.philips.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cn.philips.pojo.AvgTestData;
import com.cn.philips.pojo.CcdTestConfig;
import com.cn.philips.pojo.CcdTestConfigResponse;
import com.cn.philips.pojo.CcdTestData;
import com.cn.philips.pojo.CcdTestPlan;
import com.cn.philips.pojo.CcdTestPlanNew;
import com.cn.philips.pojo.CcdTestResault;
import com.cn.philips.pojo.CcdTestRule;
import com.cn.philips.pojo.CcdTestRuleResponse;
import com.cn.philips.pojo.UniformityResponse;
import com.cn.philips.pojo.User;
import com.cn.philips.pojo.UserCCD;
import com.cn.philips.service.DataHandleService;
import com.cn.philips.service.IUserService;
import com.cn.philips.service.RuleService;
import com.cn.philips.service.UserCCDService;

@Controller
@RequestMapping("/testManage")
public class TestDataController {
	@Resource
	private UserCCDService userCCDService;
	
	@Resource
	private DataHandleService dataHandleService;
	
	@Resource
	private RuleService ruleService;
	
	@RequestMapping(value="/getTestResault",method=RequestMethod.GET)
	@ResponseBody
	public CcdTestResault  testResault(HttpServletRequest request,HttpServletResponse response, @RequestBody String requestBody) throws Exception{
		String planName = request.getParameter("planName");
		// POST method will use the following part
//		JSONObject json = JSONObject.parseObject(requestBody);
	
		if (planName == "") { throw new Exception("Parameter Error");}
		
		CcdTestResault ccdTestResault =  dataHandleService.GetTestResault(planName);
	
		return ccdTestResault;	
	
	}
	
//	@RequestMapping(value="/getAvg",method=RequestMethod.GET)
//	@ResponseBody
//	public AvgTestData getAvgTestData(HttpServletRequest request,HttpServletResponse response, @RequestBody String requestBody) throws Exception{
//	
//		String planName = request.getParameter("planName");
//		if (planName == "") { throw new Exception("Parameter Error");}
//		AvgTestData avgTestData = new AvgTestData();
//		ArrayList<CcdTestData>  ccdTestDataList = new ArrayList<CcdTestData>();
//		ccdTestDataList = dataHandleService.GetAllTestData(planName);
//		avgTestData = dataHandleService.GetAvg(planName,ccdTestDataList);
//		return avgTestData;	
//	
//	}
	
	@RequestMapping(value="/getPlanNameList",method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<String> getPlanIdList(HttpServletRequest request,HttpServletResponse response){
		ArrayList<String> planIdList = dataHandleService.GetPlanNameList();
		return planIdList;	
	
	}
	
	@RequestMapping(value="/getPlanList",method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<CcdTestPlanNew> getPlanList(HttpServletRequest request,HttpServletResponse response){
		Integer start = Integer.parseInt(request.getParameter("start"));
		Integer limit = Integer.parseInt(request.getParameter("limit"));
		ArrayList<CcdTestPlanNew> ccdTestPlanListNew = dataHandleService.GetPlanList(start, limit);
		
		return ccdTestPlanListNew;	
	
	}
	
	@RequestMapping(value="/getTestConfigList",method=RequestMethod.GET)
	@ResponseBody
	public List<CcdTestConfigResponse> getTestConfig(HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<CcdTestConfigResponse> ccdTestConfigList = dataHandleService.GetCcdTestConfigList();
		return ccdTestConfigList;
	
	}
	
	@RequestMapping(value="/test",method=RequestMethod.POST)
	@ResponseBody
	public void testTest(HttpServletRequest request,HttpServletResponse response, @RequestBody User user){
		System.out.print("testtest");
		user.getAge();
	
	}
	
	@RequestMapping(value="/getTestRuleList",method=RequestMethod.GET)
	@ResponseBody
	public List<CcdTestRuleResponse> getTestRule(HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<CcdTestRule> ccdTestRuleList = ruleService.GetCcdTestRuleList();
		List<CcdTestRuleResponse> ccdTestRuleReponseList = new ArrayList<CcdTestRuleResponse>();
		for (CcdTestRule ccdTestRule: ccdTestRuleList) {
			CcdTestRuleResponse ccdTestRuleResponse = new CcdTestRuleResponse();
			ccdTestRuleResponse.setId(ccdTestRule.getId());
			ccdTestRuleResponse.setPlanname(dataHandleService.GetCcdTestPlanById(ccdTestRule.getPlanid()).getPlanName());
			ccdTestRuleResponse.setPlanid(ccdTestRule.getPlanid());
			ccdTestRuleResponse.setIsbriactivated(ccdTestRule.getIsbriactivated());
			ccdTestRuleResponse.setBriconditiona(ccdTestRule.getBriconditiona());
			ccdTestRuleResponse.setBriconditionb(ccdTestRule.getBriconditionb());
			ccdTestRuleResponse.setIscoloractivated(ccdTestRule.getIscoloractivated());
			ccdTestRuleResponse.setColorconditiona(ccdTestRule.getColorconditiona());
			ccdTestRuleResponse.setColorconditionb(ccdTestRule.getColorconditionb());
			ccdTestRuleResponse.setId(ccdTestRule.getId());
			ccdTestRuleReponseList.add(ccdTestRuleResponse);
		}
		return ccdTestRuleReponseList;
	}
	
	@RequestMapping(value="/getRuleResault",method=RequestMethod.GET)
	@ResponseBody
	public UniformityResponse  ruleTestResault(HttpServletRequest request,HttpServletResponse response, @RequestBody String requestBody) throws Exception{
		String planName = request.getParameter("planName");
	
		if (planName == "") { throw new Exception("Parameter Error");}
		
		UniformityResponse uniformityResponse =  ruleService.GetUniformity(planName);
	
		return uniformityResponse;	
	
	}
	
//	@RequestMapping(value="/deleteTestData",method=RequestMethod.GET)
//	@ResponseBody
//	public String  deleteTestData(HttpServletRequest request,HttpServletResponse response, @RequestBody String requestBody) throws Exception{
//		String planName = request.getParameter("planName");
//	
//		if (planName == "") { throw new Exception("Parameter Error");}
//		
//		dataHandleService.deleteTestData("planName");
//	
//		return "success";
//	}
}
