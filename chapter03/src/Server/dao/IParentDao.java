package Server.dao;

import Entity.Parent;

public interface IParentDao {
	public Parent queryByParentNo(int parentNo);
	public String QueryParLoginPwd(int teacherNo);  //获取家长密码
}
