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
		// ���жϹ��ﳵ�Ƿ��Ѿ������������
		Integer uid = cart.getUid();
		Long goodsId = cart.getGoodsId();
		Integer count
			= getCountByUidAndGoodsId(uid, goodsId);
		if (count == 0) { 
			// ���==0��û�����ݣ�������
			// ����insert()�������
			insert(cart);
		} else {
			// ���!=0�������ݣ����޸�����
			// -- ����changeGoodsNum()����޸�
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
			throw new UpdateDataException("��û�����ô��������");
		}
	}

	public List<Cart> getList(Integer uid, Integer page) {
		// ���page��Ч����Ϊpage=1
		if (page == null || page < 1) {
			page = 1;
		}
		// ���page�������ޣ���Ϊ���һҳ
		Integer dataCount = getCountByUid(uid);
		Integer maxPage = (int) Math.ceil(1. * dataCount / COUNT_PER_PAGE); // ����������ÿҳ������
		if (maxPage!=0 && page > maxPage) {
			page = maxPage;
		}
		// ִ��
		Integer offset = (page - 1) * COUNT_PER_PAGE;
		Integer count = COUNT_PER_PAGE;
		return cartMapper.getList(uid, offset, count);
	}

	public Integer getCountByUid(Integer uid) {
		return cartMapper.getCountByUid(uid);
	}

	public Integer getMaxPage(Integer uid) {
		Integer dataCount = getCountByUid(uid);
		Integer maxPage = (int) Math.ceil(1. * dataCount / COUNT_PER_PAGE); // ����������ÿҳ������
		return maxPage;
	}

	public List<Cart> getListByIds(Integer uid, Integer[] ids) {
		return cartMapper.getListByIds(uid, ids);
	}
	
	/**
	 * �����ݱ�������µĹ��ﳵ����
	 * @param cart ���ﳵ����
	 * @return �����ӵĹ��ﳵ���ݣ���������id
	 */
	private Cart insert(Cart cart) {
		// ��ѯ��Ʒ����ϸ����
		Goods goods
			= goodsService
				.getGoodsById(cart.getGoodsId());
		
		
		// ��װ��Ҫ������
		cart.setGoodsImage(goods.getImage());
		cart.setGoodsPrice(goods.getPrice());
		cart.setGoodsTitle(goods.getTitle());
		// ִ�в�������
		Integer rows = cartMapper.insert(cart);
		// ��֤�������
		if (rows != 1) {
			throw new InsertDataException("��û���˵ʲô��");
		}
		return cart;
	}
	public void changeCartNum(Integer num, Integer uid, Long goodsId) {
		Integer rows = cartMapper.changeCartNum(
				num, uid, goodsId);
		if (rows != 1) {
			throw new UpdateDataException("��û�����ô��������");
		}
	}

	@Override
	public void deleteCartItem(Integer uid, Integer cartId) {
		Integer rows = cartMapper.deleteCartItem(uid,cartId);
		if(rows != 1){
			throw new DeleteDataException("ɾ��ʧ�ܣ�ԭ��δ֪��");
		}
	}

	@Override
	public void deleteCartItems(Integer uid, Integer[] cartIds) {
		Integer rows = cartMapper.deleteCartItems(uid,cartIds);
		if(rows < 1){
			throw new DeleteDataException("ɾ��ʧ�ܣ�ԭ��δ֪��");
		}
	}
}










