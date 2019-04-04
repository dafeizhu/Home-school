package rowsMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.PrivateLetter;



public class PrivateLetterRowsMapper implements RowsMapper<PrivateLetter> {
	public PrivateLetter getEntity(ResultSet rs) throws SQLException {
		PrivateLetter privateLetter = new PrivateLetter();
		privateLetter.setLetterId(rs.getInt("pl_ID"));
		privateLetter.setSendNO(rs.getString("pl_s_NO"));
		privateLetter.setSendName(rs.getString("pl_s_Name"));
		privateLetter.setTalkTime(rs.getDate("pl_time"));
		privateLetter.setContent(rs.getString("pl_content"));
		privateLetter.setState(rs.getString("pl_state"));
		privateLetter.setTeacherNo(rs.getString("pl_t_NO"));
		privateLetter.setTeacherName(rs.getString("pl_t_Name"));
		return privateLetter;
	}

}
