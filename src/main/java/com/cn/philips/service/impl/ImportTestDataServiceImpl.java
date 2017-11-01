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
		
		int i = 0;
		int j = 0;
		
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
		
		ArrayList<CcdTestData> testDataDetailList = new ArrayList<CcdTestData>();
		try {
			if (arrayTxtListXPath.size() == 0) throw new Exception("X����û�в���");

			for (i = 0; i < arrayTxtListXPath.size(); i ++) {
				for ( j = 0; j < (arrayTxtListXPath.get(i)).size(); j++) {
					CcdTestData testDataDetail = new CcdTestData();
					// TODO ����������Ҫ��planName���ж�
					testDataDetail.setPlanName(planName);
					if (planName.equals(null) || planName =="") {
						throw new Exception("planName can't be null");
						
					}
					// TODO Ҫ�����±�������������û�����ݵ�������Ժ��ٿ���
					testDataDetail.setLocx(i);
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
			System.out.println("��������");
			
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		
		CcdTestPlan ccdTestPlan = dataHandleService.GetCcdTestPlanByName(planName);
		if (ccdTestPlan == null) {
			CcdTestPlan ccdTestPlan1 = new CcdTestPlan();
			ccdTestPlan.setPlanName(planName);
			ccdTestPlan.setDescription(description);
			ccdTestPlan.setPixelX(i);
			ccdTestPlan.setPixelY(j);
			ccdTestPlan.setStartTime(startTime);
			ccdTestPlan.setOperatorName(operatorName);
			this.ccdTestPlanMapper.insert(ccdTestPlan);
			
			CcdTestRule ccdTestRule = new CcdTestRule();
			CcdTestPlan ccdTestPlan2 = dataHandleService.GetCcdTestPlanByName(planName);
			ccdTestRule.setPlanid(ccdTestPlan1.getId());
			this.ccdTestRuleMapper.insert(ccdTestRule);
			
			for (CcdTestData testDataDetail : testDataDetailList) {
				this.ccdTestDataMapper.insert(testDataDetail);
			}
			
		} else {
			System.out.println("planName exist");
//			throw new Exception("planName exist");
		}
		

	}
	
	private ArrayList<ArrayList<Double>>  ImportFromTxtFile(String txtFilePath) {
		ArrayList<ArrayList<Double>>  arrayTxtList = new ArrayList();
		try {
			String encoding = "UTF-8";
			File file = new File(txtFilePath);
			if (file.isFile() && file.exists()) { // �ж��ļ��Ƿ����
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// ���ǵ������ʽ
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
				System.out.println("�Ҳ���ָ�����ļ�");
			}
		} catch (Exception e) {
			System.out.println("��ȡ�ļ����ݳ���");
			e.printStackTrace();
		}
		return arrayTxtList;
	}
}
