package cn.tedu.store.mapper;

import cn.tedu.store.bean.User;

public interface UserMapper {
	
	User getUserByUserName(String userName);
	
	User getUserByUserEmail(String userEmail);
	
	User getUserByUserPhone(String userPhone);
	
	User getUserById(Integer id);
	
	void updateUser(User user);
	
	void insertUser(User user);
}
