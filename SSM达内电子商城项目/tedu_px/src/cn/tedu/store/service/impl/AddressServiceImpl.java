package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.District;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.DistrictService;
import cn.tedu.store.service.AddressService;
import cn.tedu.store.service.ex.AddressNotFoundException;
import cn.tedu.store.service.ex.ArgumentException;
import cn.tedu.store.service.ex.InsertDataException;
import cn.tedu.store.service.ex.UpdateDataException;

@Service("addressService")
@Transactional
public class AddressServiceImpl 
	implements AddressService {
	
	@Autowired
	private AddressMapper addressMapper;
	@Autowired
	private DistrictService districtService;

	public Address addnew(
		String currentUser, Address address) 
			throws InsertDataException {
		// 业务：根据省、市、区的代号，得到它们的名称
		String recvDistrict = getRecvDistrict(address);
		address.setRecvDistrict(recvDistrict);
		// 业务：当前尝试添加的是该用户的第1条收货地址
		Integer count = getCountByUid(address.getUid());
		// if (count == 0) {
		// 	// 是：设置为默认收货地址：address.setIsDefault(1);
		// 	address.setIsDefault(1);
		// } else {
		// 	// 否：设置为非默认收货地址：address.setIsDefault(0);
		// 	address.setIsDefault(0);
		// }
		address.setIsDefault(count == 0 ? 1: 0);
		// 执行
		insert(currentUser, address);
		return address;
	}
	
	public Integer getCountByUid(Integer uid) {
		return addressMapper.getCountByUid(uid);
	}
	
	public List<Address> getList(Integer uid) {
		return addressMapper.getList(uid);
	}
	
	@Transactional
	public void setDefaultAddress(Integer uid, Integer id) {
		// 先将该用户的所有收货地址设置为非默认
		setNonDefault(uid);
		// 再将该用户的指定的收货地址设置为默认
		setDefault(uid, id);
	}

	public Address getAddressById(Integer id) {
		return addressMapper.getAddressById(id);
	}
	
	public Address getLatestAddress(Integer uid) {
		return addressMapper.getLatestAddress(uid);
	}

	@Transactional
	public void deleteById(Integer uid, Integer id) 
		throws AddressNotFoundException, 
			ArgumentException, UpdateDataException {
		// 判断数据是不是当前用户的，则根据参数id查询数据
		Address address = getAddressById(id);
		// 判断是否查询到数据
		if (address != null) {
			// 是：数据存在，则判断参数uid和查询结果中封装的uid是否相同
			if (address.getUid().equals(uid)) {
				// 是：删除的是自己的数据，执行删除
				delete(id);
				// 判断删除的数据的isDefault是否为1
				if (address.getIsDefault() == 1) {
					// 是：删除了默认收货地址，则查询最后添加的收货地址
					Address latestAddress = getLatestAddress(uid);
					// 判断是否查询到结果
					if (latestAddress != null) {
						// 是：获取数据id，调用setDefault(uid, id)
						setDefault(uid, latestAddress.getId());
					} else {
						// 否：刚才删除的已经最后一条，则直接结束
					}
				} else {
					// 否：结束
				}
			} else {
				// 否：尝试删除的不是自己的数据：ArgumentException
				throw new ArgumentException(
					"参数错误！");
			}
		} else {
			// 否：数据不存在，AddressNotFoundException
			throw new AddressNotFoundException(
				"尝试访问的数据不存在！");
		}
	}
	
	private Integer delete(Integer id) {
		Integer rows = addressMapper.delete(id);
		if (rows != 1) {
			throw new AddressNotFoundException();
		}
		return 1;
	}
	
	/**
	 * 插入收货地址数据
	 * @param address 收货地址数据
	 * @throws InsertDataException
	 */
	private void insert(
		String currentUser, Address address) 
			throws InsertDataException {
		// 添加日志数据
		Date now = new Date();
		address.setCreatedUser(currentUser);
		address.setCreatedTime(now);
		address.setModifiedUser(currentUser);
		address.setModifiedTime(now);
		// 执行
		Integer rows = addressMapper.insert(address);
		// 判断是否出错
		if (rows != 1) {
			throw new InsertDataException(
				"增加收货地址时出现未知错误！请联系系统管理员！");
		}
	}
	/**
	 * 将某用户的所有收货地址全部设置为非默认收货地址
	 * @param uid 用户id
	 * @return 受影响的行数
	 */
	private Integer setNonDefault(Integer uid) {
		Integer rows = addressMapper.setNonDefault(uid);
		if (rows == 0) {
			throw new UpdateDataException(
				"更新收货地址数据时发生未知错误！请联系系统管理员！");
		}
		return rows;
	}

	/**
	 * 将某用户的某条收货地址设置为默认收货地址
	 * @param uid 用户id
	 * @param id 收货地址数据的id
	 * @return 受影响的行数
	 */
	private Integer setDefault(Integer uid, Integer id) {
		Integer rows = addressMapper.setDefault(uid, id);
		if (rows == 0) {
			throw new UpdateDataException(
				"尝试更新收货地址失败，用户数据参数错误！");
		}
		return rows;
	}
	
	/**
	 * 获取省、市、区的名称
	 * @param address 封装了省、市、区的代号的对象
	 * @return 省、市、区的名称，例如：河北省石家庄市桥西区
	 */
	private String getRecvDistrict(Address address) {
		District province 
			= districtService.getInfo(
					address.getRecvProvince());
		District city 
			= districtService.getInfo(
				address.getRecvCity());
		District area 
			= districtService.getInfo(
				address.getRecvArea());
		String recvDistrict
			= province.getName() 
				+ city.getName() 
				+ area.getName();
		return recvDistrict;
	}

	@Override
	public Address getdefaultAddress(Integer uid) {
		Address address = addressMapper.getdefaultAddress(uid);
		if(address == null){
			throw new AddressNotFoundException("不存在默认地址");
		}
		
		return address;
	}

}



