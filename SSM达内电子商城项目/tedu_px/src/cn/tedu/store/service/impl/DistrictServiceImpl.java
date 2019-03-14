package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.District;
import cn.tedu.store.mapper.DistrictMapper;
import cn.tedu.store.service.DistrictService;


@Service("districtService")
public class DistrictServiceImpl 
	implements DistrictService {
	
	@Autowired
	private DistrictMapper districtMapper;

	public List<District> getList(String parent) {
		return districtMapper.getList(parent);
	}

	public District getInfo(String code) {
		return districtMapper.getInfo(code);
	}

}








