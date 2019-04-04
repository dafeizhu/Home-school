package Entity;

import java.util.Date;

public class Homework {
	private Integer homeworkId;
	private String classNo;
	private Integer teacherNo;
	private String Object;
	private String HWcontent;
	private Date sendTime;
	public Integer getHomeworkId() {
		return homeworkId;
	}
	public void setHomeworkId(Integer homeworkId) {
		this.homeworkId = homeworkId;
	}
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public Integer getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(Integer teacherNo) {
		this.teacherNo = teacherNo;
	}
	public String getObject() {
		return Object;
	}
	public void setObject(String Object) {
		this.Object = Object;
	}
	public String getHWcontent() {
		return HWcontent;
	}
	public void setHWcontent(String hWcontent) {
		HWcontent = hWcontent;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	
}
