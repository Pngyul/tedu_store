package cn.tedu.store.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginIntercepter implements HandlerInterceptor{

	//��ͼ����֮��
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	//��controller����ִ��֮����ͼ����֮ǰ
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	//��controller����ִ��֮ǰ
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		HttpSession session = request.getSession();
		Object obj1 = session.getAttribute("user");
		if(obj1 !=null){
			return true;
		}else{
			String url = request.getContextPath()+"/user/showLogin.do";
			
			response.sendRedirect(url);
			
			return false;
		}
		
	}

}
