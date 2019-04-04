package Server.net;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Server.action.ActionFactory;
import Server.action.IAction;
import Server.exception.StartException;
import dto.ActionMessage;
import dto.HandleMessage;
import util.Config;

public class Server extends Thread{
	private boolean isRun = false;
	private boolean close=false;
	private ServerSocket serverSocket;
	private Config config;

	public void run()
	{
		try 
		{
			startServer();
		} 
		catch (StartException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * 服务器启动
	 * @throws StartException
	 * @throws IOException
	 */
	public void startServer() throws StartException 
	{
		try 
		{
			config = new Config("config/server.properties");//获取配置文件
			int port = Integer.valueOf(config.getValue("server.port"));// 从配置文件中获得端口
			serverSocket = new ServerSocket(port);//创建绑定指定端口的字套
			isRun = true;
			//控制台输出启动信息
			System.out.println("服务器启动成功，在端口" + port + "监听");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new StartException("启动失败", e);
		}
		try 
			{
				while (!close) 
				{
					if(isRun)
					{
					// 不断接收客户端的信息，监听客户端连接
					Socket socket = serverSocket.accept();
					// 每当接收到一个客户端请求，就开一个线程为它服务
					new ServerThread(socket).start();
					}
					else
					{
						wait(1000);
					}
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				throw new StartException("服务器出现问题", e);
			}
			finally
			{
				if (null != serverSocket) 
				{
					try 
					{
						serverSocket.close();
					}
					catch (IOException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
		
		/**
		 * 服务器关闭
		 */
		public void stopServer() 
		{
			isRun = false;
			//控制台输出启动信息
			System.out.println("服务器已停止");
		}

		/**
		 * 成员内部类，用来服务每个客户端线程
		 */
		private class ServerThread extends Thread 
		{
			private Socket socket;

			public ServerThread(Socket socket) 
			{
				this.socket = socket;
			}
			public void run() 
			{
				// 创建对象输入流和输出流
				ObjectInputStream ois = null;
				ObjectOutputStream oos = null;
				try 
				{					
					ois = new ObjectInputStream(socket.getInputStream());
					oos = new ObjectOutputStream(socket.getOutputStream());
					while (isRun) 
					{
						// 接收客户端发过来的信息
						ActionMessage am = (ActionMessage) ois.readObject();
						am.setClientIP(socket.getInetAddress());// 设置IP
						// 根据动作枚举类型获得动作对象
						IAction action = ActionFactory.getAction(am.getClient(),am.getAction());
						// 调用动作对象的handle方法，处理动作，然后返回处理消息对象							
						HandleMessage hm = action.handle(am);
						// 输出信息
						oos.writeObject(hm);
						// 刷新
						oos.flush();
					}
					
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				} 
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				} 
				finally 
				{
					try 
					{
						socket.close();
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
		
		public void onPauseRecover()
		{
			isRun=true;
			System.out.println("服务器恢复运行");
		}
}