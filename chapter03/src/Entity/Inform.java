package Entity;

import java.util.Date;

public class Inform {
	private Integer informId;
	private String teacherNo;
	private String classNo;
	private String informContent;
	private Date SendTime;
	private String grade;
	public Integer getInformId() {
		return informId;
	}
	public void setInformId(Integer informId) {
		this.informId = informId;
	}
	public String getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}
	public String getInformContent() {
		return informContent;
	}
	public void setInformContent(String informContent) {
		this.informContent = informContent;
	}
	public Date getSendTime() {
		return SendTime;
	}
	public void setSendTime(Date sendTime) {
		SendTime = sendTime;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

}
