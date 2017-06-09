package com.cn.philips.service;

import java.util.Date;

public interface ImportTestDataService {

	public void InsertTestData(String planName, String description, Date startTime, String operatorName, String briPath, 
			String xPath,String yPath,String uPath,String vPath) throws Exception;
}
