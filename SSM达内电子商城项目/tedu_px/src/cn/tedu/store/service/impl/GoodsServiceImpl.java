package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.service.GoodsService;
import cn.tedu.store.service.ex.ServiceException;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	public List<Goods> getHotList(Long categoryId, Integer count) {
		return goodsMapper.getListByCategory(categoryId, 0, count);
	}

	public Goods getGoodsById(Long id) {
		return goodsMapper.getGoodsById(id);
	}

	@Override
	public List<Goods> getSearchList(String keyWord, Integer page) {
		// ���page��Ч����Ϊpage=1
		if (page == null || page < 1) {
			page = 1;
		}
		// ���page�������ޣ���Ϊ���һҳ
		Integer dataCount = getCountByKeyWord(keyWord);
		Integer maxPage = (int) Math.ceil(1. * dataCount / COUNT_PER_PAGE); // ����������ÿҳ������
		if (maxPage != 0 && page > maxPage) {
			page = maxPage;
		}
		// ִ��
		Integer offset = (page - 1) * COUNT_PER_PAGE;
		Integer count = COUNT_PER_PAGE;
		List<Goods> list = goodsMapper.getSearchList(keyWord, offset, count);
		if (list == null) {
			throw new ServiceException("û�и���Ʒ��");
		}
		return list;
	}

	private Integer getCountByKeyWord(String keyWord) {
		return goodsMapper.getCountByKeyWord(keyWord);
	}

	@Override
	public Integer getMaxPage(String keyWord) {
		Integer dataCount = getCountByKeyWord(keyWord);
		Integer maxPage = (int) Math.ceil(1. * dataCount / COUNT_PER_PAGE); // ����������ÿҳ������
		return maxPage;
	}

}
