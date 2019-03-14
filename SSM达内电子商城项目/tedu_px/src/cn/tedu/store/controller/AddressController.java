package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.AddressService;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController {
	
	@Autowired
	private AddressService addressService;
	
	
	@RequestMapping("/showAddressAdmin.do")
	public String showAddressAdmin() {
		return "addressAdmin";
	}
	
	@RequestMapping(value="/handle_addnew.do",
		method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleAddnew(
			Address address, HttpSession session) {
		// ��Session�л�ȡ��ǰ��¼���û����û���
		String currentUser = ((User)session.getAttribute("user")).getUser_name();

	    // ��Session�л�ȡ��ǰ��¼���û���id
		Integer uid = getUidFromSession(session);
	    // ���û�id��װ������address����
		address.setUid(uid);

		// ����ҵ�������addnew(String currentUser, Address address)
		addressService.addnew(currentUser, address);

	    // ����ResponseResult����
		return new ResponseResult<Void>();
	}
	
	@RequestMapping("/list.do")
	@ResponseBody
	public ResponseResult<List<Address>> getList(
	    HttpSession session) {
	    // ��ȡuid
		Integer uid = getUidFromSession(session);
	    // ����ҵ��㷽����ȡ�б�
		List<Address> addresses
			= addressService.getList(uid);
	    // ��������ֵ����
		ResponseResult<List<Address>> rr
			= new ResponseResult<List<Address>>();
	    // ���б��װ������ֵ������
		rr.setData(addresses);
	    // ִ�з���
		return rr;
	}
	
	@RequestMapping("/set_default.do")
	@ResponseBody
	public ResponseResult<Void> setDefault(
		HttpSession session,
		@RequestParam("id") Integer id) {
		// ��session�л�ȡuid
		Integer uid = getUidFromSession(session);
		// ����ҵ�������setDefaultAddress(uid, id)����
		addressService.setDefaultAddress(uid, id);
		// ��������ֵ���󲢷���
		return new ResponseResult<Void>();
	}

	@RequestMapping("/delete.do")
	@ResponseBody
	public ResponseResult<Void> delete(
		HttpSession session,
		@RequestParam("id") Integer id) {
		// ��session�л�ȡuid
		Integer uid = getUidFromSession(session);
		// ����ҵ�������deleteById(uid, id)����
		addressService.deleteById(uid, id);
		// ��������ֵ���󲢷���
		return new ResponseResult<Void>();
	}
	
/*	@RequestMapping("/getDefaultAddress.do")
	public String getDefaultAddress(
		HttpSession session,
		@RequestParam("id") Integer id) {
		// ��session�л�ȡuid
		Integer uid = getUidFromSession(session);
		// ����ҵ�������deleteById(uid, id)����
		Integer addressId = addressService.getdefaultAddress(uid);
		// ��������ֵ���󲢷���
		return "forward:../order/create.do?cart_id="+;
	}*/
	
}







