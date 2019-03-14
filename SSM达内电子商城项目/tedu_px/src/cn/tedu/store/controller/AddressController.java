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
		// 从Session中获取当前登录的用户的用户名
		String currentUser = ((User)session.getAttribute("user")).getUser_name();

	    // 从Session中获取当前登录的用户的id
		Integer uid = getUidFromSession(session);
	    // 将用户id封装到参数address对象
		address.setUid(uid);

		// 调用业务层对象的addnew(String currentUser, Address address)
		addressService.addnew(currentUser, address);

	    // 返回ResponseResult对象
		return new ResponseResult<Void>();
	}
	
	@RequestMapping("/list.do")
	@ResponseBody
	public ResponseResult<List<Address>> getList(
	    HttpSession session) {
	    // 获取uid
		Integer uid = getUidFromSession(session);
	    // 调用业务层方法获取列表
		List<Address> addresses
			= addressService.getList(uid);
	    // 创建返回值对象
		ResponseResult<List<Address>> rr
			= new ResponseResult<List<Address>>();
	    // 将列表封装到返回值对象中
		rr.setData(addresses);
	    // 执行返回
		return rr;
	}
	
	@RequestMapping("/set_default.do")
	@ResponseBody
	public ResponseResult<Void> setDefault(
		HttpSession session,
		@RequestParam("id") Integer id) {
		// 从session中获取uid
		Integer uid = getUidFromSession(session);
		// 调用业务层对象的setDefaultAddress(uid, id)方法
		addressService.setDefaultAddress(uid, id);
		// 创建返回值对象并返回
		return new ResponseResult<Void>();
	}

	@RequestMapping("/delete.do")
	@ResponseBody
	public ResponseResult<Void> delete(
		HttpSession session,
		@RequestParam("id") Integer id) {
		// 从session中获取uid
		Integer uid = getUidFromSession(session);
		// 调用业务层对象的deleteById(uid, id)方法
		addressService.deleteById(uid, id);
		// 创建返回值对象并返回
		return new ResponseResult<Void>();
	}
	
/*	@RequestMapping("/getDefaultAddress.do")
	public String getDefaultAddress(
		HttpSession session,
		@RequestParam("id") Integer id) {
		// 从session中获取uid
		Integer uid = getUidFromSession(session);
		// 调用业务层对象的deleteById(uid, id)方法
		Integer addressId = addressService.getdefaultAddress(uid);
		// 创建返回值对象并返回
		return "forward:../order/create.do?cart_id="+;
	}*/
	
}







