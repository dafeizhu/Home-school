package cn.itcast.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Server.dao.IStudentDao;
import Server.dao.ITeaForClassDao;
import Server.dao.impl.StudentDaoImpl;
import Server.dao.impl.TeaForClassDaoImpl;

/**
 * Servlet implementation class P_GetTeaList
 */
public class P_GetTeaList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");//这里是设置一下编码格式	
		IStudentDao queryClassNo = new StudentDaoImpl();
		ITeaForClassDao queryTea = new TeaForClassDaoImpl();
		String ClassNo = queryClassNo.QueryClassNoByStuNo(request.getParameter("currentNo"));
		String TeaList = queryTea.QueryTeacherByClassNo(ClassNo).toString();
		Writer out = response.getWriter();
		out.write(TeaList);
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
