package cn.tedu.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.GoodsCategoryService;

@Controller
@RequestMapping("/goodsCategory")
public class GoodsCategoryController
	extends BaseController {
	
	@Autowired
	private GoodsCategoryService goodsCategoryService;
	
	@RequestMapping("/list.do")
	@ResponseBody
	public ResponseResult<List<GoodsCategory>> 
		getListByParent(
		@RequestParam("parent_id") Long parentId) {
		// 创建返回值对象
		ResponseResult<List<GoodsCategory>> rr
			= new ResponseResult<List<GoodsCategory>>();
		// 调用业务层对象的getListByParent(parentId)方法，并获取返回值
		List<GoodsCategory> goodsCategories
			= goodsCategoryService
				.getListByParent(parentId);
		// 向返回值对象的data属性封装数据
		rr.setData(goodsCategories);
		// 执行返回
		return rr;
	}

}










