package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Collection;
import cn.tedu.store.vo.CollectionVO;

public interface CollectMapper {

	//≤Â»Î ’≤ÿ
	Integer insert(Collection collect);

	List<CollectionVO> getList(@Param("uid")Integer uid);

	Integer delete(@Param("uid")Integer uid, 
				   @Param("ids")Long[] ids);

}
