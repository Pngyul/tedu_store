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
		// ҵ�񣺸���ʡ���С����Ĵ��ţ��õ����ǵ�����
		String recvDistrict = getRecvDistrict(address);
		address.setRecvDistrict(recvDistrict);
		// ҵ�񣺵�ǰ������ӵ��Ǹ��û��ĵ�1���ջ���ַ
		Integer count = getCountByUid(address.getUid());
		// if (count == 0) {
		// 	// �ǣ�����ΪĬ���ջ���ַ��address.setIsDefault(1);
		// 	address.setIsDefault(1);
		// } else {
		// 	// ������Ϊ��Ĭ���ջ���ַ��address.setIsDefault(0);
		// 	address.setIsDefault(0);
		// }
		address.setIsDefault(count == 0 ? 1: 0);
		// ִ��
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
		// �Ƚ����û��������ջ���ַ����Ϊ��Ĭ��
		setNonDefault(uid);
		// �ٽ����û���ָ�����ջ���ַ����ΪĬ��
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
		// �ж������ǲ��ǵ�ǰ�û��ģ�����ݲ���id��ѯ����
		Address address = getAddressById(id);
		// �ж��Ƿ��ѯ������
		if (address != null) {
			// �ǣ����ݴ��ڣ����жϲ���uid�Ͳ�ѯ����з�װ��uid�Ƿ���ͬ
			if (address.getUid().equals(uid)) {
				// �ǣ�ɾ�������Լ������ݣ�ִ��ɾ��
				delete(id);
				// �ж�ɾ�������ݵ�isDefault�Ƿ�Ϊ1
				if (address.getIsDefault() == 1) {
					// �ǣ�ɾ����Ĭ���ջ���ַ�����ѯ�����ӵ��ջ���ַ
					Address latestAddress = getLatestAddress(uid);
					// �ж��Ƿ��ѯ�����
					if (latestAddress != null) {
						// �ǣ���ȡ����id������setDefault(uid, id)
						setDefault(uid, latestAddress.getId());
					} else {
						// �񣺸ղ�ɾ�����Ѿ����һ������ֱ�ӽ���
					}
				} else {
					// �񣺽���
				}
			} else {
				// �񣺳���ɾ���Ĳ����Լ������ݣ�ArgumentException
				throw new ArgumentException(
					"��������");
			}
		} else {
			// �����ݲ����ڣ�AddressNotFoundException
			throw new AddressNotFoundException(
				"���Է��ʵ����ݲ����ڣ�");
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
	 * �����ջ���ַ����
	 * @param address �ջ���ַ����
	 * @throws InsertDataException
	 */
	private void insert(
		String currentUser, Address address) 
			throws InsertDataException {
		// �����־����
		Date now = new Date();
		address.setCreatedUser(currentUser);
		address.setCreatedTime(now);
		address.setModifiedUser(currentUser);
		address.setModifiedTime(now);
		// ִ��
		Integer rows = addressMapper.insert(address);
		// �ж��Ƿ����
		if (rows != 1) {
			throw new InsertDataException(
				"�����ջ���ַʱ����δ֪��������ϵϵͳ����Ա��");
		}
	}
	/**
	 * ��ĳ�û��������ջ���ַȫ������Ϊ��Ĭ���ջ���ַ
	 * @param uid �û�id
	 * @return ��Ӱ�������
	 */
	private Integer setNonDefault(Integer uid) {
		Integer rows = addressMapper.setNonDefault(uid);
		if (rows == 0) {
			throw new UpdateDataException(
				"�����ջ���ַ����ʱ����δ֪��������ϵϵͳ����Ա��");
		}
		return rows;
	}

	/**
	 * ��ĳ�û���ĳ���ջ���ַ����ΪĬ���ջ���ַ
	 * @param uid �û�id
	 * @param id �ջ���ַ���ݵ�id
	 * @return ��Ӱ�������
	 */
	private Integer setDefault(Integer uid, Integer id) {
		Integer rows = addressMapper.setDefault(uid, id);
		if (rows == 0) {
			throw new UpdateDataException(
				"���Ը����ջ���ַʧ�ܣ��û����ݲ�������");
		}
		return rows;
	}
	
	/**
	 * ��ȡʡ���С���������
	 * @param address ��װ��ʡ���С����Ĵ��ŵĶ���
	 * @return ʡ���С��������ƣ����磺�ӱ�ʡʯ��ׯ��������
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
			throw new AddressNotFoundException("������Ĭ�ϵ�ַ");
		}
		
		return address;
	}

}



