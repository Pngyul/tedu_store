package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Address;


public interface AddressMapper {

	/**
	 * 插入收货地址数据
	 * @param address 收货地址数据
	 * @return 受影响的行数
	 */
	Integer insert(Address address);
	
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
	 * 将某用户的所有收货地址全部设置为非默认收货地址
	 * @param uid 用户id
	 * @return 受影响的行数
	 */
	Integer setNonDefault(Integer uid);

	/**
	 * 将某用户的某条收货地址设置为默认收货地址
	 * @param uid 用户id
	 * @param id 收货地址数据的id
	 * @return 受影响的行数
	 */
	Integer setDefault(
		@Param("uid") Integer uid, 
		@Param("id") Integer id);
	
	/**
	 * 删除收货地址数据
	 * @param id 收货地址数据的id
	 * @return 受影响的行数
	 */
	Integer delete(Integer id);
	
	//获取默认收货地址
	Address getdefaultAddress(Integer uid);
	
}










