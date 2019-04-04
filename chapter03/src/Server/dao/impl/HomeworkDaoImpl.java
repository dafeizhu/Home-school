package Server.dao.impl;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Entity.Homework;
import Entity.HomeworkVO;
import Server.dao.IHomeworkDao;
import net.sf.json.JSONArray;
import rowsMapper.HomeworkRowsMapper;
import rowsMapper.RowsMapper;
import util.JdbcUtils;

public class HomeworkDaoImpl implements IHomeworkDao {

	@Override
	public List QueryHomework(String classNo) {
Connection conn = null;
		
		List<HomeworkVO> homeworklist = new ArrayList<HomeworkVO>();
		try {
			
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_homework where h_c_NO = ?";
			Object[] params = { classNo };
			RowsMapper rm = new HomeworkRowsMapper();
			List<Homework> list = JdbcUtils.executeQuery(conn, sql, params, rm);
				for (Homework h:list) {
					HomeworkVO homeworkVO = new HomeworkVO();
					homeworkVO.setHomeworkID(h.getHomeworkId().toString());
					homeworkVO.setCurrentClassNo(h.getClassNo().toString());
					homeworkVO.setObject(h.getObject());
					homeworkVO.setHWcontent(h.getHWcontent());
					homeworkVO.setSendTime(h.getSendTime().toString());
					homeworklist.add(homeworkVO);
				}
				Collections.reverse(homeworklist);
//					//将获取的数据倒序
			JSONArray HomeworkJson = JSONArray.fromObject(homeworklist);
			return HomeworkJson;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		return null;
	}

	@Override
	public void updateHomework(Homework homework) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into t_homework (h_c_NO,h_t_Obj,h_content,h_time) ";
			sql += "values (?,?,?,?)";
			Object[] params = {homework.getClassNo(),homework.getObject(),homework.getHWcontent(),homework.getSendTime()};
			JdbcUtils.insert(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
	}
}
