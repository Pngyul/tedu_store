package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.Order;
import cn.tedu.store.bean.OrderItem;

public interface OrderService {
	
	Integer COUNT_PER_PAGE = 3;
	
	/**
	 * ��������
	 * @param uid ��ǰ��¼���û�
	 * @param addressId ѡ����ջ���ַ��id
	 * @param cartIds ѡ�еĹ��ﳵ�е����ݵ�id
	 * @return �ɹ������Ķ���
	 */
	Order createOrder(Integer uid, Integer addressId, Integer[] cartIds);

	//ȷ��֧�����޸Ķ���״̬ 2
	void changeState(Integer uid, Integer id);

	//�鿴������ϸ��Ϣ
	Order orderInfo(Integer uid, Integer id);

	//��ȡĳһ�����Ķ�����
	List<OrderItem> getOrderItem(Integer oid);

	//�������򴴽�����
	Order createOrderFrombuyNow(Integer uid, Long goodsId,Integer buyNum);

	List<OrderItem> orderitemList(Integer uid, Integer page);

	Integer getMaxPage(Integer uid);

}
