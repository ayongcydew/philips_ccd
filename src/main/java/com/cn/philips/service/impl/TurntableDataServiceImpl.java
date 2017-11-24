package com.cn.philips.service.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.cn.philips.pojo.TurntableData;
import com.cn.philips.service.TurntableDataService;

@Service("turntableDataService")
public class TurntableDataServiceImpl implements TurntableDataService {

	@Override
	public TurntableData getTurntableData(String filePath) throws IOException {
		// TODO Auto-generated method stub
		TurntableData turntableData = new TurntableData();
//		ConfigurationFileImpl configurationFileImpl = new ConfigurationFileImpl(filePath);
		turntableData.setReset(ConfigurationFileImpl.getProfileString(filePath, "CONTROL", "reset", "default"));
		turntableData.setStatus(ConfigurationFileImpl.getProfileString(filePath, "CONTROL", "status", "default"));
		turntableData.setRunmode(ConfigurationFileImpl.getProfileString(filePath, "CONTROL", "runmode", "default"));
		turntableData.setAngle(ConfigurationFileImpl.getProfileString(filePath, "SETUP", "angle", "default"));
		turntableData.setSpeed(ConfigurationFileImpl.getProfileString(filePath, "SETUP", "speed", "default"));
		turntableData.setInterval(ConfigurationFileImpl.getProfileString(filePath, "SETUP", "interval", "default"));
		
		return turntableData;
	}

	@Override
	public String setTurntableData(TurntableData turntableData, String filePath) throws IOException{
		// TODO Auto-generated method stub
//		ConfigurationFileImpl configurationFileImpl = new ConfigurationFileImpl(filePath);
		ConfigurationFileImpl.setProfileString(filePath, "CONTROL", "reset", turntableData.getReset());
		ConfigurationFileImpl.setProfileString(filePath, "CONTROL", "status", turntableData.getStatus());
		ConfigurationFileImpl.setProfileString(filePath, "CONTROL", "runmode", turntableData.getRunmode());
		ConfigurationFileImpl.setProfileString(filePath, "SETUP", "angle", turntableData.getAngle());
		ConfigurationFileImpl.setProfileString(filePath, "SETUP", "speed", turntableData.getSpeed());
		ConfigurationFileImpl.setProfileString(filePath, "SETUP", "interval", turntableData.getInterval());
		
		return null;
	}

}
