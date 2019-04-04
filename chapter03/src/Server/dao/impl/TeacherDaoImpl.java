package Server.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Server.dao.ITeacherDao;
import Entity.Teacher;
import rowsMapper.RowsMapper;
import rowsMapper.TeacherRowsMapper;
import util.JdbcUtils;


public class TeacherDaoImpl implements ITeacherDao{

	@Override
	public Teacher queryByTeacherNo(String teacherNo){
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_teacher where t_NO = ?";
			Object[] params = { teacherNo };
			RowsMapper rm = new TeacherRowsMapper();
			List<Teacher> list = JdbcUtils.executeQuery(conn, sql, params, rm);
			if (null != list && list.size() > 0) {
				return list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		return null;
	}

	
	/**
	 * 根据老师编号查询密码
	 */
	@Override
	public String QueryTeaLoginPwd(String teacherNo) {
		Connection conn = null;
		String TeaPwd;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_teacher where t_NO = ?";
			Object[] params = { teacherNo };
			RowsMapper rm = new TeacherRowsMapper();
			List<Teacher> list = JdbcUtils.executeQuery(conn, sql, params, rm);
			TeaPwd = list.get(0).getTeaLogin();
			return TeaPwd;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		return null;
	}


	@Override
	public String queryByTeaName(String teacherName) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_teacher where t_Name = ?";
			Object[] params = { teacherName };
			RowsMapper rm = new TeacherRowsMapper();
			List<Teacher> list = JdbcUtils.executeQuery(conn, sql, params, rm);
			if (null != list && list.size() > 0) {
				return list.get(0).getTeacherNo();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		return null;
	}

}
