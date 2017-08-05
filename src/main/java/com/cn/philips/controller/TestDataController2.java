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
import com.cn.philips.pojo.CcdTestConfigT;
import com.cn.philips.pojo.CcdTestData;
import com.cn.philips.pojo.CcdTestPlan;
import com.cn.philips.pojo.CcdTestPlanNew;
import com.cn.philips.pojo.User;
import com.cn.philips.pojo.UserCCD;
import com.cn.philips.service.DataHandleService;
import com.cn.philips.service.IUserService;
import com.cn.philips.service.UserCCDService;

@Controller
@RequestMapping("/testManage")
public class TestDataController2 {
	@Resource
	private UserCCDService userCCDService;
	
	@Resource
	private DataHandleService dataHandleService;
	
	@RequestMapping(value="/getTestResault",method=RequestMethod.POST)
	@ResponseBody
	public List<String> testResault(HttpServletRequest request,HttpServletResponse response, @RequestBody String requestBody) throws Exception{
		String planName = request.getParameter("planName");
		JSONObject json = JSONObject.parseObject(requestBody);
	
		if (planName == "") {
			throw new Exception("Parameter Error");
		}
		ArrayList<CcdTestData> ccdTestDataList = dataHandleService.GetAllTestData(planName);
		Double maxBri = dataHandleService.GetMaxBri(ccdTestDataList);
		ArrayList<CcdTestData> effectiveTestDataList = dataHandleService.GetEffectiveTestData(planName,ccdTestDataList, maxBri);
		AvgTestData avgTestData = dataHandleService.GetAvg(planName, ccdTestDataList);
		Map<String, Double> ellipticMap = dataHandleService.CalculateEllipticVaule(avgTestData);
		
		CcdTestConfigT ccdTestConfig = dataHandleService.GetCcdTestConfig();
		
		List<String> sdcmResaultList = new ArrayList<String>();
		String resault1 = dataHandleService.CalculatePixelPointRang(avgTestData, effectiveTestDataList, ellipticMap, ccdTestConfig.getSdcm1());
		sdcmResaultList.add(resault1);
		String resault2 = dataHandleService.CalculatePixelPointRang(avgTestData, effectiveTestDataList, ellipticMap, ccdTestConfig.getSdcm2());
		sdcmResaultList.add(resault2);
		String resault3 = dataHandleService.CalculatePixelPointRang(avgTestData, effectiveTestDataList, ellipticMap, ccdTestConfig.getSdcm3());
		sdcmResaultList.add(resault3);
		
		return sdcmResaultList;	
	
	}
	
	@RequestMapping(value="/getAvg",method=RequestMethod.GET)
	@ResponseBody
	public AvgTestData getAvgTestData(HttpServletRequest request,HttpServletResponse response, @RequestBody String requestBody) throws Exception{
	
		String planName = request.getParameter("planName");
		AvgTestData avgTestData = new AvgTestData();
		ArrayList<CcdTestData>  ccdTestDataList = new ArrayList<CcdTestData>();
		ccdTestDataList = dataHandleService.GetAllTestData(planName);
		avgTestData = dataHandleService.GetAvg(planName,ccdTestDataList);
		return avgTestData;	
	
	}
	
	@RequestMapping(value="/getPlanNameList",method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<String> getPlanIdList(HttpServletRequest request,HttpServletResponse response){
		ArrayList<String> planIdList = dataHandleService.GetPlanNameList();
		return planIdList;	
	
	}
	
	@RequestMapping(value="/getPlanList",method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<CcdTestPlanNew> getPlan(HttpServletRequest request,HttpServletResponse response){
		Integer start = Integer.parseInt(request.getParameter("start"));
		Integer limit = Integer.parseInt(request.getParameter("limit"));
		ArrayList<CcdTestPlan> ccdTestPlanList = dataHandleService.GetPlanList(start, limit);
		ArrayList<CcdTestPlanNew> ccdTestPlanListNew = new ArrayList();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");   
		for (CcdTestPlan ccdTestPlan : ccdTestPlanList) {
			CcdTestPlanNew ccdTestPlanNew = new CcdTestPlanNew();
			ccdTestPlanNew.setId(ccdTestPlan.getId());
			ccdTestPlanNew.setPlanName(ccdTestPlan.getPlanName());
			ccdTestPlanNew.setDescription(ccdTestPlan.getDescription());
			ccdTestPlanNew.setPixelX(ccdTestPlan.getPixelX());
			ccdTestPlanNew.setPixelY(ccdTestPlan.getPixelY());
			ccdTestPlanNew.setOperatorName(ccdTestPlan.getOperatorName());
			ccdTestPlanNew.setStartTime(sdf.format(ccdTestPlan.getStartTime()));
			ccdTestPlanListNew.add(ccdTestPlanNew);
		}
		return ccdTestPlanListNew;	
	
	}
	
	@RequestMapping(value="/getTestConfig",method=RequestMethod.GET)
	@ResponseBody
	public CcdTestConfigT getTestConfig(HttpServletRequest request,HttpServletResponse response) throws Exception{
		CcdTestConfigT ccdTestConfig = dataHandleService.GetCcdTestConfig();
		return ccdTestConfig;
	
	}
	
	@RequestMapping(value="/test",method=RequestMethod.POST)
	@ResponseBody
	public void testTest(HttpServletRequest request,HttpServletResponse response, @RequestBody User user){
		System.out.print("testtest");
		user.getAge();
	
	}
}
