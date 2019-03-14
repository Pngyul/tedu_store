package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.mapper.GoodsCategoryMapper;
import cn.tedu.store.service.GoodsCategoryService;

@Service("goodsCategoryService")
public class GoodsCategoryServiceImpl 
	implements GoodsCategoryService {
	
	@Autowired
	private GoodsCategoryMapper goodsCategoryMapper;

	public List<GoodsCategory> getListByParent(Long parentId) {
		return goodsCategoryMapper.getListByParent(parentId);
	}

}






