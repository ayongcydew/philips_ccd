package com.cn.philips.service.impl;

import java.util.List;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import javax.annotation.Resource;

import java.io.LineNumberReader;

import org.springframework.stereotype.Service;

import com.cn.philips.dao.CcdTestDataMapper;
import com.cn.philips.dao.CcdTestPlanMapper;
import com.cn.philips.dao.CcdTestRuleMapper;
import com.cn.philips.dao.CcdTestDataMapper;
import com.cn.philips.dao.UserCCDMapper;
import com.cn.philips.pojo.CcdTestData;
import com.cn.philips.pojo.CcdTestDataExample;
import com.cn.philips.pojo.CcdTestPlan;
import com.cn.philips.pojo.CcdTestPlanExample;
import com.cn.philips.pojo.CcdTestRule;
import com.cn.philips.service.DataHandleService;
import com.cn.philips.service.ImportTestDataService;


@Service("importTestDataService")
public class ImportTestDataServiceImpl implements ImportTestDataService {

	@Resource
	private CcdTestDataMapper ccdTestDataMapper;
	
	@Resource
	private CcdTestPlanMapper ccdTestPlanMapper;
	
	@Resource
	private CcdTestRuleMapper ccdTestRuleMapper;
	
	@Resource
	private DataHandleService dataHandleService;
	
	@Override
	public void InsertTestData(String planName, String description, Date startTime, String operatorName, String briPath, 
			String xPath,String yPath,String uPath,String vPath) throws Exception {
		if (planName.equals(null)) {
			throw new Exception("please input the planName");	
		}
		
		ArrayList<ArrayList<Double>>  arrayTxtListBriPath = new ArrayList();
		ArrayList<ArrayList<Double>>  arrayTxtListXPath = new ArrayList();
		ArrayList<ArrayList<Double>>  arrayTxtListYPath = new ArrayList();
		ArrayList<ArrayList<Double>>  arrayTxtListUPath = new ArrayList();
		ArrayList<ArrayList<Double>>  arrayTxtListVPath = new ArrayList();
		if (briPath != null) {arrayTxtListBriPath = ImportFromTxtFile(briPath);};
		if (xPath != null) {arrayTxtListXPath = ImportFromTxtFile(xPath);};
		if (yPath != null) {arrayTxtListYPath = ImportFromTxtFile(yPath);};
		if (uPath != null) {arrayTxtListUPath = ImportFromTxtFile(uPath);};
		if (vPath != null) {arrayTxtListVPath = ImportFromTxtFile(vPath);};
		
		Integer file_rows = arrayTxtListXPath.size();
		if (file_rows == 0) throw new Exception("文件没有数据");
		
		Integer file_columns = arrayTxtListXPath.get(1).size();
		if (file_columns == 0) throw new Exception("文件没有数据");
	
		Integer start_rows = 0;
		
		
		ArrayList<CcdTestData> testDataDetailList = new ArrayList<CcdTestData>();
		
		CcdTestPlan ccdTestPlan = dataHandleService.GetCcdTestPlanByName(planName);
		if (ccdTestPlan != null) {
			start_rows = ccdTestPlan.getPixelX();
			CcdTestPlan ccdTestPlanNew = new CcdTestPlan();
			ccdTestPlanNew.setPixelX(start_rows + file_rows);
			CcdTestPlanExample ccdTestPlanExample = new CcdTestPlanExample();
			CcdTestPlanExample.Criteria criteria = ccdTestPlanExample.createCriteria();
			criteria.andPlanNameEqualTo(planName);
			this.ccdTestPlanMapper.updateByExampleSelective(ccdTestPlanNew, ccdTestPlanExample);
		} else {
			CcdTestPlan ccdTestPlanNew = new CcdTestPlan();
			ccdTestPlanNew.setPlanName(planName);
			ccdTestPlanNew.setDescription(description);
			ccdTestPlanNew.setPixelX(file_rows);
			ccdTestPlanNew.setPixelY(file_columns);
			ccdTestPlanNew.setStartTime(startTime);
			ccdTestPlanNew.setOperatorName(operatorName);
			this.ccdTestPlanMapper.insert(ccdTestPlanNew);
			
			CcdTestPlan ccdTestPlanUpdated = dataHandleService.GetCcdTestPlanByName(planName);			
			CcdTestRule ccdTestRule = new CcdTestRule();
			ccdTestRule.setPlanid(ccdTestPlanUpdated.getId());
			this.ccdTestRuleMapper.insert(ccdTestRule);		
		}
		
		try {

			for (int i = 0 ; i < file_rows; i ++) {
				for (int j = 0; j < file_columns; j++) {
					CcdTestData testDataDetail = new CcdTestData();

					// TODO 要考虑下标溢出的情况，和没有数据的情况，以后再考虑
					testDataDetail.setPlanName(planName);
					testDataDetail.setLocx(start_rows + i);
					testDataDetail.setLocy(j);
					testDataDetail.setBri(arrayTxtListBriPath.get(i).get(j) != null? arrayTxtListBriPath.get(i).get(j):new Double(0.00));
					testDataDetail.setX(arrayTxtListXPath.get(i).get(j) != null? arrayTxtListXPath.get(i).get(j):new Double(0.00));
					testDataDetail.setY(arrayTxtListYPath.get(i).get(j) != null? arrayTxtListYPath.get(i).get(j):new Double(0.00));
					testDataDetail.setU(arrayTxtListUPath.get(i).get(j) != null? arrayTxtListUPath.get(i).get(j):new Double(0.00));
					testDataDetail.setV(arrayTxtListVPath.get(i).get(j) != null? arrayTxtListVPath.get(i).get(j):new Double(0.00));
					
					testDataDetailList.add(testDataDetail);
				}
			}
								
		} catch (Exception e) {
			System.out.println("参数错误");
			
			e.printStackTrace();
		}
		
		for (CcdTestData testDataDetail : testDataDetailList) {
			this.ccdTestDataMapper.insert(testDataDetail);
		}	

	}
	
	private ArrayList<ArrayList<Double>>  ImportFromTxtFile(String txtFilePath) {
		ArrayList<ArrayList<Double>>  arrayTxtList = new ArrayList();
		try {
			String encoding = "UTF-8";
			File file = new File(txtFilePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				Integer lineNo = 0;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (lineNo >= 8) {
						String[] splitedDataFromLine = lineTxt.split("\t");						
						ArrayList<String> splitedDataArrayList = new ArrayList<String>();				
						Collections.addAll(splitedDataArrayList, splitedDataFromLine);
						
						ArrayList<Double> splitedDataIntList = new ArrayList<Double>();	
						for(int i = 0; i < splitedDataArrayList.size(); i++)
						{
							splitedDataIntList.add(new Double(splitedDataArrayList.get(i)));
						}
						
						arrayTxtList.add(splitedDataIntList);
					}
					
					lineNo++;
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return arrayTxtList;
	}
}
