package cn.tedu.store.service.ex;

public class InsertDataException 
	extends ServiceException {

	private static final long serialVersionUID = -7724774432291553025L;

	public InsertDataException() {
		super();
	}

	public InsertDataException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public InsertDataException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InsertDataException(String arg0) {
		super(arg0);
	}

	public InsertDataException(Throwable arg0) {
		super(arg0);
	}

}
