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
import com.cn.philips.pojo.CcdTestData;
import com.cn.philips.pojo.CcdTestPlan;
import com.cn.philips.pojo.CcdTestPlanNew;
import com.cn.philips.pojo.User;
import com.cn.philips.pojo.UserCCD;
import com.cn.philips.service.DataHandleService;
import com.cn.philips.service.IUserService;
import com.cn.philips.service.UserCCDService;

@Controller
@RequestMapping("/test")
public class TestDataController {
	@Resource
	private UserCCDService userCCDService;
	
	@Resource
	private DataHandleService dataHandleService;
	
	@RequestMapping(value="/getTestResault",method=RequestMethod.POST)
	@ResponseBody
	public List<String> testResault(HttpServletRequest request,HttpServletResponse response, @RequestBody String requestBody) throws Exception{
		String planName = request.getParameter("planName");
		Double threshold = Double.parseDouble(request.getParameter("threshold"));
		JSONObject json = JSONObject.parseObject(requestBody);
		List<String> sdcmNameList = new ArrayList<String>();
		sdcmNameList.add("sdcm1");
		sdcmNameList.add("sdcm2");
		sdcmNameList.add("sdcm3");
		
		List<Integer> sdcmList = new ArrayList<Integer>();
		for (String sdcmTmp: sdcmNameList) {
			Integer sdcm = Integer.parseInt(JSONObject.parseObject(json.get("SDCM").toString()).get(sdcmTmp).toString());
			sdcmList.add(sdcm);
		}
		
		if (planName == "" || threshold == null) {
			throw new Exception("Parameter Error");
		}
		ArrayList<CcdTestData> ccdTestDataList = dataHandleService.GetAllTestData(planName);
		Double maxBri = dataHandleService.GetMaxBri(ccdTestDataList);
		ArrayList<CcdTestData> effectiveTestDataList = dataHandleService.GetEffectiveTestData(planName,ccdTestDataList, threshold, maxBri);
		AvgTestData avgTestData = dataHandleService.GetAvg(planName, ccdTestDataList, threshold);
		Map<String, Double> ellipticMap = dataHandleService.CalculateEllipticVaule(avgTestData);
		
		List<String> sdcmResaultList = new ArrayList<String>();
		for (Integer sdcm: sdcmList) {
			String resault = dataHandleService.CalculatePixelPointRang(avgTestData, effectiveTestDataList, ellipticMap, sdcm);
			sdcmResaultList.add(resault);
		}
		
		return sdcmResaultList;	
	
	}
	
	@RequestMapping(value="/getAvg",method=RequestMethod.POST)
	@ResponseBody
	public AvgTestData getAvgTestData(HttpServletRequest request,HttpServletResponse response, @RequestBody String requestBody) throws Exception{
	
		JSONObject json = JSONObject.parseObject(requestBody);
		String username = JSONObject.parseObject(json.get("user").toString()).get("userName").toString();
		
		String planName = request.getParameter("planName");
		AvgTestData avgTestData = new AvgTestData();
		ArrayList<CcdTestData>  ccdTestDataList = new ArrayList<CcdTestData>();
		Double threshold = Double.parseDouble(request.getParameter("threshold"));
		ccdTestDataList = dataHandleService.GetAllTestData(planName);
		avgTestData = dataHandleService.GetAvg(planName,ccdTestDataList, threshold);
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
	
	@RequestMapping(value="/test",method=RequestMethod.POST)
	@ResponseBody
	public void testTest(HttpServletRequest request,HttpServletResponse response, @RequestBody User user){
		System.out.print("testtest");
		user.getAge();
	
	}
}
