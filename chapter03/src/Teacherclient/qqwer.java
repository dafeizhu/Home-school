package Teacherclient;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import Entity.Inform;
import Entity.PrivateLetter;
import Entity.Teacher;
import Server.dao.IHomeworkDao;
import Server.dao.IPrivateLetterDao;
import Server.dao.IStudentDao;
import Server.dao.ITeaForClassDao;
import Server.dao.ITeacherDao;
import Server.dao.InformDao;
import Server.dao.impl.HomeworkDaoImpl;
import Server.dao.impl.InformDaoImpl;
import Server.dao.impl.PrivateLetterDaoImpl;
import Server.dao.impl.StudentDaoImpl;
import Server.dao.impl.TeaForClassDaoImpl;
import Server.dao.impl.TeacherDaoImpl;


public class qqwer {
	

	public static void main(String[] args) throws ParseException  {
		IStudentDao a = new StudentDaoImpl();
		System.out.println(a.QueryStu("1001001").getStudentName());
	}

}
