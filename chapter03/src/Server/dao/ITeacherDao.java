package Server.dao;

import Entity.Teacher;

public interface ITeacherDao {
	public Teacher queryByTeacherNo(String teacherNo);
	public String QueryTeaLoginPwd(String teacherNo); //根据老师编号查询密码
	public String queryByTeaName(String teacherName);
}
