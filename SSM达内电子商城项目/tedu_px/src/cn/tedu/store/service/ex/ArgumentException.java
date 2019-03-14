package cn.tedu.store.service.ex;

public class ArgumentException 
	extends ServiceException {

	private static final long serialVersionUID = 2140480350438745031L;

	public ArgumentException() {
		super();
	}

	public ArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ArgumentException(String message, Throwable cause) {
		super(message, cause);
	}

	public ArgumentException(String message) {
		super(message);
	}

	public ArgumentException(Throwable cause) {
		super(cause);
	}

}
