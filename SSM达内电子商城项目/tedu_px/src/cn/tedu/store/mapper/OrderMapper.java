package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.vo.OrderVO;


public interface OrderMapper {
	
	/**
	 * 插入订单数据
	 * @param order 订单数据
	 * @return 受影响的行数
	 */
	Integer insertOrder(Order order);
	
	/**
	 * 插入订单商品数据
	 * @param orderItem 订单商品数据
	 * @return 受影响的行数
	 */
	Integer insertOrderItem(OrderItem orderItem);
	
	List<OrderVO> getOrder();
	
	Integer changeState(@Param("uid") Integer uid,
						@Param("id") Integer id,
						@Param("payTime")Date payTime);

	
	Order orderInfo(@Param("uid") Integer uid,
					@Param("id") Integer id);

	List<OrderItem> getOrderItem(@Param("oid") Integer oid);

	//获取该用户所有订单id
	Integer[] getOidByUid(@Param("uid") Integer uid);

	//获取该用户的所有 order Item 的总数
	Integer getCountByOid(@Param("oids")Integer[] oids);

	//获取该用户订单项详细信息
	List<OrderItem> getOrderItems(@Param("oids")Integer[] oids, 
							@Param("offset")Integer offset, 
							@Param("count")Integer count);
}







