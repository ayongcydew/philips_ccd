package com.cn.philips.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
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

import com.cn.philips.pojo.User;
import com.cn.philips.pojo.UserCCD;
import com.cn.philips.service.IUserService;
import com.cn.philips.service.UserCCDService;

@Controller
@RequestMapping("/userCCD")
public class UserCCDController {
	@Resource
	private UserCCDService userCCDService;
	
//	@RequestMapping(value="/showCCDUser",method=RequestMethod.GET)
	
//	public String toIndex(HttpServletRequest request,HttpServletResponse response,Model model){
//		int userId = Integer.parseInt(request.getParameter("id"));
//		UserCCD userCCD1 = this.userCCDService.getUserById(1);
//		UserCCD userCCD2 = this.userCCDService.getUserById(2);
//		model.addAttribute("user1", userCCD1);
//		model.addAttribute("user2", userCCD2);
//		return "showUsersTest";
//	}
	
	@RequestMapping(value="/showCCDUser",method=RequestMethod.GET)
	@ResponseBody
	public UserCCD toIndex(HttpServletRequest request,HttpServletResponse response){
		int userId = Integer.parseInt(request.getParameter("id"));
		UserCCD userCCD1 = this.userCCDService.getUserById(1);
		return userCCD1;
	}
	

	@RequestMapping(value="/test2",method=RequestMethod.GET)
	@ResponseBody
	public User test2(HttpServletRequest request,HttpServletResponse response){
		User user = new User();
		user.setAge(1);
		user.setId(1);
		user.setUserName("我是个测试");
		user.setPassword("1111");
		return user;
	}
	
	@RequestMapping(value="/test3",method=RequestMethod.POST)
	@ResponseBody
	public User test3(HttpServletRequest request,HttpServletResponse response, @RequestBody User user1){
		User user = new User();
		user.setAge(user1.getAge());
//		user.setAge(1);
		user.setId(1);
		user.setUserName("我是个测试");
		user.setPassword("1111");
		return user;
	}
	
	@RequestMapping(value="/test4",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> testPostJson(
			@RequestBody  User user,
			BindingResult bindingResult) {
			
		Map<String, Object> map = new HashMap<String, Object>();
		if (bindingResult.hasErrors()) {
			map.put("errorCode", "40001");
			map.put("errorMsg", bindingResult.getFieldError().getDefaultMessage());
		}
		
		map.put("user", user);
		return map;
	}
}
