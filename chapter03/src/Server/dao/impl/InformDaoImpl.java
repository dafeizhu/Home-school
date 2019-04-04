package Server.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Entity.Inform;
import Entity.InformVO;
import Server.dao.InformDao;
import net.sf.json.JSONArray;
import rowsMapper.InformRowsMapper;
import rowsMapper.RowsMapper;
import util.JdbcUtils;

public class InformDaoImpl implements InformDao {

	@Override
	public void updateInform(Inform inform) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into t_inform (i_t_NO,i_c_grade,i_content,i_time) ";
			sql += "values (?,?,?,?)";
			Object[] params = { inform.getTeacherNo(),inform.getGrade(),inform.getInformContent(),inform.getSendTime() };
			JdbcUtils.insert(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}

	}

	/**
	 * 获取通知列表
	 */
	public List QueryInform(String classNo) {
		Connection conn = null;
		List<InformVO> informlist = new ArrayList<InformVO>(); 
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_inform where i_c_NO = ?";
			Object[] params = { classNo };
			RowsMapper rm = new InformRowsMapper();
			List<Inform> list = JdbcUtils.executeQuery(conn, sql, params, rm);
			for (Inform i:list) {
				InformVO informVO = new InformVO();
//				informVO.setCurrentClassNo(i.getClassNo().toString());
				informVO.setClassName(i.getGrade());
				if(i.getInformContent().length() > 14){
					String content = i.getInformContent().substring(0,14) + "...";
					informVO.setInformContent(content);
				}else{
					informVO.setInformContent(i.getInformContent());
				}
				informVO.setSendTime(i.getSendTime().toString());
				informVO.setInformId(i.getInformId().toString());
				informlist.add(informVO);
			}
			Collections.reverse(informlist);		//将获取的数据倒序
			JSONArray InformJson = JSONArray.fromObject(informlist);
			return InformJson;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		return null;
	}

	/**
	 * 获取通知详细内容
	 */
	public String informDetail(int informId){
		Connection conn = null;
		List informdetail = new ArrayList();
		String informContent;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_inform where i_ID = ?";
			Object[] params = { informId };
			RowsMapper rm = new InformRowsMapper();
			List<Inform> list = JdbcUtils.executeQuery(conn, sql, params,rm);
			informContent = list.get(0).getInformContent();
			return informContent;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		return null;
	}
	
	/**
	 * 通过教师号获取通知列表
	 */
	public List QueryInformByTeaNo(String teacherNo) {
		Connection conn = null;
		List<InformVO> informlist = new ArrayList<InformVO>(); 
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_inform where i_t_NO = ?";
			Object[] params = { teacherNo };
			RowsMapper rm = new InformRowsMapper();
			List<Inform> list = JdbcUtils.executeQuery(conn, sql, params, rm);
			for (Inform i:list) {
				InformVO informVO = new InformVO();
				informVO.setInformId(i.getInformId().toString());
//				informVO.setCurrentClassNo(i.getClassNo().toString());
				informVO.setClassName(i.getGrade());
				if(i.getInformContent().length() > 14){
					String content = i.getInformContent().substring(0,14) + "...";
					informVO.setInformContent(content);
				}else{
					informVO.setInformContent(i.getInformContent());
				}
				informVO.setSendTime(i.getSendTime().toString());
				informlist.add(informVO);
			}
			Collections.reverse(informlist);		//将获取的数据倒序
			JSONArray InformJson = JSONArray.fromObject(informlist);
			return InformJson;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		return null;
	}
}
