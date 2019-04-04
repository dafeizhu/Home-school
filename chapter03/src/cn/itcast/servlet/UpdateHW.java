package cn.itcast.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Homework;
import Server.dao.IHomeworkDao;
import Server.dao.impl.HomeworkDaoImpl;

/**
 * Servlet implementation class UpdateHW
 */
public class UpdateHW extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateHW() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");//这里是设置一下编码格式
		IHomeworkDao  updateHW = new HomeworkDaoImpl();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Homework homework = new Homework();
		homework.setClassNo(request.getParameter("ClassNo"));
		homework.setObject(request.getParameter("Object"));
		homework.setHWcontent(request.getParameter("HWcontent"));
		try {
			homework.setSendTime(sdf.parse(request.getParameter("SendTime")));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		updateHW.updateHomework(homework);
		System.out.println(request.getParameter("ClassNo"));
		System.out.println(request.getParameter("Object"));
		System.out.println(request.getParameter("HWcontent"));
		System.out.println(request.getParameter("SendTime"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
