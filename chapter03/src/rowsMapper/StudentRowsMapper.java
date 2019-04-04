package rowsMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Student;

public class StudentRowsMapper implements RowsMapper<Student> {
	@Override
	public Student getEntity(ResultSet rs) throws SQLException {
		Student student = new Student();
		student.setStudentId(rs.getInt("s_ID"));
		student.setParNo(rs.getInt("s_NO"));
		student.setStudentName(rs.getString("s_Name"));
		student.setParName(rs.getString("s_parent"));
		student.setParPassword(rs.getString("s_Password"));
		student.setStudentSex(rs.getString("s_Sex"));
		student.setParTel(rs.getString("s_parenttel"));
		student.setAddress(rs.getString("s_address"));
		student.setStuClassNo(rs.getString("s_c_NO"));
		student.setStudentSex(rs.getString("s_Sex"));
		student.setStuClassName(rs.getString("s_c_grade"));
		student.setHeadteacher(rs.getString("s_c_headteacher"));
		student.setHeadteacherTel(rs.getString("s_c_headteachertel"));
		return student;
	}

}
