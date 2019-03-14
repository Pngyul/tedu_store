package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;


public interface GoodsMapper {

	/**
	 * 获取某分类下的商品列表
	 * @param categoryId 商品分类的id
	 * @param offset 偏移量，即跳过多少条数据
	 * @param count 需要获取的数据的数量
	 * @return 商品列表，如果没有匹配的数据，则返回无元素的集合
	 */
	List<Goods> getListByCategory(
		    @Param("categoryId") Long categoryId, 
		    @Param("offset") Integer offset, 
		    @Param("count") Integer count);
	
	/**
	 * 根据商品id获取商品数据
	 * @param id 商品id
	 * @return 商品数据，如果没有匹配的数据，则返回null
	 */
	Goods getGoodsById(Long id);

	List<Goods> getSearchList(@Param("keyWord")String keyWord);

	Integer getCountByKeyWord(@Param("keyWord")String keyWord);

	List<Goods> getSearchList(@Param("keyWord")String keyWord, 
							  @Param("offset")Integer offset, 
							  @Param("count")Integer count);
	
}






