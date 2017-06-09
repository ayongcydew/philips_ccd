//package com.cn.philips.controller;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.cn.philips.pojo.SerialPort;
//import com.cn.philips.pojo.User;
//import com.cn.philips.service.ISerialPortCommService;
//
//@Controller
//@RequestMapping("/serial")
//public class SerialPortCommController {
//	@Resource
//	private ISerialPortCommService serialPortCommService;
//	
//	@RequestMapping("/setSerial")
//	public String toIndex(HttpServletRequest request,Model model){
//		int comId = Integer.parseInt(request.getParameter("id"));
//		int baudrate = Integer.parseInt(request.getParameter("baudrate"));
//		int timeout = Integer.parseInt(request.getParameter("timeout"));
//		long rotationAngle = Long.parseLong(request.getParameter("rotationAngle"));
//		int rotationSpeed = Integer.parseInt(request.getParameter("rotationSpeed"));
//		
//		String commandText = request.getParameter("commandText");
//		SerialPort serialPort = this.serialPortCommService.setComPort(comId, baudrate, timeout, rotationAngle, rotationSpeed, commandText);
//		model.addAttribute("serialPort", serialPort);
//		return "setSerial";
//	}
//}
