package Server.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Student;
import Server.dao.IStudentDao;
import rowsMapper.RowsMapper;
import rowsMapper.StudentRowsMapper;
import util.JdbcUtils;

public class StudentDaoImpl implements IStudentDao {
	/**
	 * 通过studentNo查找登录密码
	 */
	@Override
	public Student QueryStu(String studentNo) {
		Connection conn = null;
		String ParPwd;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_Student where s_NO = ?";
			Object[] params = { studentNo };
			RowsMapper rm = new StudentRowsMapper();
			List<Student> list = JdbcUtils.executeQuery(conn, sql, params, rm);
			return list.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		return null;
	}


	/**
	 * 通过studentNo查找班级编号
	 */
	@Override
	public String QueryClassNoByStuNo(String studentNo) {
		Connection conn = null;
		String classNo;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_student where s_NO = ?";
			Object[] params = { studentNo };
			RowsMapper rm = new StudentRowsMapper();
			List<Student> list = JdbcUtils.executeQuery(conn, sql, params, rm);
			classNo = list.get(0).getStuClassNo();
			return classNo;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return null;
	}
	
	/**
	 * 通过studentNo查找所有信息
	 */
	@Override
	public List queryByStudentNo(String studentNo) {
		Connection conn = null;
		List student = new ArrayList();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_student where s_NO = ?";
			Object[] params = { studentNo };
			RowsMapper rm = new StudentRowsMapper();
			List<Student> list = JdbcUtils.executeQuery(conn, sql, params, rm);
			for(Student s:list){
				student.add(s.getStudentName());
				student.add(s.getStuClassName());
				student.add(s.getHeadteacher());
				student.add(s.getHeadteacherTel());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		return student;
	}
	
}
