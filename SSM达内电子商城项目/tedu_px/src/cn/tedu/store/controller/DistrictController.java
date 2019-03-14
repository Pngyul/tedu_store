package cn.tedu.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.District;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.DistrictService;



@Controller
@RequestMapping("/district")
public class DistrictController{
	
	@Autowired
	private DistrictService districtService;

	@RequestMapping("/list.do")
	@ResponseBody
	public ResponseResult<List<District>> getList(
		@RequestParam("parent") String parent) {
		// ��������ֵ����
		ResponseResult<List<District>> rr
			= new ResponseResult<List<District>>();
		// ����ҵ�������ȡ����
		List<District> districts
			= districtService.getList(parent);
		// ��װ��Ҫ��Ӧ������
		rr.setData(districts);
		// ִ�з���
		return rr;
	}
	
	@RequestMapping("/info.do")
	@ResponseBody
	public ResponseResult<District> getInfo(
		@RequestParam("code") String code) {
		// ��������ֵ����
		ResponseResult<District> rr
			= new ResponseResult<District>();
		// ����ҵ�������ȡ����
		District district
			= districtService.getInfo(code);
		// ��װ��Ҫ��Ӧ������
		rr.setData(district);
		// ִ�з���
		return rr;
	}
	
}







