package exception;

/**
 * ¥¶¿ÌÕ¯¬Á“Ï≥£
 */
public class NetException extends Exception {
	
	public NetException() {
		super();
	}
	public NetException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public NetException(String message, Throwable cause) {
		super(message, cause);
	}
	public NetException(String message) {
		super(message);
	}
	public NetException(Throwable cause) {
		super(cause);
	}
}