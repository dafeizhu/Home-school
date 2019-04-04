package cn.itcast.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Server.dao.IStudentDao;
import Server.dao.impl.StudentDaoImpl;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class P_Mine
 */
public class P_Mine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");//这里是设置一下编码格式
		response.setCharacterEncoding("utf-8");
		String content = request.getParameter("content");
		JsonParser parse =new JsonParser();  //创建json解析器
		JsonArray array =(JsonArray) parse.parse(content);
		JsonObject subObject = array.get(0).getAsJsonObject();
		
		String[] parentmine = new String[] {subObject.get("studentNo").getAsString()};
		
		System.out.println(parentmine[0]);
		
		IStudentDao studentdao = new StudentDaoImpl();
		Writer out = response.getWriter();
		List student = studentdao.queryByStudentNo(parentmine[0]);
		
		
		JSONArray studentArray = JSONArray.fromObject(student);
		System.out.println(studentArray);
		String json = studentArray.toString();
		out.write(json);
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
