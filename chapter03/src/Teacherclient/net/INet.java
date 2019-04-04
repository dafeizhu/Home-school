package Teacherclient.net;

import dto.ActionMessage;
import dto.HandleMessage;
import exception.NetException;

public interface INet {

	/**
	 * 发送动作信息给服务端
	 */
	public void send(ActionMessage am) throws NetException;
	/**
	 * 接收服务端的信息
	 */
	public HandleMessage receive() throws NetException;	
}
