package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Address;
import cn.tedu.store.service.ex.AddressNotFoundException;
import cn.tedu.store.service.ex.ArgumentException;
import cn.tedu.store.service.ex.InsertDataException;
import cn.tedu.store.service.ex.UpdateDataException;

public interface AddressService {
	
	/**
	 * 添加新的收货地址信息
	 * @param currentUser 当前用户的用户名
	 * @param address 收货地址信息
	 * @return 成功添加的收货地址信息，包括id
	 * @throws InsertDataException
	 */
	Address addnew(String currentUser, Address address) 
			throws InsertDataException;

	/**
	 * 根据当前用户id，查询该用户的收货地址的数量
	 * @param uid 当前用户id
	 * @return 该用户的收货地址的数量
	 */
	Integer getCountByUid(Integer uid);
	
	/**
	 * 获取某用户的收货地址列表
	 * @param uid 用户的id
	 * @return 收货地址列表
	 */
	List<Address> getList(Integer uid);
	
	/**
	 * 设置某用户的某条收货地址为默认收货地址
	 * @param uid 用户id
	 * @param id 被设置为默认收货地址的数据的id
	 */
	void setDefaultAddress(Integer uid, Integer id);
	
	/**
	 * 根据id查询收货地址数据
	 * @param id 数据id
	 * @return 匹配的收货地址数据，如果没有匹配的数据，则返回null
	 */
	Address getAddressById(Integer id);
	
	/**
	 * 获取最后添加的收货地址数据
	 * @param uid 用户id
	 * @return 收货地址数据，如果没有匹配的数据，则返回null
	 */
	Address getLatestAddress(Integer uid);
	
	/**
	 * 删除收货地址数据
	 * @param uid 当前登录的用户id
	 * @param id 收货地址数据id
	 * @throws AddressNotFoundException
	 * @throws ArgumentException
	 */
	void deleteById(Integer uid, Integer id) throws
		AddressNotFoundException, ArgumentException, UpdateDataException;

	Address getdefaultAddress(Integer uid);
}




