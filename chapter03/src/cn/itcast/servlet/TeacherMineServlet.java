package cn.itcast.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Entity.Teacher;
import Server.dao.ITeacherDao;
import Server.dao.impl.TeacherDaoImpl;
import net.sf.json.JSONArray;

public class TeacherMineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");//这里是设置一下编码格式
		String content = request.getParameter("content");
		JsonParser parse =new JsonParser();  //创建json解析器
		JsonArray array =(JsonArray) parse.parse(content);
		JsonObject subObject = array.get(0).getAsJsonObject();
		
		String[] teachermine = new String[] {subObject.get("teacherNo").getAsString()};
		
		System.out.println(teachermine[0]);
		
		ITeacherDao teacherdao = new TeacherDaoImpl();
		Writer out = response.getWriter();
		Teacher teacher = teacherdao.queryByTeacherNo(teachermine[0]);
		List list = new ArrayList();
		list.add(teacher.getTeacherName());
		list.add(teacher.getTeacherObj());
		list.add(teacher.getTeacherEdu());
		list.add(teacher.getTeacherIntro());
		JSONArray teacherArray = JSONArray.fromObject(list);
		String json = teacherArray.toString();
		System.out.println(json);
		out.write(json);
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
		String[] teachermine = new String[] {subObject.get("teacherNo").getAsString()};
		System.out.println(teachermine[0]);
	}

}

