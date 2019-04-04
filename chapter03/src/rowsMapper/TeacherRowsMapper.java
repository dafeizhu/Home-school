package rowsMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Teacher;


public class TeacherRowsMapper implements RowsMapper<Teacher> {
	@Override
	public Teacher getEntity(ResultSet rs) throws SQLException {
		Teacher teacher = new Teacher();
		teacher.setTeacherId(rs.getInt("t_ID"));
		teacher.setTeacherNo(rs.getString("t_NO"));
		teacher.setTeacherName(rs.getString("t_Name"));
		teacher.setTeacherSex(rs.getString("t_Sex"));
		teacher.setTeacherEdu(rs.getString("t_Edu"));
		teacher.setTeacherObj(rs.getString("t_Obj"));
		teacher.setTeacherSub(rs.getString("t_Sub"));
		teacher.setTeacherIntro(rs.getString("t_Intro"));
		teacher.setTeaLogin(rs.getString("t_Password"));
		return teacher;
	}
}
