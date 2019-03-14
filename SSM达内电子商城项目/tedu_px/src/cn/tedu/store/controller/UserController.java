package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@Resource
	private UserService userService;

	/**
	 * 展示注册
	 * 
	 * @return
	 */
	@RequestMapping("/showRegister.do")
	public String showRegister() {
		return "register";
	}

	/**
	 * 展示登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		return "login";
	}

	@RequestMapping("/showPersonalPage.do")
	public String showPersonalPage() {
		return "personage";
	}

	@RequestMapping("/showPersonal_password.do")
	public String showPersonal_password() {
		return "personal_password";
	}

	/**
	 * 通过用户名判断该用户是否存在
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping("/checkUserName.do")
	@ResponseBody
	public ResponseResult<Void> checkUserName(String userName) {

		userService.checkUserByUserName(userName);

		return new ResponseResult<Void>("该用户名可以使用");
	}

	/**
	 * 判断该 email 是否已经被使用
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping("/checkUserEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkUserEmail(String userEmail) {

		userService.checkUserByUserEmail(userEmail);

		return new ResponseResult<Void>("该邮箱可以使用");
	}

	/**
	 * 判断该手机号是否被使用
	 * 
	 * @param userPhone
	 * @return
	 */
	@RequestMapping("/checkUserPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkUserPhone(String userPhone) {

		userService.checkUserByUserPhone(userPhone);

		return new ResponseResult<Void>("该手机号可以使用");
	}

	/**
	 * 注册用户
	 * 
	 * @return
	 */
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> Register(User user) {
		user.setCreated_user(user.getUser_name());
		user.setUser_image("/upload/001.jpg");
		user.setModified_user(user.getUser_name());
		user.setCreated_time(new Date());
		user.setModified_time(new Date());
		userService.register(user);
		return new ResponseResult<Void>("注册成功,请登录!");
	}

	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String lname, String lpwd, HttpSession session) {
		User user = userService.login(lname, lpwd);
		session.setAttribute("user", user);
		return new ResponseResult<Void>("登录成功");
	}

	@RequestMapping("/updatePassword.do")
	@ResponseBody
	public ResponseResult<Void> updatePassword(HttpSession session, String oldPwd, String newPwd) {

		User user = (User) session.getAttribute("user");
		Integer id = null;
		if (user != null) {
			id = user.getUser_id();
		}
		userService.changePassword(id, oldPwd, newPwd);
		return new ResponseResult<Void>("修改成功，请重新登录！");
	}

	@RequestMapping("/upload.do")
	@ResponseBody
	public ResponseResult<String> upload(@RequestParam(name = "file") MultipartFile file, HttpSession session)
			throws IllegalStateException, IOException {
		ResponseResult<String> rr = new ResponseResult<String>();
		// 确定头像文件的扩展名
		int beginIndex = file.getOriginalFilename().lastIndexOf(".");
		String suffix = file.getOriginalFilename().substring(beginIndex);
		// 确定头像文件的文件名，必须唯一
		String fileName = UUID.randomUUID()+ suffix;
		// 文件上传
		String target = "D:/apache-tomcat-8.0.50/webapps/upload/" + fileName;
		file.transferTo(new File(target));
		rr.setData("/upload/" + fileName);
		rr.setMessage("上传成功！");
		return rr;

	}
	
	@RequestMapping("/changeInfo.do")
	@ResponseBody
	public ResponseResult<Void> changeInfo(
		User user, HttpSession session) {
		
		ResponseResult<Void> rr = new ResponseResult<Void>();
		User u = (User) session.getAttribute("user");
		user.setUser_id(u.getUser_id());
		/*//如果没有上传图片，赋值null,不更新
		System.out.println(user.getUser_image().equals(""));
		if(user.getUser_image().equals("")){
			user.setUser_image(null);
		}*/
		User user2 = userService.changePersonalInfo(user);
		session.setAttribute("user", user2);
		
		rr.setMessage("修改成功！");
		return rr;
	}
}
