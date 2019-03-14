package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Cart;


public interface CartService {
	
	/**
	 * ÿҳ��ʾ�����ݵ�����
	 */
	Integer COUNT_PER_PAGE = 5;
	
	/**
	 * ��ӵ����ﳵ
	 * @param cart ���ﳵ����
	 */
	void addToCart(Cart cart);
	
	/**
	 * �����û�����Ʒid��ѯ���ﳵ�е�������
	 * @param uid �û�id
	 * @param goodsId ��Ʒid
	 * @return ƥ������ݵ�����
	 */
	Integer getCountByUidAndGoodsId(
			Integer uid, Long goodsId);
	
	/**
	 * �޸Ĺ��ﳵ����Ʒ������
	 * @param num ����
	 * @param uid �û�id
	 * @param goodsId ��Ʒid
	 * @return ��Ӱ�������
	 */
	void changeGoodsNum(
			Integer num, Integer uid, Long goodsId);
	
	void changeCartNum(
			Integer num, Integer uid, Long goodsId);
	
	/**
	 * ��ȡ���ﳵ�����б�
	 * @param uid �û�id
	 * @param page ҳ��
	 * @return ���ﳵ�����б�
	 */
	List<Cart> getList(Integer uid, Integer page);

	/**
	 * ��ȡĳ�û��Ĺ��ﳵ���ݵ�����
	 * @param uid �û���id
	 * @return �û��Ĺ��ﳵ���ݵ�����
	 */
	Integer getCountByUid(Integer uid);
	
	/**
	 * ��ȡĳ�û��Ĺ��ﳵ���ݵ����ҳ��
	 * @param uid �û�id
	 * @return ���ﳵ���ݵ����ҳ��
	 */
	Integer getMaxPage(Integer uid);
	
	/**
	 * ���ݶ������id��ȡ���ﳵ�е����ݵ��б�
	 * @param uid ���ݹ������û���id
	 * @param ids ��Ҫ��ѯ�����ݵ�id������
	 * @return ƥ������ݣ����û��ƥ������ݣ��򷵻���Ԫ�صļ���
	 */
	List<Cart> getListByIds(Integer uid, Integer[] ids);


	//ɾ�����ﳵ��
	void deleteCartItem(Integer uid, Integer cartId);

	void deleteCartItems(Integer uid, Integer[] cartIds);
}






