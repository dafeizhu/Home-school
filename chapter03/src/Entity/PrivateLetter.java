package Entity;

import java.util.Date;

public class PrivateLetter {
	private Integer letterId;
	private String sendNO;
	private String sendName;
	private String teacherNo;
	private String teacherName;
	private String content;
	private Date talkTime;
	private String state;
	public Integer getLetterId() {
		return letterId;
	}
	public void setLetterId(Integer letterId) {
		this.letterId = letterId;
	}
	public String getSendNO() {
		return sendNO;
	}
	public void setSendNO(String sendNO) {
		this.sendNO = sendNO;
	}
	public String getSendName() {
		return sendName;
	}
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	public String getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTalkTime() {
		return talkTime;
	}
	public void setTalkTime(Date talkTime) {
		this.talkTime = talkTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

}
