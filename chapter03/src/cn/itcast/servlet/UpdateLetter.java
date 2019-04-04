package cn.itcast.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.PrivateLetter;
import Server.dao.IPrivateLetterDao;
import Server.dao.IStudentDao;
import Server.dao.ITeacherDao;
import Server.dao.impl.PrivateLetterDaoImpl;
import Server.dao.impl.StudentDaoImpl;
import Server.dao.impl.TeacherDaoImpl;

/**
 * Servlet implementation class UpdateLetter
 */
public class UpdateLetter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");//这里是设置一下编码格式
		String studentNo = request.getParameter("currentNo");
		String teacherName = request.getParameter("teacherName");
		System.out.println(teacherName+"00");
		ITeacherDao Tea = new TeacherDaoImpl();
		IPrivateLetterDao update =new PrivateLetterDaoImpl();
		IStudentDao Stu = new StudentDaoImpl();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		PrivateLetter le = new PrivateLetter();
		le.setSendNO(studentNo);
		le.setSendName(Stu.QueryStu(studentNo).getStudentName());
		try {
			le.setTalkTime(sdf.parse(request.getParameter("time")));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		le.setContent(request.getParameter("content"));
		System.out.println(Tea.queryByTeaName(teacherName));
		le.setTeacherNo(Tea.queryByTeaName(teacherName));
		le.setTeacherName(teacherName);
		update.updatePrivateLetter(le);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
