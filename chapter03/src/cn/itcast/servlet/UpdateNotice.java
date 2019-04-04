package cn.itcast.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Inform;
import Server.dao.InformDao;
import Server.dao.impl.InformDaoImpl;

/**
 * Servlet implementation class UpdateNotice
 */
public class UpdateNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");//这里是设置一下编码格式
		InformDao Update = new InformDaoImpl();
		Inform inform = new Inform();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		inform.setTeacherNo(request.getParameter("currentNo"));
		try {
			inform.setSendTime(sdf.parse(request.getParameter("time")));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		inform.setInformContent(request.getParameter("content"));
		inform.setGrade(request.getParameter("grade"));
		Update.updateInform(inform);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
