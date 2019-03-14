package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.ex.AddressNotFoundException;
import cn.tedu.store.service.ex.ArgumentException;
import cn.tedu.store.service.ex.DeleteDataException;
import cn.tedu.store.service.ex.EmailConflictException;
import cn.tedu.store.service.ex.InsertDataException;
import cn.tedu.store.service.ex.OrderNotFoundException2;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.PhoneConflictException;
import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.service.ex.UpdateDataException;
import cn.tedu.store.service.ex.UploadAvatarException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameConflictException;

public abstract class BaseController {

	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	public ResponseResult<Void> handleException(Exception e) {
		// �ж��쳣������
		if (e instanceof UsernameConflictException) {
			// �û�����ͻ������ע��ʱ���û����Ѿ���ռ��
			return new ResponseResult<Void>(401, e);
		} else if (e instanceof EmailConflictException) {
			// �����ͻ������ע��ʱ�������Ѿ���ռ��
			return new ResponseResult<Void>(401, e);
		} else if (e instanceof PhoneConflictException) {
			// �ֻ��ų�ͻ������ע��ʱ���ֻ����Ѿ���ռ��
			return new ResponseResult<Void>(401, e);
		} else if (e instanceof UserNotFoundException) {
			// ���Է��ʵ��û����ݲ�����
			return new ResponseResult<Void>(402, e);
		} else if (e instanceof PasswordNotMatchException) {
			// ��֤����ʱ�����벻ƥ��
			return new ResponseResult<Void>(403, e);
		} else if (e instanceof UploadAvatarException) {
			// �ϴ�ͷ��ʱ�쳣
			return new ResponseResult<Void>(408, e);
		} else if (e instanceof AddressNotFoundException) {
			// �Ҳ����ջ���ַ����ʱ�쳣
			return new ResponseResult<Void>(409, e);
		} else if (e instanceof ArgumentException) {
			// �����쳣
			return new ResponseResult<Void>(410, e);
		} else if (e instanceof InsertDataException) {
			// ��������ʱ�쳣��ԭ��δ֪
			return new ResponseResult<Void>(501, e);
		} else if (e instanceof UpdateDataException) {
			// �޸�����ʱ�쳣��ԭ��δ֪
			return new ResponseResult<Void>(502, e);
		}  else if (e instanceof DeleteDataException) {
			// ɾ������ʱ�쳣��ԭ��δ֪
			return new ResponseResult<Void>(503, e);
		}  else if (e instanceof OrderNotFoundException2) {
			// ɾ������ʱ�쳣��ԭ��δ֪
			return new ResponseResult<Void>(402, e);
		}  else {
			// ����������©û�д�����쳣
			return new ResponseResult<Void>(600, e);
		}
	}
	
	/**
	 * ��Session�л�ȡ��ǰ��¼���û���id
	 * @param session
	 * @return ��ǰ��¼���û���id
	 */
	protected final Integer getUidFromSession(
			HttpSession session) {
		return Integer.valueOf(
			((User)session.getAttribute("user")).getUser_id());
	}
	
}









