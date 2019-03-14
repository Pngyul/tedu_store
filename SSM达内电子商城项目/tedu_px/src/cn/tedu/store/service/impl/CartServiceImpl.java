package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.Goods;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.service.CartService;
import cn.tedu.store.service.GoodsService;
import cn.tedu.store.service.ex.DeleteDataException;
import cn.tedu.store.service.ex.InsertDataException;
import cn.tedu.store.service.ex.UpdateDataException;

@Service("cartService")
public class CartServiceImpl implements CartService {
	
	@Autowired private CartMapper cartMapper;
	@Autowired private GoodsService goodsService;

	public void addToCart(Cart cart) {
		// 先判断购物车是否已经存在相关数据
		Integer uid = cart.getUid();
		Long goodsId = cart.getGoodsId();
		Integer count
			= getCountByUidAndGoodsId(uid, goodsId);
		if (count == 0) { 
			// 结果==0：没有数据：则新增
			// 调用insert()完成增加
			insert(cart);
		} else {
			// 结果!=0：有数据：则修改数量
			// -- 调用changeGoodsNum()完成修改
			Integer num = cart.getGoodsNum();
			changeGoodsNum(num, uid, goodsId);
		}
	}

	public Integer getCountByUidAndGoodsId(Integer uid, Long goodsId) {
		return cartMapper.getCountByUidAndGoodsId(uid, goodsId);
	}

	public void changeGoodsNum(Integer num, Integer uid, Long goodsId) {
		Integer rows = cartMapper.changeGoodsNum(
				num, uid, goodsId);
		if (rows != 1) {
			throw new UpdateDataException("还没想好怎么描述……");
		}
	}

	public List<Cart> getList(Integer uid, Integer page) {
		// 如果page无效，视为page=1
		if (page == null || page < 1) {
			page = 1;
		}
		// 如果page超出上限，视为最后一页
		Integer dataCount = getCountByUid(uid);
		Integer maxPage = (int) Math.ceil(1. * dataCount / COUNT_PER_PAGE); // 总数据量，每页数据量
		if (maxPage!=0 && page > maxPage) {
			page = maxPage;
		}
		// 执行
		Integer offset = (page - 1) * COUNT_PER_PAGE;
		Integer count = COUNT_PER_PAGE;
		return cartMapper.getList(uid, offset, count);
	}

	public Integer getCountByUid(Integer uid) {
		return cartMapper.getCountByUid(uid);
	}

	public Integer getMaxPage(Integer uid) {
		Integer dataCount = getCountByUid(uid);
		Integer maxPage = (int) Math.ceil(1. * dataCount / COUNT_PER_PAGE); // 总数据量，每页数据量
		return maxPage;
	}

	public List<Cart> getListByIds(Integer uid, Integer[] ids) {
		return cartMapper.getListByIds(uid, ids);
	}
	
	/**
	 * 向数据表中添加新的购物车数据
	 * @param cart 购物车数据
	 * @return 新增加的购物车数据，包括数据id
	 */
	private Cart insert(Cart cart) {
		// 查询商品的详细数据
		Goods goods
			= goodsService
				.getGoodsById(cart.getGoodsId());
		
		
		// 封装必要的数据
		cart.setGoodsImage(goods.getImage());
		cart.setGoodsPrice(goods.getPrice());
		cart.setGoodsTitle(goods.getTitle());
		// 执行插入数据
		Integer rows = cartMapper.insert(cart);
		// 验证操作结果
		if (rows != 1) {
			throw new InsertDataException("还没想好说什么！");
		}
		return cart;
	}
	public void changeCartNum(Integer num, Integer uid, Long goodsId) {
		Integer rows = cartMapper.changeCartNum(
				num, uid, goodsId);
		if (rows != 1) {
			throw new UpdateDataException("还没想好怎么描述……");
		}
	}

	@Override
	public void deleteCartItem(Integer uid, Integer cartId) {
		Integer rows = cartMapper.deleteCartItem(uid,cartId);
		if(rows != 1){
			throw new DeleteDataException("删除失败，原因未知！");
		}
	}

	@Override
	public void deleteCartItems(Integer uid, Integer[] cartIds) {
		Integer rows = cartMapper.deleteCartItems(uid,cartIds);
		if(rows < 1){
			throw new DeleteDataException("删除失败，原因未知！");
		}
	}
}










