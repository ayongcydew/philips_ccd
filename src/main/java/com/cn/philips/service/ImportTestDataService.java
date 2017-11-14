package com.cn.philips.service;

import java.util.Date;
import java.util.List;

public interface ImportTestDataService {

	public void InsertTestData(String planName, String description, Date startTime, String operatorName, List<String> insertFileList) throws Exception;
}
