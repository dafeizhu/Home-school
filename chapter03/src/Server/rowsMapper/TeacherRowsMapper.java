//package Server.rowsMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import Entity.Teacher;
//
//public class TeacherRowsMapper implements RowsMapper<Teacher> {
//	public Teacher getEntity(ResultSet rs) throws SQLException{
//		
//		Teacher teacher = new Teacher();		
//		teacher.setTeacherNo(rs.getString("t_No"));
//		teacher.setTeacherName(rs.getString("t_Name"));
//		teacher.setTeacherSex(rs.getString("t_Sex"));
//		teacher.setDoctorTel(rs.getString("t_Tel"));
//		teacher.setTeacherEdu(rs.getString("S_Name"));
//		teacher.setTeacherObj(rs.getString("D_Education"));
//		teacher.setTeacherSub(rs.getString("D_Introduce"));
//		teacher.setTeacherIntro(rs.getDate("D_hiredate"));
//		teacher.setLoginpw(rs.getInt("D_Age"));
//		teacher.setDoctorPcard(rs.getString("D_Pcard"));
//
//		return doctor;
//	}
//
//}
