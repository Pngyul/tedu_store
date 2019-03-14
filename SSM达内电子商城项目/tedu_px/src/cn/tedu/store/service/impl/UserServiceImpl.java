package cn.tedu.store.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.UserService;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameConflictException;


@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	public void checkUserByUserName(String userName) {
		
		if(userMapper.getUserByUserName(userName)!=null){
			throw new UsernameConflictException("该用户已存在！");
		}
		
	}
	

	@Override
	public void checkUserByUserEmail(String userEmail) {
		if(userMapper.getUserByUserEmail(userEmail)!=null){
			throw new UsernameConflictException("该邮箱已存在！");
		}
	}

	@Override
	public void checkUserByUserPhone(String userPhone) {
		if(userMapper.getUserByUserPhone(userPhone)!=null){
			throw new UsernameConflictException("该手机号已存在！");
		}
	}

	@Override
	public void register(User user) {
		
		User user1 = userMapper.getUserByUserName(user.getUser_name());
		if(user1 == null){
			userMapper.insertUser(user);
		}else{
			throw new UsernameConflictException("该用户已存在");
		}
		}


	@Override
	public User login(String userName, String password) {
		User user = userMapper.getUserByUserName(userName);
		
		if(user == null){
			throw new UserNotFoundException("该用户不存在");
		}
		else{
			if(user.getUser_pwd().equals(password)){
				return user;
			}else{
				throw new PasswordNotMatchException("密码不正确");
			}
		}
	}


	@Override
	public void changePassword(Integer id, String oldPwd, String newPwd) {
		User user = userMapper.getUserById(id);
		if(user == null){
			throw new UserNotFoundException("该用户不存在");
		}else{
			if(user.getUser_pwd().equals(oldPwd)){
				User user1 = new User();
				user1.setUser_pwd(newPwd);
				user1.setUser_id(id);
				user1.setModified_user(user.getUser_name());
				user1.setModified_time(new Date());
				userMapper.updateUser(user1);
			}else{ 
				throw new PasswordNotMatchException("密码不匹配");
			}
		}
	}

	public User changePersonalInfo(User user) {
		
		user.setModified_time(new Date());
		user.setModified_user(user.getUser_name());
		
		userMapper.updateUser(user);
		
		return userMapper.getUserById(user.getUser_id());
	}
	
	}
	
