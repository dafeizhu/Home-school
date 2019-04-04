package dto;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

public class ActionMessage implements Serializable {


	private static final long serialVersionUID = -1240510897217877257L;


    private ClientEnum client;
    private ActionEnum action;
    private Map<String,Object> data = new HashMap<String,Object>();
    private InetAddress clientIP;
	public ClientEnum getClient() {
		return client;
	}
	public void setClient(ClientEnum client) {
		this.client = client;
	}
	public ActionEnum getAction() {
		return action;
	}
	public void setAction(ActionEnum action) {
		this.action = action;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	public InetAddress getClientIP() {
		return clientIP;
	}
	public void setClientIP(InetAddress clientIP) {
		this.clientIP = clientIP;
	}
}




