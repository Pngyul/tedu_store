package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController {

	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/hot_list.do")
	@ResponseBody
	public ResponseResult<List<Goods>> getHotList(
		@RequestParam("category_id") Long categoryId) {
		// ��������ֵ����
		ResponseResult<List<Goods>> rr
			= new ResponseResult<List<Goods>>();
		// ����ҵ�������getHotList(categoryId, 3)����������ȡ����ֵ
		List<Goods> goodsList
			= goodsService.getHotList(categoryId, 3);
		// �򷵻�ֵ�����data���Է�װ����
		rr.setData(goodsList);
		// ִ�з���
		return rr;
	}
	
	@RequestMapping("/details.do")
	@ResponseBody
	public ResponseResult<Goods> getDetails(
		@RequestParam("id") Long id) {
		// ��������ֵ����
		ResponseResult<Goods> rr
			= new ResponseResult<Goods>();
		// ����ҵ�������getGoodsById(id)����������ȡ����ֵ
		Goods goods = goodsService.getGoodsById(id);
		// �򷵻�ֵ�����data���Է�װ����
		rr.setData(goods);
		// ִ�з���
		return rr;
	}
	
	@RequestMapping("/search_list.do")
	public String getSearchList(HttpServletRequest request,
		@RequestParam("keyWord") String keyWord,
		@RequestParam("page") Integer page) {
		List<Goods> goodsList = null;
		try {
			goodsList = goodsService.getSearchList(keyWord,page);
		} catch (Exception e) {
			return "404";
		}
		request.setAttribute("goodsList", goodsList);
		return "search";
	}
	
	@RequestMapping("/get_max_page.do")
	@ResponseBody
	public ResponseResult<Integer> getMaxPage(
			@RequestParam("keyWord") String keyWord) {
		Integer maxPage = goodsService.getMaxPage(keyWord);
		ResponseResult<Integer> rr
			= new ResponseResult<Integer>();
		rr.setData(maxPage);
		return rr;
	}
	
	
	
}









