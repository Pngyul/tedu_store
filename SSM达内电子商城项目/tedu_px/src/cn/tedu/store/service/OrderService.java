package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderItem;

public interface OrderService {
	
	Integer COUNT_PER_PAGE = 3;
	
	/**
	 * 创建订单
	 * @param uid 当前登录的用户
	 * @param addressId 选择的收货地址的id
	 * @param cartIds 选中的购物车中的数据的id
	 * @return 成功创建的订单
	 */
	Order createOrder(Integer uid, Integer addressId, Integer[] cartIds);

	//确认支付，修改订单状态 2
	void changeState(Integer uid, Integer id);

	//查看订单详细信息
	Order orderInfo(Integer uid, Integer id);

	//获取某一订单的订单项
	List<OrderItem> getOrderItem(Integer oid);

	//立即购买创建订单
	Order createOrderFrombuyNow(Integer uid, Long goodsId,Integer buyNum);

	List<OrderItem> orderitemList(Integer uid, Integer page);

	Integer getMaxPage(Integer uid);

}
