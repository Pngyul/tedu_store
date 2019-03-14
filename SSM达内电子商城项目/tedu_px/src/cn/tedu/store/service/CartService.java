package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Cart;


public interface CartService {
	
	/**
	 * 每页显示的数据的数量
	 */
	Integer COUNT_PER_PAGE = 5;
	
	/**
	 * 添加到购物车
	 * @param cart 购物车数据
	 */
	void addToCart(Cart cart);
	
	/**
	 * 根据用户和商品id查询购物车中的数据量
	 * @param uid 用户id
	 * @param goodsId 商品id
	 * @return 匹配的数据的数量
	 */
	Integer getCountByUidAndGoodsId(
			Integer uid, Long goodsId);
	
	/**
	 * 修改购物车中商品的数量
	 * @param num 增量
	 * @param uid 用户id
	 * @param goodsId 商品id
	 * @return 受影响的行数
	 */
	void changeGoodsNum(
			Integer num, Integer uid, Long goodsId);
	
	void changeCartNum(
			Integer num, Integer uid, Long goodsId);
	
	/**
	 * 获取购物车数据列表
	 * @param uid 用户id
	 * @param page 页数
	 * @return 购物车数据列表
	 */
	List<Cart> getList(Integer uid, Integer page);

	/**
	 * 获取某用户的购物车数据的数量
	 * @param uid 用户的id
	 * @return 用户的购物车数据的数量
	 */
	Integer getCountByUid(Integer uid);
	
	/**
	 * 获取某用户的购物车数据的最大页数
	 * @param uid 用户id
	 * @return 购物车数据的最大页数
	 */
	Integer getMaxPage(Integer uid);
	
	/**
	 * 根据多个数据id获取购物车中的数据的列表
	 * @param uid 数据归属的用户的id
	 * @param ids 需要查询的数据的id的数组
	 * @return 匹配的数据，如果没有匹配的数据，则返回无元素的集合
	 */
	List<Cart> getListByIds(Integer uid, Integer[] ids);


	//删除购物车项
	void deleteCartItem(Integer uid, Integer cartId);

	void deleteCartItems(Integer uid, Integer[] cartIds);
}






