package com.cn.philips.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.philips.pojo.UserCCD;
import com.cn.philips.service.UserCCDService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;   
import java.net.URLEncoder;   

@Controller
@RequestMapping("/bridge")
public class BridgeConnectionController {
	
	@RequestMapping(value="/getBridgeConfig",method=RequestMethod.GET)
	
	public String getBridgeConfig(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		String host = request.getParameter("host");
		String userName = request.getParameter("userName");
		String bridgeURL = "http://" + host + "/api/" + userName + "config"; 
		URL getUrl = new URL(bridgeURL); 
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        // ����������������ӣ���δ��������   
        connection.connect();   
        // �������ݵ���������ʹ��Reader��ȡ���ص�����   
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));   

        System.out.println(" ============================= ");   
        System.out.println(" Contents of get request ");   
        System.out.println(" ============================= ");   

        String lines;   
        while ((lines = reader.readLine()) != null) {   
                System.out.println(lines);   
        }   

        reader.close();   

        // �Ͽ�����   
        connection.disconnect();   

        System.out.println(" ============================= ");   
        System.out.println(" Contents of get request ends ");   
        System.out.println(" ============================= "); 
        
		return "showUsersTest";
	}
}
