package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Collection;
import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.CollectMapper;
import cn.tedu.store.service.CollectService;
import cn.tedu.store.service.ex.DeleteDataException;
import cn.tedu.store.service.ex.InsertDataException;
import cn.tedu.store.vo.CollectionVO;

@Service("collectService")
@Transactional
public class CollectServiceImpl implements CollectService{

	@Autowired
	CollectMapper collectMapper;
	
	@Override
	public void addToCollect(User user, String goodsId) {
		Collection collect = new Collection();
		collect.setCreatedTime(new Date());
		collect.setCreatedUser(user.getUser_name());
		collect.setGoodsId(goodsId);
		collect.setUid(user.getUser_id());
		insert(collect);
	}
	
	void insert(Collection collect){
		Integer row = collectMapper.insert(collect);
		if(row<1){
			throw new InsertDataException("添加收藏失败，原因未知");
		}
	}

	@Override
	public List<CollectionVO> getList(Integer uid) {
		
		return collectMapper.getList(uid);
	}

	@Override
	public void deleteCollectItems(Integer uid, Long[] ids) {
		Integer rows = collectMapper.delete(uid,ids);
		if(rows<1){
			throw new DeleteDataException("删除失败，原因未知！");
		}
	}

}
