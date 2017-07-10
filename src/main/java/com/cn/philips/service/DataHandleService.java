package com.cn.philips.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import com.cn.philips.pojo.AvgTestData;
import com.cn.philips.pojo.CcdTestConfigT;
import com.cn.philips.pojo.CcdTestData;
import com.cn.philips.pojo.CcdTestPlan;

public interface DataHandleService {
	
	public ArrayList<CcdTestData> GetAllTestData(String planName) throws Exception;
	
	public AvgTestData GetAvg(String planName, ArrayList<CcdTestData> ccdTestDataList);
	
	public ArrayList<CcdTestData> GetEffectiveTestData(String planName, ArrayList<CcdTestData> ccdTestDataList, Double maxBri);
	
	public Double CalculateGVaule(String TypeOfValue, AvgTestData avgTestData);
	
	public Double GetMaxBri(ArrayList<CcdTestData> ccdTestDataList);
	
	public Map<String, Double> CalculateEllipticVaule(AvgTestData avgTestData);
	
	public String CalculatePixelPointRang(AvgTestData avgTestData, ArrayList<CcdTestData> ccdTestDataList, Map<String, Double> gValueMap, Integer step);
	
	public ArrayList<String> GetPlanNameList();
	
	public ArrayList<CcdTestPlan> GetPlanList(Integer start, Integer limit);
	
	public CcdTestConfigT GetCcdTestConfig();
}
