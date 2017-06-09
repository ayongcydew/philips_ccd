package com.cn.philips.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.philips.pojo.User;
import com.cn.philips.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	
//	@RequestMapping(value="/showUser",method=RequestMethod.GET)
	
//	public String toIndex(HttpServletRequest request,HttpServletResponse response,Model model){
//		int userId = Integer.parseInt(request.getParameter("id"));
//		User user = this.userService.getUserById(userId);
//		model.addAttribute("user", user);
//		return "showUsers";
//	}
//	@ResponseBody 
//	public User getUser(HttpServletRequest request, HttpServletResponse response){
//	int userId = Integer.parseInt(request.getParameter("id"));
//	response.setContentType("application/json;charset=utf-8");
//	User user1 = this.userService.getUserById(userId);
//	return user1;
//	}
	@RequestMapping(value="/showUser",method=RequestMethod.GET)
	@ResponseBody
	public User test2(HttpServletRequest request,HttpServletResponse response){
		User user = new User();
		user.setAge(1);
		user.setId(1);
		user.setUserName("Œ“ «∏ˆ≤‚ ‘");
		user.setPassword("1111");
		return user;
	}
}
