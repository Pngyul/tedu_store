package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;


public interface CartMapper {
	
	/**
	 * 增加新的购物车数据
	 * @param cart 购物车数据
	 * @return 受影响的行数
	 */
	Integer insert(Cart cart);
	
	/**
	 * 根据用户和商品id查询购物车中的数据量
	 * @param uid 用户id
	 * @param goodsId 商品id
	 * @return 匹配的数据的数量
	 */
	Integer getCountByUidAndGoodsId(
			@Param("uid") Integer uid,
			@Param("goodsId") Long goodsId);
	
	/**
	 * 修改购物车中商品的数量
	 * @param num 增量
	 * @param uid 用户id
	 * @param goodsId 商品id
	 * @return 受影响的行数
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
	 * 获取购物车数据列表
	 * @param uid 用户id
	 * @param offset 跳过多少条数据
	 * @param count 获取多少条数据
	 * @return 购物车数据列表
	 */
	List<Cart> getList(
			@Param("uid") Integer uid, 
			@Param("offset") Integer offset, 
			@Param("count") Integer count);
	
	/**
	 * 获取某用户的购物车数据的数量
	 * @param uid 用户的id
	 * @return 用户的购物车数据的数量
	 */
	Integer getCountByUid(Integer uid);
	
	/**
	 * 根据多个数据id获取购物车中的数据的列表
	 * @param uid 数据归属的用户的id
	 * @param ids 需要查询的数据的id的数组
	 * @return 匹配的数据，如果没有匹配的数据，则返回无元素的集合
	 */
	List<Cart> getListByIds(
			@Param("uid") Integer uid, 
			@Param("ids") Integer[] ids);


	//删除购物项
	Integer deleteCartItem(
			@Param("uid")Integer uid,
			@Param("id")Integer id);
	
	Integer deleteCartItems(
			@Param("uid")Integer uid,
			@Param("ids")Integer[] ids);
	
}









