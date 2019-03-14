package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface UserService {
	
	void checkUserByUserName(String userName);

	void checkUserByUserEmail(String userEmail);
	
	void checkUserByUserPhone(String userPhone);
	
	User login(String userName,String password);
	
	void register(User user);
	
	void changePassword(Integer id,String oldPwd,String newPwd);
	
	User changePersonalInfo(User user);
}