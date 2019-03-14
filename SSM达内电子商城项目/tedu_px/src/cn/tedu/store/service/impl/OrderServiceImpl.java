package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.mapper.OrderMapper;
import cn.tedu.store.service.AddressService;
import cn.tedu.store.service.CartService;
import cn.tedu.store.service.GoodsService;
import cn.tedu.store.service.OrderService;
import cn.tedu.store.service.ex.InsertDataException;
import cn.tedu.store.service.ex.OrderNotFoundException2;
import cn.tedu.store.service.ex.UpdateDataException;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private AddressService addressService;
	@Autowired
	private CartService cartService;
	@Autowired
	private GoodsService goodsService;

	@Transactional
	public Order createOrder(Integer uid, Integer addressId, Integer[] cartIds) {
		// 设置现在提交时间
		Date now = new Date();
		// 根据 cartIds 获得 carts
		List<Cart> carts = cartService.getListByIds(uid, cartIds);
		// 计算总计
		Long totalPrice = 0L;
		for (Cart cart : carts) {
			totalPrice += cart.getGoodsPrice() * cart.getGoodsNum();
		}
		// 根据id 获取地址信息
		Address address = addressService.getAddressById(addressId);
		// 自定义 order，赋值订单信息
		Order order = new Order();
		order.setUid(uid);
		order.setRecvName(address.getRecvName());
		order.setRecvPhone(address.getRecvPhone());
		order.setRecvAddress(address.getRecvDistrict() + " " + address.getRecvAddress());
		order.setTotalPrice(totalPrice);
		order.setStatus(1); // 1:表示未支付:2:表示已支付
		order.setCreateTime(now);
		order.setPayTime(null);
		order.setModifiedTime(now);
		// 插入 order
		insertOrder(order);

		// 循环已选的 cart Item 插入订单项
		for (Cart cart : carts) {
			// 获得该商品对象
			Goods goods = goodsService.getGoodsById(cart.getGoodsId());

			OrderItem orderItem = new OrderItem();
			orderItem.setOrderId(order.getId());
			orderItem.setGoodsId(cart.getGoodsId());
			orderItem.setGoodsTitle(goods.getTitle());
			orderItem.setGoodsImage(goods.getImage());
			orderItem.setGoodsPrice(goods.getPrice());
			orderItem.setGoodsNum(cart.getGoodsNum());
			orderItem.setCreatedTime(now);
			orderItem.setModifiedTime(now);
			// 插入orderItem
			insertOrderItem(orderItem);
		}

		return order;
	}

	@Override
	public Order createOrderFrombuyNow(Integer uid, Long goodsId, Integer buyNum) {
		// 设置现在提交时间
		Date now = new Date();
		// 根据 cartIds 获得 carts
		// 计算总计
		Goods goods = goodsService.getGoodsById(goodsId);
		Long totalPrice = goods.getPrice() * buyNum;
		// 根据id 获取地址信息
		Address address = addressService.getdefaultAddress(uid);
		// 自定义 order，赋值订单信息
		Order order = new Order();
		order.setUid(uid);
		order.setRecvName(address.getRecvName());
		order.setRecvPhone(address.getRecvPhone());
		order.setRecvAddress(address.getRecvDistrict() + " " + address.getRecvAddress());
		order.setTotalPrice(totalPrice);
		order.setStatus(1); // 1:表示未支付:2:表示已支付
		order.setCreateTime(now);
		order.setPayTime(null);
		order.setModifiedTime(now);
		// 插入 order
		insertOrder(order);

		// 插入订单项
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderId(order.getId());
		orderItem.setGoodsId(goods.getId());
		orderItem.setGoodsTitle(goods.getTitle());
		orderItem.setGoodsImage(goods.getImage());
		orderItem.setGoodsPrice(goods.getPrice());
		orderItem.setGoodsNum(buyNum);
		orderItem.setCreatedTime(now);
		orderItem.setModifiedTime(now);
		
		// 插入orderItem
		insertOrderItem(orderItem);

		return order;

	}

	private Order insertOrder(Order order) {
		Integer rows = orderMapper.insertOrder(order);
		if (rows != 1) {
			throw new InsertDataException("提交订单失败，原因未知！");
		}
		return order;
	}

	private OrderItem insertOrderItem(OrderItem orderItem) {
		Integer rows = orderMapper.insertOrderItem(orderItem);
		if (rows != 1) {
			throw new InsertDataException("提交订单项失败，原因未知！");
		}
		return orderItem;
	}

	@Override
	public void changeState(Integer uid, Integer id) {
		Date payTime  = new Date();
		Integer state = orderMapper.changeState(uid, id,payTime);
		if (state == 0) {
			throw new UpdateDataException("支付失败，原因未知！");
		}
	}

	@Override
	public Order orderInfo(Integer uid, Integer id) {
		Order order = orderMapper.orderInfo(uid, id);
		if (order == null) {
			throw new OrderNotFoundException2("该订单不存在！");
		}
		return order;
	}

	@Override
	public List<OrderItem> getOrderItem(Integer oid) {
		return orderMapper.getOrderItem(oid);
	}

	@Override
	public List<OrderItem> orderitemList(Integer uid, Integer page) {
		// 如果page无效，视为page=1
		if (page == null || page < 1) {
			page = 1;
		}
		// 如果page超出上限，视为最后一页
		Integer[] oids = getOidByUid(uid);
		Integer dataCount =  getCountByOid(oids);
		Integer maxPage = (int) Math.ceil(1. * dataCount / COUNT_PER_PAGE); // 总数据量，每页数据量
		if (maxPage != 0 && page > maxPage) {
			page = maxPage;
		}
		// 执行
		Integer offset = (page - 1) * COUNT_PER_PAGE;
		Integer count = COUNT_PER_PAGE;
		return orderMapper.getOrderItems(oids, offset, count);
	}

	private Integer getCountByOid(Integer[] oids) {
		
		return orderMapper.getCountByOid(oids);
	}

	private Integer[] getOidByUid(Integer uid) {
		return orderMapper.getOidByUid(uid);
	}
	
	@Override
	public Integer getMaxPage(Integer uid) {
		Integer[] oids = getOidByUid(uid);
		Integer dataCount =  getCountByOid(oids);
		Integer maxPage = (int) Math.ceil(1. * dataCount / COUNT_PER_PAGE); // 总数据量，每页数据量
		return maxPage;
	}
	
}

