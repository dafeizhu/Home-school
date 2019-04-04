package cn.itcast.servlet;

import java.io.IOException;
import java.io.Writer;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Server.dao.ITeaForClassDao;
import Server.dao.impl.TeaForClassDaoImpl;


/**
 * Servlet implementation class GetClassList
 */
public class GetClassList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");//这里是设置一下编码格式	
		String currentNo = request.getParameter("currentNo");
		ITeaForClassDao getGroup = new TeaForClassDaoImpl();
		String TeaGroupInFor = getGroup.QueryGrade(currentNo).toString();
		System.out.println(TeaGroupInFor);
 	    Writer out = response.getWriter();
		out.write(TeaGroupInFor);
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
