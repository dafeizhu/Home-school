package Server.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Server.dao.IParentDao;
import Entity.Parent;
import rowsMapper.ParentRowsMapper;
import rowsMapper.RowsMapper;
import rowsMapper.TeacherRowsMapper;
import util.JdbcUtils;


public class ParentDaoImpl implements IParentDao{

	
	@Override
	public Parent queryByParentNo(int parentNo) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_parent where p_NO = ?";
			Object[] params = { parentNo };
			RowsMapper rm = new TeacherRowsMapper();
			List<Parent> list = JdbcUtils.executeQuery(conn, sql, params, rm);
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
	 * 
	 */
	@Override
	public String QueryParLoginPwd(int parNo) {
		Connection conn = null;
		String ParPwd;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_Parent where p_NO = ?";
			Object[] params = { parNo };
			RowsMapper rm = new ParentRowsMapper();
			List<Parent> list = JdbcUtils.executeQuery(conn, sql, params, rm);
			ParPwd = list.get(0).getParLogin();
			return ParPwd;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		return null;
	}
}