package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Goods;


public interface GoodsService {
	
	Integer COUNT_PER_PAGE = 12;
	/**
	 * ��ȡ������Ʒ�б�
	 * @param categoryId ��Ʒ�����id
	 * @param count ��ȡ����Ʒ������
	 * @return ��Ʒ�б����û��ƥ������ݣ��򷵻���Ԫ�صļ���
	 */
	List<Goods> getHotList(Long categoryId, Integer count);
	
	/**
	 * ������Ʒid��ȡ��Ʒ����
	 * @param id ��Ʒid
	 * @return ��Ʒ���ݣ����û��ƥ������ݣ��򷵻�null
	 */
	Goods getGoodsById(Long id);

	//���ݹؼ���������Ʒ
	List<Goods> getSearchList(String keyWord, Integer page);

	Integer getMaxPage(String keyWord);
}





