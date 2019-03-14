package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.vo.OrderVO;


public interface OrderMapper {
	
	/**
	 * ���붩������
	 * @param order ��������
	 * @return ��Ӱ�������
	 */
	Integer insertOrder(Order order);
	
	/**
	 * ���붩����Ʒ����
	 * @param orderItem ������Ʒ����
	 * @return ��Ӱ�������
	 */
	Integer insertOrderItem(OrderItem orderItem);
	
	List<OrderVO> getOrder();
	
	Integer changeState(@Param("uid") Integer uid,
						@Param("id") Integer id,
						@Param("payTime")Date payTime);

	
	Order orderInfo(@Param("uid") Integer uid,
					@Param("id") Integer id);

	List<OrderItem> getOrderItem(@Param("oid") Integer oid);

	//��ȡ���û����ж���id
	Integer[] getOidByUid(@Param("uid") Integer uid);

	//��ȡ���û������� order Item ������
	Integer getCountByOid(@Param("oids")Integer[] oids);

	//��ȡ���û���������ϸ��Ϣ
	List<OrderItem> getOrderItems(@Param("oids")Integer[] oids, 
							@Param("offset")Integer offset, 
							@Param("count")Integer count);
}







