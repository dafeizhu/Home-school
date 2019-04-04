package Server.exception;
/**
 * 启动服务器异常
 */
public class StartException extends Exception {

	public StartException() {
		super();
	}
	public StartException(String message, Throwable cause, 
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public StartException(String message, Throwable cause) {
		super(message, cause);
	}
	public StartException(String message) {
		super(message);
	}
	public StartException(Throwable cause) {
		super(cause);
	}
	
}