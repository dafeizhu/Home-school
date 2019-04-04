package Server.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Entity.PrivateLetter;
import Entity.PrivateLetterVO;
import Server.dao.IPrivateLetterDao;

import net.sf.json.JSONArray;
import rowsMapper.PrivateLetterRowsMapper;
import rowsMapper.RowsMapper;
import util.JdbcUtils;

public class PrivateLetterDaoImpl implements IPrivateLetterDao {
	/**
	 * 通过ID更新状态
	 */
	@Override
	public void updateState(int letterId) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update t_privateletter set pl_state = ? where pl_ID = ?";
//			sql += "values (?,?)";
//			Object[] params = {"未读", letterId};
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			
			stmt.setString(1, "已读");
			stmt.setInt(2, letterId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
	}
	
	/**
	 * 私信列表
	 */
	@Override
	public List QueryPrivateLetterByTeaNo(String teacherNo) {
		Connection conn = null;
		List<PrivateLetterVO> privateletterlist = new ArrayList<PrivateLetterVO>(); 
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_privateletter where pl_t_NO = ?";
			Object[] params = { teacherNo };
			RowsMapper rm = new PrivateLetterRowsMapper();
			List<PrivateLetter> list = JdbcUtils.executeQuery(conn, sql, params, rm);
			for (PrivateLetter p:list) {
				PrivateLetterVO privateLetterVO = new PrivateLetterVO();
				privateLetterVO.setLetterId(p.getLetterId().toString());
//				privateLetterVO.setSendNO(p.getSendNO().toString());
				privateLetterVO.setSendName(p.getSendName().toString());
				
				privateLetterVO.setState(p.getState().toString());
				privateLetterVO.setTime(p.getTalkTime().toString());
				if(p.getContent().length() > 14){
					String content = p.getContent().substring(0,14) + "...";
					privateLetterVO.setContent(content);
				}else{
					privateLetterVO.setContent(p.getContent());
				}
//				privateLetterVO.setTeacherNO(p.getTeacherNo().toString());
				privateLetterVO.setTeacherName(p.getTeacherName().toString());
				privateletterlist.add(privateLetterVO);
			}
			Collections.reverse(privateletterlist);		//将获取的数据倒序
			JSONArray privateletterJson = JSONArray.fromObject(privateletterlist);
			return privateletterJson;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		return null;
	}
	
	/**
	 * 获取私信详细内容
	 */
	public String privateletterDetail(int letterId){
		Connection conn = null;
		String privateletterContent;
		try{
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_privateletter where pl_ID = ?";
			Object[] params = { letterId };
			RowsMapper rm = new PrivateLetterRowsMapper();
			List<PrivateLetter> list = JdbcUtils.executeQuery(conn, sql, params,rm);
			privateletterContent = list.get(0).getContent();
			return privateletterContent;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		return null;
	}

	@Override
	public List QueryPLByStuNo(String studentNo) {
		Connection conn = null;
		List<PrivateLetterVO> privateletterlist = new ArrayList<PrivateLetterVO>(); 
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from t_privateletter where pl_s_NO = ?";
			Object[] params = { studentNo };
			RowsMapper rm = new PrivateLetterRowsMapper();
			List<PrivateLetter> list = JdbcUtils.executeQuery(conn, sql, params, rm);
			for (PrivateLetter p:list) {
				PrivateLetterVO privateLetterVO = new PrivateLetterVO();
				privateLetterVO.setLetterId(p.getLetterId().toString());
//				privateLetterVO.setSendNO(p.getSendNO().toString());
				privateLetterVO.setSendName(p.getSendName().toString());
				
				privateLetterVO.setState(p.getState().toString());
				privateLetterVO.setTime(p.getTalkTime().toString());
				if(p.getContent().length() > 14){
					String content = p.getContent().substring(0,14) + "...";
					privateLetterVO.setContent(content);
				}else{
					privateLetterVO.setContent(p.getContent());
				}
//				privateLetterVO.setTeacherNO(p.getTeacherNo().toString());
				privateLetterVO.setTeacherName(p.getTeacherName().toString());
				privateletterlist.add(privateLetterVO);
			}
			Collections.reverse(privateletterlist);		//将获取的数据倒序
			JSONArray privateletterJson = JSONArray.fromObject(privateletterlist);
			return privateletterJson;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
		return null;
	}

	/**
	 * 插入新私信
	 */
	@Override
	public void updatePrivateLetter(PrivateLetter privateLetter) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into t_privateletter (pl_s_NO,pl_s_Name,pl_time,pl_content,pl_state,pl_t_NO,pl_t_Name) ";
			sql += "values (?,?,?,?,?,?,?)";
			Object[] params = { privateLetter.getSendNO(), privateLetter.getSendName(), privateLetter.getTalkTime(), privateLetter.getContent(), "未读", privateLetter.getTeacherNo(), privateLetter.getTeacherName() };
			JdbcUtils.insert(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn);
		}
	}
}
