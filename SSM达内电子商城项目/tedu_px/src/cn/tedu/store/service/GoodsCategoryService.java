package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.GoodsCategory;


public interface GoodsCategoryService {

	/**
	 * ���ݸ������࣬��ȡ�����б�
	 * @param parentId ���������id�������Ҫ��ȡһ�����࣬�򸸼�����Ϊ0
	 * @return �Ӽ������б�
	 */
	List<GoodsCategory> getListByParent(Long parentId);
	
}
