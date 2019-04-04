package rowsMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.teacherForClass;



public class TeaForClassRowsMapper implements RowsMapper<teacherForClass> {

	@Override
	public teacherForClass getEntity(ResultSet rs) throws SQLException {
		teacherForClass teaClass = new teacherForClass();
		teaClass.setClassNo(rs.getInt("tc_c_NO"));
		teaClass.setTeacherNo(rs.getInt("tc_t_NO"));
		teaClass.setGrade(rs.getString("tc_c_grade"));
		teaClass.setTeacherName(rs.getString("tc_t_Name"));
		
		return teaClass;
	}

}