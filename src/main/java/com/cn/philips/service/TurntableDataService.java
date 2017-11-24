package com.cn.philips.service;

import java.io.IOException;

import com.cn.philips.pojo.TurntableData;

public interface TurntableDataService {
	
	TurntableData getTurntableData(String filePath) throws IOException;
	
	String setTurntableData(TurntableData turntableData, String filePath) throws IOException;
	
}
