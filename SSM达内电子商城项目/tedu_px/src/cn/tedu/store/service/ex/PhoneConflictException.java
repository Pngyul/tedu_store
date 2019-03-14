package cn.tedu.store.service.ex;

public class PhoneConflictException
	extends ServiceException {

	private static final long serialVersionUID = -4106401894279090959L;

	public PhoneConflictException() {
		super();
	}

	public PhoneConflictException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public PhoneConflictException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public PhoneConflictException(String arg0) {
		super(arg0);
	}

	public PhoneConflictException(Throwable arg0) {
		super(arg0);
	}

}
