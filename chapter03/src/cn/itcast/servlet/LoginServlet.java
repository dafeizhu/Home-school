package cn.itcast.servlet;


import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Server.dao.IStudentDao;
import Server.dao.ITeacherDao;
import Server.dao.impl.StudentDaoImpl;
import Server.dao.impl.TeacherDaoImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");//这里是设置一下编码格式
		String content = request.getParameter("content");
		JsonParser parse =new JsonParser();  //创建json解析器
        JsonArray array =(JsonArray) parse.parse(content);
        JsonObject subObject = array.get(0).getAsJsonObject();
		String[] TeaLogin = new String[] {subObject.get("Class").getAsString(),subObject.get("LoginNo").getAsString(),subObject.get("LoginPwd").getAsString()};
		ITeacherDao teacherdao = new TeacherDaoImpl();
		IStudentDao studentdao = new StudentDaoImpl();
		System.out.println(TeaLogin[1]);
		Writer out = response.getWriter();
		String result = null;
		if(TeaLogin[0].equals("teacher")) {
		if(teacherdao.QueryTeaLoginPwd(TeaLogin[1]).equals(TeaLogin[2])) {
			result = "Tea";
		}
		}else if(studentdao.QueryStu(TeaLogin[1]).getParPassword().equals(TeaLogin[2])) {
			result = "Par";
		}
		out.write(result);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String content = request.getParameter("content");
		JsonParser parse =new JsonParser();  //创建json解析器
        JsonArray array =(JsonArray) parse.parse(content);
        JsonObject subObject = array.get(0).getAsJsonObject();
		String[] TeaLogin = new String[] {subObject.get("Class").getAsString(),subObject.get("LoginNo").getAsString(),subObject.get("LoginPwd").getAsString()};
		System.out.println(TeaLogin[0]);

	}

}
