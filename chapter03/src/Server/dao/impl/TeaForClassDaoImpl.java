package Server.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.teacherForClass;
import Entity.teacherForClassVO;
import Server.dao.ITeaForClassDao;
import net.sf.json.JSONArray;
import rowsMapper.RowsMapper;
import rowsMapper.TeaForClassRowsMapper;
import util.JdbcUtils;

public class TeaForClassDaoImpl implements ITeaForClassDao {


	public List QueryGrade(String teacherNo) {
		Connection conn = null;
		List<teacherForClassVO> classlist = new ArrayList<teacherForClassVO>();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_teacherclass where tc_t_NO = ?";
			Object[] params = { teacherNo };
			RowsMapper rm = new TeaForClassRowsMapper();
			List<teacherForClass> list = JdbcUtils.executeQuery(conn, sql, params, rm);
			for (teacherForClass t:list) {
				teacherForClassVO teacherForClassVO = new teacherForClassVO();
				teacherForClassVO.setCurrentClassNo(t.getClassNo().toString());
				teacherForClassVO.setClassName(t.getGrade().toString());
				classlist.add(teacherForClassVO);
			}
			JSONArray GradeJson = JSONArray.fromObject(classlist);
			return GradeJson;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		return null;
	}

	/**
	 * 通过教师号找到下拉班级
	 */
	public List QuerySelectClass(String teacherNo) {
		Connection conn = null;
		List classlist = new ArrayList();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_teacherclass where tc_t_NO = ?";
			Object[] params = { teacherNo };
			RowsMapper rm = new TeaForClassRowsMapper();
			List<teacherForClass> list = JdbcUtils.executeQuery(conn, sql, params, rm);
			for (teacherForClass t:list) {
				classlist.add(t.getGrade());
			}
			JSONArray classJson = JSONArray.fromObject(classlist);
			return classJson;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		return null;
	}

	@Override
	/**
	 * 通过classNo找到教师名字
	 */
	public List QueryTeacherByClassNo(String classNo){
		Connection conn = null;
		List teacherlist = new ArrayList();
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_teacherclass where tc_c_NO = ? ";
			Object[] params = { classNo };
			RowsMapper rm = new TeaForClassRowsMapper();
			List<teacherForClass> list = JdbcUtils.executeQuery(conn, sql, params, rm);
			for (teacherForClass tc:list) {
				teacherlist.add(tc.getTeacherName());
			}
			JSONArray teacherJson = JSONArray.fromObject(teacherlist);
			return teacherJson;
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			JdbcUtils.close(conn);
		}
		return null;
	}
	
	
}
