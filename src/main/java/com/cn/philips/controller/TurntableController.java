package com.cn.philips.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;  
import java.io.FileWriter; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  

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
import com.cn.philips.pojo.TurntableData;
import com.cn.philips.service.TurntableDataService;

@Controller
@RequestMapping("/turntable")
public class TurntableController {
	
	@Resource
	private TurntableDataService turntableDataService;
	
	@RequestMapping(value="/setParameter",method=RequestMethod.POST)
	@ResponseBody
	public String  setParameter(HttpServletRequest request,HttpServletResponse response, @RequestBody String requestBody) throws Exception{
//		
//		String filePath = request.getParameter("filepath");
//		
//		TurntableData turntableData = new TurntableData();		
//		turntableData.setReset(request.getParameter("reset"));
//		turntableData.setStatus(request.getParameter("status"));
//		turntableData.setRunmode(request.getParameter("runmode"));
//		turntableData.setAngle(request.getParameter("angle"));
//		turntableData.setSpeed(request.getParameter("speed"));
//		turntableData.setInterval(request.getParameter("interval"));
//		
//		turntableDataService.setTurntableData(turntableData, filePath);
//		
		return "success";		
	}
//	
//	@RequestMapping(value="/getParameter",method=RequestMethod.GET)
//	@ResponseBody
//	public TurntableData  getParameter(HttpServletRequest request,HttpServletResponse response, @RequestBody String requestBody) throws Exception{
//		String filePath = request.getParameter("filepath");
//		
//		TurntableData turntableData = turntableDataService.getTurntableData(filePath);
//		return turntableData;		
//	}
}
