package Teacherclient.net;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import dto.ActionMessage;
import dto.HandleMessage;
import exception.NetException;
import util.Config;


public class NetImpl implements INet {

    private static NetImpl netImpl;
	
	public static NetImpl getNetImpl() throws NetException{
		if(netImpl==null){
			netImpl=new NetImpl();
		}
		return netImpl;
	}
	
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Config config;
	
	private NetImpl () throws NetException{
		config =new Config("config/server.properties");
		String ip=config.getValue("server.ip");
		int port =Integer.valueOf(config.getValue("server.port"));
		try {
			socket = new Socket(ip, port);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			throw new NetException("Õ¯¬Á¥ÌŒÛ", e);
		}
	}
	@Override
	public void send(ActionMessage am) throws NetException {
		try {
			oos.writeObject(am);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw new NetException("Õ¯¬Á¥ÌŒÛ", e);
		}
	}
	@Override
	public HandleMessage receive() throws NetException {
		try {
			HandleMessage hm = (HandleMessage) ois.readObject();
			return hm;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new NetException("¿‡–Õ’“≤ªµΩ", e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new NetException("Õ¯¬Á¥ÌŒÛ", e);
		}
	}

	protected void finalize() throws Throwable{
		super.finalize();
		if(socket!=null) {
			socket.close();
		}
	}
}