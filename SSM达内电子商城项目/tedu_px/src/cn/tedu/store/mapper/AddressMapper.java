package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Address;


public interface AddressMapper {

	/**
	 * �����ջ���ַ����
	 * @param address �ջ���ַ����
	 * @return ��Ӱ�������
	 */
	Integer insert(Address address);
	
	/**
	 * ���ݵ�ǰ�û�id����ѯ���û����ջ���ַ������
	 * @param uid ��ǰ�û�id
	 * @return ���û����ջ���ַ������
	 */
	Integer getCountByUid(Integer uid);
	
	/**
	 * ��ȡĳ�û����ջ���ַ�б�
	 * @param uid �û���id
	 * @return �ջ���ַ�б�
	 */
	List<Address> getList(Integer uid);
	
	/**
	 * ����id��ѯ�ջ���ַ����
	 * @param id ����id
	 * @return ƥ����ջ���ַ���ݣ����û��ƥ������ݣ��򷵻�null
	 */
	Address getAddressById(Integer id);
	
	/**
	 * ��ȡ�����ӵ��ջ���ַ����
	 * @param uid �û�id
	 * @return �ջ���ַ���ݣ����û��ƥ������ݣ��򷵻�null
	 */
	Address getLatestAddress(Integer uid);
	
	/**
	 * ��ĳ�û��������ջ���ַȫ������Ϊ��Ĭ���ջ���ַ
	 * @param uid �û�id
	 * @return ��Ӱ�������
	 */
	Integer setNonDefault(Integer uid);

	/**
	 * ��ĳ�û���ĳ���ջ���ַ����ΪĬ���ջ���ַ
	 * @param uid �û�id
	 * @param id �ջ���ַ���ݵ�id
	 * @return ��Ӱ�������
	 */
	Integer setDefault(
		@Param("uid") Integer uid, 
		@Param("id") Integer id);
	
	/**
	 * ɾ���ջ���ַ����
	 * @param id �ջ���ַ���ݵ�id
	 * @return ��Ӱ�������
	 */
	Integer delete(Integer id);
	
	//��ȡĬ���ջ���ַ
	Address getdefaultAddress(Integer uid);
	
}










