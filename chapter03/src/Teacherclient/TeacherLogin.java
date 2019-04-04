package Teacherclient;
import javax.swing.JOptionPane;

import dto.ActionEnum;
import dto.ActionMessage;
import dto.ClientEnum;
import dto.HandleMessage;
import exception.NetException;
import Teacherclient.net.NetImpl;
import Teacherclient.net.INet;
public class TeacherLogin{
	private INet net;
	public boolean login(String LoginNo,String LoginPw) throws NetException {
		net=NetImpl.getNetImpl();
			ActionMessage am=new ActionMessage();
			am.setAction(ActionEnum.TEACHER_LOGIN);
			am.setClient(ClientEnum.TEACHER_CLIENT);
			am.getData().put("LoginNo",String.valueOf(LoginNo));
			am.getData().put("LoginPw",String.valueOf(LoginPw));
			net.send(am);
			HandleMessage hm=net.receive();
			boolean isLogin = (boolean) hm.getData().get("isLogin");
			return isLogin;	
	}
}

