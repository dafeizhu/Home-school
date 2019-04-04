package dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class HandleMessage implements Serializable {

	   /**
	 * 
	 */
	private static final long serialVersionUID = -3833175508979325366L;
	private boolean success;
	    private String message;
	    private Map<String,Object> data = new HashMap<String,Object>();
		public boolean isSuccess() {
			return success;
		}
		public void setSuccess(boolean success) {
			this.success = success;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public Map<String, Object> getData() {
			return data;
		}
		public void setData(Map<String, Object> data) {
			this.data = data;
		}
	}

