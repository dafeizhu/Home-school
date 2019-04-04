package Server.dao;

import java.util.List;

import Entity.Inform;

public interface InformDao {
	public void updateInform(Inform inform);
	public List<String> QueryInform(String classNo);
	public String informDetail(int informId);
	public List QueryInformByTeaNo(String teacherNo);
}

