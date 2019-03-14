package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.CollectService;
import cn.tedu.store.vo.CollectionVO;

@Controller
@RequestMapping("/collect")
public class CollectController extends BaseController {
	
	@Autowired
	private CollectService collectService;

	@RequestMapping("/showFavorites.do")
	public String showFavorites() {
		return "favorites";
	}
	
	@RequestMapping("/add_to_collect.do")
	@ResponseBody
	public ResponseResult<Void> addToCollect(HttpSession session, @RequestParam("goods_id") String goodsId) {

		User user = (User) session.getAttribute("user");
		collectService.addToCollect(user, goodsId);
		return new ResponseResult<Void>();
	}

	@RequestMapping("/list.do")
	@ResponseBody
	public ResponseResult<List<CollectionVO>> getList(HttpSession session) {
		Integer uid = getUidFromSession(session);
		List<CollectionVO> collect = collectService.getList(uid);
		ResponseResult<List<CollectionVO>> rr = new ResponseResult<List<CollectionVO>>();
		rr.setData(collect);
		return rr;
	}

	@RequestMapping("/delete_collect_Items.do")
	@ResponseBody
	public ResponseResult<Void> delete_Cart_Items(
			HttpSession session, 
			@RequestParam("collect_ids") Long[] ids) {
		Integer uid = getUidFromSession(session);
		collectService.deleteCollectItems(uid, ids);
		return new ResponseResult<Void>();
	}
}
