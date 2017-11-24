package com.cn.test.philips;

import java.util.List;
import java.io.IOException;
import java.math.*;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.cn.philips.pojo.TurntableData;
import com.cn.philips.pojo.User;
import com.cn.philips.pojo.UserCCD;
import com.cn.philips.service.IUserService;
import com.cn.philips.service.TurntableDataService;
import com.cn.philips.service.UserCCDService;

@RunWith(SpringJUnit4ClassRunner.class)		//
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
//	private ApplicationContext ac = null;
	@Resource
	private IUserService userService;
	
	@Resource
	private UserCCDService userCCDService;
	
	@Resource
	private TurntableDataService turntableDataService;
	
	//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

	@Test
	public void test1() {
		UserCCD userCCD = userCCDService.getUserById(1);
		// System.out.println(user.getUserName());
		// logger.info("name :"+user.getUserName());
		logger.info(JSON.toJSONString(userCCD));
	}
	
	@Test
	public void test2() {
		User user = userService.getUserById(1);
		// System.out.println(user.getUserName());
		// logger.info("name :"+user.getUserName());
		logger.info(JSON.toJSONString(user));
	}
	
	@Test
	public void test3() {
		List<UserCCD> userList = userCCDService.getAllUsers();
		// System.out.println(user.getUserName());
		// logger.info("name :"+user.getUserName());
		int sum=0;
		int total=0;
		for(int i=0;i<userList.size();i++){		
		     if (userList.get(i).getAge() != null) {//判断是否为数�??
		          sum+= userList.get(i).getAge();
		          total+=1;
		     }
		}
		int avg_age = 0;
		if(total!=0) 
			 avg_age=sum/total;
		System.out.println("平均年龄" + avg_age);
		logger.info(JSON.toJSONString(avg_age));
	}
	
	@Test
	public void test4() throws IOException {
		
		String filePath = "c:/aaa.ini";
		
//		TurntableData turntableData = turntableDataService.getTurntableData(filePath);
		TurntableData turntableData = new TurntableData();
		turntableData.setReset("a");
		turntableData.setRunmode("b");
		turntableData.setStatus("c");
		turntableData.setAngle("d");
		turntableData.setInterval("d");
		turntableData.setSpeed("f");
		turntableDataService.setTurntableData(turntableData, filePath);
		
		System.out.println(turntableData.getReset());
	}
	
}
