package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;


public interface CartMapper {
	
	/**
	 * �����µĹ��ﳵ����
	 * @param cart ���ﳵ����
	 * @return ��Ӱ�������
	 */
	Integer insert(Cart cart);
	
	/**
	 * �����û�����Ʒid��ѯ���ﳵ�е�������
	 * @param uid �û�id
	 * @param goodsId ��Ʒid
	 * @return ƥ������ݵ�����
	 */
	Integer getCountByUidAndGoodsId(
			@Param("uid") Integer uid,
			@Param("goodsId") Long goodsId);
	
	/**
	 * �޸Ĺ��ﳵ����Ʒ������
	 * @param num ����
	 * @param uid �û�id
	 * @param goodsId ��Ʒid
	 * @return ��Ӱ�������
	 */
	Integer changeGoodsNum(
			@Param("num") Integer num,
			@Param("uid") Integer uid,
			@Param("goodsId") Long goodsId);
	
	 
	Integer changeCartNum(
			@Param("num") Integer num,
			@Param("uid") Integer uid,
			@Param("goodsId") Long goodsId);

	/**
	 * ��ȡ���ﳵ�����б�
	 * @param uid �û�id
	 * @param offset ��������������
	 * @param count ��ȡ����������
	 * @return ���ﳵ�����б�
	 */
	List<Cart> getList(
			@Param("uid") Integer uid, 
			@Param("offset") Integer offset, 
			@Param("count") Integer count);
	
	/**
	 * ��ȡĳ�û��Ĺ��ﳵ���ݵ�����
	 * @param uid �û���id
	 * @return �û��Ĺ��ﳵ���ݵ�����
	 */
	Integer getCountByUid(Integer uid);
	
	/**
	 * ���ݶ������id��ȡ���ﳵ�е����ݵ��б�
	 * @param uid ���ݹ������û���id
	 * @param ids ��Ҫ��ѯ�����ݵ�id������
	 * @return ƥ������ݣ����û��ƥ������ݣ��򷵻���Ԫ�صļ���
	 */
	List<Cart> getListByIds(
			@Param("uid") Integer uid, 
			@Param("ids") Integer[] ids);


	//ɾ��������
	Integer deleteCartItem(
			@Param("uid")Integer uid,
			@Param("id")Integer id);
	
	Integer deleteCartItems(
			@Param("uid")Integer uid,
			@Param("ids")Integer[] ids);
	
}









