package cn.itcast.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Server.dao.IPrivateLetterDao;
import Server.dao.impl.PrivateLetterDaoImpl;

/**
 * Servlet implementation class GetMessageDetail
 */
public class GetMessageDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");//这里是设置一下编码格式
		IPrivateLetterDao query = new PrivateLetterDaoImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		Writer out = response.getWriter();
		out.write(query.privateletterDetail(id));
		out.close();
		query.updateState(id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
