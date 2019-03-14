package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.District;

public interface DistrictMapper {
	
	/**
	 * 省的父级代号
	 * 
	 * @see #getList(String)
	 */
	String PROVINCE_PARENT = "86";

	/**
	 * 获取省/市/区的列表
	 * @param parent 父级的代号，例如获取市的列表时，应该使用其归属的省的代号，如果需要获取省列表，应该使用{@link #PROVINCE_PARENT}作为代号
	 * @return 省/市/区的列表
	 * @see #PROVINCE_PARENT
	 */
	List<District> getList(String parent);

	/**
	 * 获取某个省/市/区的详细信息
	 * @param code 省/市/区的代号
	 * @return 省/市/区的详细信息，如果没有匹配的数据，则返回null
	 */
	District getInfo(String code);
	
}









