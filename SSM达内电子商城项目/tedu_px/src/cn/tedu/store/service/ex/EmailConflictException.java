package cn.tedu.store.service.ex;

public class EmailConflictException
	extends ServiceException {

	private static final long serialVersionUID = -4106401894279090959L;

	public EmailConflictException() {
		super();
	}

	public EmailConflictException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public EmailConflictException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EmailConflictException(String arg0) {
		super(arg0);
	}

	public EmailConflictException(Throwable arg0) {
		super(arg0);
	}

}
