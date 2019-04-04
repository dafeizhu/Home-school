package Server.dao;

import java.util.List;

import Entity.PrivateLetter;

public interface IPrivateLetterDao {
	public void updateState(int letterId);
	public List QueryPrivateLetterByTeaNo(String teacherNo);
	public String privateletterDetail(int letterId);
	public List QueryPLByStuNo(String sudentNo);
	public void updatePrivateLetter(PrivateLetter privateLetter);
}
