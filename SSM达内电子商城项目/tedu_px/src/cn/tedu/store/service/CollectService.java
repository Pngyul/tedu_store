package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Collection;
import cn.tedu.store.bean.User;
import cn.tedu.store.vo.CollectionVO;

public interface CollectService {

	void addToCollect(User user, String goodsId);

	List<CollectionVO> getList(Integer uid);

	void deleteCollectItems(Integer uid, Long[] ids);

}
