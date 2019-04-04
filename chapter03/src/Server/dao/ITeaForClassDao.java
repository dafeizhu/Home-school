package Server.dao;

import java.util.List;

public interface ITeaForClassDao {
	public List QueryGrade(String teacherNo);
	public List QuerySelectClass(String teacherNo);
	public List QueryTeacherByClassNo(String classNo);
}
