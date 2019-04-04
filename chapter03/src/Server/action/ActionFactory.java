package Server.action;

import Server.aciton.impl.TeacherLoginAction;
import dto.ActionEnum;
import dto.ClientEnum;


public class ActionFactory {
	
		public static IAction getAction(ClientEnum ce, ActionEnum ae){
		//用户端，用户动作
			 if(ce == ClientEnum.TEACHER_CLIENT && ae == ActionEnum.TEACHER_LOGIN) {
					return new TeacherLoginAction();
				}
		return null;
	}

}
