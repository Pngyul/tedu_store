package cn.tedu.store.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.UserService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:application-dao.xml"})
public class mybatisTest {
	
//	@Autowired
//	private UserMapper userMapper;
	@Test
	public void selectTest() {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:application-dao.xml");
//		UserMapper um = (UserMapper) ac.getBean("userMapper");
//		User user = userMapper.getUserByUsrname("lisi");
//		System.out.println(user);
	}
	
}
