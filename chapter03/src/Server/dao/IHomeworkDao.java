package Server.dao;

import java.util.List;

import Entity.Homework;

public interface IHomeworkDao {
	public List QueryHomework(String classNo);
	public void updateHomework(Homework homework);
}
