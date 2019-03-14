package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/showOrders.do")
	public String showOrders() {
		return "orders";
	}
	
	@RequestMapping(value="/create.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Order> create(
		HttpSession session,
		@RequestParam("address_id") Integer addressId,
		@RequestParam("cart_id") Integer[] cartIds) {
		ResponseResult rr = new ResponseResult<Order>();
		// 获取uid
		Integer uid = getUidFromSession(session);
		// 调用业务层对象的方法创建订单
		Order order = orderService.createOrder(uid, addressId, cartIds);
		session.setAttribute("order", order);
		rr.setData(order);
		// 创建成功后，转发或重定向
		return rr;
	}
	
	@RequestMapping(value="/okPayToChangeState.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> okPayToChangeState(
			HttpSession session,Integer id) {
			ResponseResult rr = new ResponseResult<Void>();
			// 获取uid
			Integer uid = getUidFromSession(session);
			// 调用业务层对象的方法创建订单
			orderService.changeState(uid,id);
			// 创建成功后，转发或重定向
			return rr;
		}
	
	@RequestMapping(value="/orderInfo.do")
	public String orderInfo(
			HttpSession session,HttpServletRequest request,Integer id) {
			// 获取uid
			Integer uid = getUidFromSession(session);
			// 调用业务层对象的方法创建订单
			Order order = orderService.orderInfo(uid,id);
			request.setAttribute("order1", order);
			return "orderInfo";
		}
	
	@RequestMapping(value="/getOrderItem.do")
	@ResponseBody
	public ResponseResult<Order> getOrderItem(
			HttpSession session,Integer oid) {
			ResponseResult rr = new ResponseResult<Order>();
			// 调用业务层对象的方法创建订单
			List<OrderItem> orderItems = orderService.getOrderItem(oid);
			rr.setData(orderItems);
			return rr;
		}
	
	@RequestMapping(value="/buy_now_to_create.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Order> buyNowToCreate(
		HttpSession session,
		@RequestParam("buy_num") Integer buyNum,
		@RequestParam("goods_id") Long goodsId) {
		ResponseResult rr = new ResponseResult<Order>();
		// 获取uid
		Integer uid = getUidFromSession(session);
		// 调用业务层对象的方法创建订单
		Order order = orderService.createOrderFrombuyNow(uid,goodsId,buyNum);
		session.setAttribute("order", order);
		rr.setData(order);
		// 创建成功后，转发或重定向
		return rr;
	}
	
	@RequestMapping("/orderitem_list.do")
	@ResponseBody
	public ResponseResult<List<OrderItem>> orderitemList(
		HttpSession session,
		@RequestParam(value="page", required=false, defaultValue="1") Integer page) {
		Integer uid = getUidFromSession(session);
		List<OrderItem> oederItem = orderService.orderitemList(uid, page);
		ResponseResult<List<OrderItem>> rr = new ResponseResult<List<OrderItem>>();
		rr.setData(oederItem);
		return rr;
	}
	
	@RequestMapping("/get_max_page.do")
	@ResponseBody
	public ResponseResult<Integer> getMaxPage(
			HttpSession session) {
		Integer uid = getUidFromSession(session);
		Integer maxPage = orderService.getMaxPage(uid);
		ResponseResult<Integer> rr
			= new ResponseResult<Integer>();
		rr.setData(maxPage);
		return rr;
	}
}
