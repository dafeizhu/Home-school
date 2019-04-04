package rowsMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Homework;

public class HomeworkRowsMapper implements RowsMapper<Homework> {
	public Homework getEntity(ResultSet rs) throws SQLException {
		Homework homework = new Homework();
		homework.setHomeworkId(rs.getInt("h_ID"));
		homework.setClassNo(rs.getString("h_c_NO"));
		homework.setObject(rs.getString("h_t_Obj"));
		homework.setHWcontent(rs.getString("h_content"));
		homework.setSendTime(rs.getDate("h_time"));
		
		return homework;
}
}