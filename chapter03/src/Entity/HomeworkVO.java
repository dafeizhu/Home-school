package Entity;

public class HomeworkVO {
	private String HomeworkID;
	private String CurrentClassNo;
	private String Object;
	private String HWcontent;
	private String SendTime;
	public String getHomeworkID() {
		return HomeworkID;
	}
	public void setHomeworkID(String homeworkID) {
		HomeworkID = homeworkID;
	}
	public String getCurrentClassNo() {
		return CurrentClassNo;
	}
	public void setCurrentClassNo(String currentClassNo) {
		CurrentClassNo = currentClassNo;
	}
	public String getObject() {
		return Object;
	}
	public void setObject(String tObject) {
		Object = tObject;
	}
	public String getHWcontent() {
		return HWcontent;
	}
	public void setHWcontent(String hWcontent) {
		HWcontent = hWcontent;
	}
	public String getSendTime() {
		return SendTime;
	}
	public void setSendTime(String sendTime) {
		SendTime = sendTime;
	}
}
