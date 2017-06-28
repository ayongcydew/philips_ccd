package com.cn.test.philips;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.math.*;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.cn.philips.pojo.AvgTestData;
import com.cn.philips.pojo.CcdTestData;
import com.cn.philips.service.DataHandleService;
import com.cn.philips.service.ImportTestDataService;;

@RunWith(SpringJUnit4ClassRunner.class)	
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestFileImport {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	
	@Resource
	private ImportTestDataService importTestDataService;
	
	@Resource
	private DataHandleService dataHandleService;
	
	@Test
	public void importCcdTestData() throws Exception {
//		String LocX = "C:\\LocX.txt";
//		String LocX = "C:\\LocX1.txt";
//		String LocY = "C:\\LocY.txt";
		String planName = "testPlan2";
		String description = "UnitTest2";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date startTime = sdf.parse("1990-2-2");
		String operatorName = "tester2";
		String Bri = "C:\\20170120\\L.txt";
		String X = "C:\\20170120\\x.txt";
		String Y = "C:\\20170120\\y.txt";
		String U = "C:\\20170120\\u.txt";
		String V = "C:\\20170120\\v.txt";
		importTestDataService.InsertTestData(planName, description, startTime, operatorName, Bri, X, Y, U, V);;
	}
	
	@Test
	public void testGValue() throws Exception {
		
		AvgTestData avgTestData = new AvgTestData();
		ArrayList<CcdTestData>  ccdTestDataList = new ArrayList<CcdTestData>();
		
		Double threshold = 0.3;
		String planName = "999";
		Integer step = 3;
		ccdTestDataList = dataHandleService.GetAllTestData(planName);
		avgTestData = dataHandleService.GetAvg(planName, ccdTestDataList, threshold);
		Map<String, Double> ellipticMap = dataHandleService.CalculateEllipticVaule(avgTestData);
		
		System.out.println("test");
	}
	
	
	@Test
	public void testGetAvgValue() throws Exception {
		
		AvgTestData avgTestData = new AvgTestData();
		ArrayList<CcdTestData>  ccdTestDataList = new ArrayList<CcdTestData>();
		ArrayList<CcdTestData> effectiveTestDataList = new ArrayList<CcdTestData>();
//		CcdTestData ccdTestData = new CcdTestData();
//		ccdTestData.setX(0.4572763);
//		ccdTestData.setY(0.3915107);
		Double threshold = 0.3;
		String planName = "999";
		Integer step = 7;		
		ccdTestDataList = dataHandleService.GetAllTestData(planName);
		Double maxBri = dataHandleService.GetMaxBri(ccdTestDataList);
		effectiveTestDataList = dataHandleService.GetEffectiveTestData(planName, ccdTestDataList, threshold, maxBri);
		avgTestData = dataHandleService.GetAvg(planName, ccdTestDataList, threshold);
		Map<String, Double> ellipticMap = dataHandleService.CalculateEllipticVaule(avgTestData);
		String xxx = dataHandleService.CalculatePixelPointRang(avgTestData, effectiveTestDataList, ellipticMap, step);
		System.out.println(xxx);
	}
	
	@Test
	public void test5() {
		List<Integer> testtest = new ArrayList<Integer>();
		testtest.add(1);
		testtest.add(2);
		testtest.add(3);
		testtest.add(4);
		testtest.add(5);
		testtest.add(6);
		testtest.add(7);
		testtest.add(8);
		testtest.add(9);
		testtest.add(10);
		List<Integer> test1 = testtest.subList(0, 1);
		System.out.println("test");
	}
	
}
