package cn.tedu.store.service.ex;

public class DeleteDataException 
	extends ServiceException {

	private static final long serialVersionUID = -6297255064668856332L;

	public DeleteDataException() {
		super();
	}

	public DeleteDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DeleteDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public DeleteDataException(String message) {
		super(message);
	}

	public DeleteDataException(Throwable cause) {
		super(cause);
	}

}
