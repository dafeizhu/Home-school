package Server.dao;

import java.util.List;

import Entity.Student;

public interface IStudentDao {
	public Student QueryStu(String studentNo);  //获取家长密码
	public String QueryClassNoByStuNo(String studentNo);//通过studentNo查找班级编号
	public List queryByStudentNo(String studentNo);
}
