package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/showCart.do")
	public String showCart() {
		return "cart";
	}
	
	@RequestMapping("/add_to_cart.do")
	@ResponseBody
	public ResponseResult<Void> addToCart(
		HttpSession session,
		@RequestParam("goods_id") Long goodsId,
		@RequestParam("goods_num") Integer goodsNum) {
		Integer uid = getUidFromSession(session);
		Cart cart = new Cart();
		
		//System.out.println("cartService=" + cartService);
		//System.out.println("cart=" + cart);
		
		cart.setUid(uid);
		cart.setGoodsId(goodsId);
		cart.setGoodsNum(goodsNum);
		cartService.addToCart(cart);
		return new ResponseResult<Void>();
	}
	
	@RequestMapping("/list.do")
	@ResponseBody
	public ResponseResult<List<Cart>> getList(
		HttpSession session,
		@RequestParam(value="page", required=false, defaultValue="1") Integer page) {
		Integer uid = getUidFromSession(session);
		List<Cart> carts = cartService.getList(uid, page);
		ResponseResult<List<Cart>> rr = new ResponseResult<List<Cart>>();
		rr.setData(carts);
		return rr;
	}
	
	@RequestMapping("/get_max_page.do")
	@ResponseBody
	public ResponseResult<Integer> getMaxPage(
			HttpSession session) {
		Integer uid = getUidFromSession(session);
		Integer maxPage = cartService.getMaxPage(uid);
		ResponseResult<Integer> rr
			= new ResponseResult<Integer>();
		rr.setData(maxPage);
		return rr;
	}
	
	@RequestMapping("/get_list_by_ids.do")
	@ResponseBody
	public ResponseResult<List<Cart>> getListByIds(
		HttpSession session,
		@RequestParam("ids") Integer[] ids) {
		//System.out.println(ids[0]+" "+ids[1]+" "+ids[2]);
		Integer uid = getUidFromSession(session);
		List<Cart> carts
			= cartService.getListByIds(uid, ids);
		ResponseResult<List<Cart>> rr
			= new ResponseResult<List<Cart>>();
		rr.setData(carts);
		return rr;
	}
	
	@RequestMapping("/change_cart_num.do")
	@ResponseBody
	public ResponseResult<Void> changeCartNum(
			HttpSession session,Long itemId,Integer num) {
			Integer uid = getUidFromSession(session);
			cartService.changeCartNum(num, uid, itemId);
			return new ResponseResult<Void>();
		}
	
	
	@RequestMapping("/delete_Cart_Item.do")
	@ResponseBody
	public ResponseResult<Void> deleteCartItem(
			HttpSession session,@RequestParam("cart_id")Integer cartId) {
			Integer uid = getUidFromSession(session);
			//System.out.println("cartIds"+cart_ids);
			cartService.deleteCartItem(uid,cartId);
			return new ResponseResult<Void>();
		}
	
	@RequestMapping("/delete_Cart_Items.do")
		@ResponseBody
		public ResponseResult<Void> delete_Cart_Items(
				HttpSession session,@RequestParam("cart_ids")Integer[] cartIds) {
				Integer uid = getUidFromSession(session);
				//System.out.println("cartIds"+cart_ids);
				cartService.deleteCartItems(uid,cartIds);
				return new ResponseResult<Void>();
			}
	
	@RequestMapping("/collect_To_Cart.do")
	@ResponseBody 
	public ResponseResult<Void> collectToCart(
		HttpSession session,
		@RequestParam("goods_ids") Long[] goodsIds) {
		Integer uid = getUidFromSession(session);
		for(Long goodsId : goodsIds){
			Cart cart = new Cart();
			cart.setUid(uid);
			cart.setGoodsId(goodsId);
			cart.setGoodsNum(1);
			cartService.addToCart(cart);
		}
		return new ResponseResult<Void>();
	}
	
	

}










