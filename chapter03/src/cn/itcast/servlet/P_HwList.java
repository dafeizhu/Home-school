package cn.itcast.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Server.dao.IHomeworkDao;
import Server.dao.IStudentDao;
import Server.dao.impl.HomeworkDaoImpl;
import Server.dao.impl.StudentDaoImpl;

/**
 * Servlet implementation class P_HwList
 */
public class P_HwList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");//这里是设置一下编码格式
		IHomeworkDao HW = new HomeworkDaoImpl();
		IStudentDao Stu = new StudentDaoImpl();
		String ClassNo = request.getParameter("currentNo");
		String HwContent = HW.QueryHomework(Stu.QueryClassNoByStuNo(ClassNo)).toString();
		Writer out = response.getWriter();
		out.write(HwContent);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
