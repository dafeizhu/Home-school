package Server.service.impl;

import Server.dao.ITeacherDao;
import Server.dao.impl.TeacherDaoImpl;
import Server.service.ITchLoginSevice;
import Entity.Teacher;

public class TchLoginServiceImpl implements ITchLoginSevice {
	private ITeacherDao teacherdao = new TeacherDaoImpl();
	
	@Override
	public boolean login(String teacherNo, String LoginPW) {
	    Teacher teacher = teacherdao.queryByTeacherNo(teacherNo);
		if(null != teacher && teacher.getTeaLogin().equals(LoginPW)){
			return true;
			
		}else{
			return false;
		}
	}
}
