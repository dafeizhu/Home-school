package rowsMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Inform;

public class InformRowsMapper implements RowsMapper<Inform> {
	public Inform getEntity(ResultSet rs) throws SQLException {
		Inform inform = new Inform(); 
		inform.setInformId(rs.getInt("i_ID"));
		inform.setClassNo(rs.getString("i_c_NO"));
		inform.setTeacherNo(rs.getString("i_t_NO"));
		inform.setInformContent(rs.getString("i_content"));
		inform.setSendTime(rs.getDate("i_time"));
		inform.setGrade(rs.getString("i_c_grade"));
		return inform;
	}
}
