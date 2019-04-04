package Server.UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Server.exception.StartException;
import Server.net.Server;

public class ServerUI extends JFrame {
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerUI frame = new ServerUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public ServerUI() { 
      setBounds(100,100,500,500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      JPanel contentPane=new JPanel( );
      contentPane.setBorder(new EmptyBorder(2, 150, 5, 150));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);

      JButton runBtn = new JButton("启动服务器");
      contentPane.add(runBtn, BorderLayout.SOUTH);
      //注册监视器
      
      runBtn.addActionListener(new ActionListener() {
    	  int i=1;
	     Server server = new Server();
	public void actionPerformed(ActionEvent e) {
		 if ("启动服务器".equals(e.getActionCommand())) {
			 runBtn.setText("停止服务器");
			if(i==1) { 
			i--;
			server = new Server();			
			server.start();			
			}
			else {
			server.onPauseRecover();	
			}
		} else {
			runBtn.setText("启动服务器");
			server.stopServer();
		}
	}
});
}

}


