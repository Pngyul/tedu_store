package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/main")
public class MainController {
	
	/**
	 * չʾ��ҳ
	 * @return
	 */
	@RequestMapping("/showIndex.do")
	public String showIndex(){
		return "index";
	}
	
	/**
	 * �˳���¼
	 * @return
	 */
	@RequestMapping("/exit.do")
	public String exit(HttpSession session){
		session.invalidate();
		return "login";
	}

}
