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
		// ��������ֵ����
		ResponseResult<List<GoodsCategory>> rr
			= new ResponseResult<List<GoodsCategory>>();
		// ����ҵ�������getListByParent(parentId)����������ȡ����ֵ
		List<GoodsCategory> goodsCategories
			= goodsCategoryService
				.getListByParent(parentId);
		// �򷵻�ֵ�����data���Է�װ����
		rr.setData(goodsCategories);
		// ִ�з���
		return rr;
	}

}










