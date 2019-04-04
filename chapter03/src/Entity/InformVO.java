package Entity;

public class InformVO {
	private String InformId;
	private String currentClassNo;
	private String InformContent;
	private String sendTime;
	private String className;
	public String getInformId() {
		return InformId;
	}
	public void setInformId(String informId) {
		InformId = informId;
	}
	public String getCurrentClassNo() {
		return currentClassNo;
	}
	public void setCurrentClassNo(String currentClassNo) {
		this.currentClassNo = currentClassNo;
	}
	public String getInformContent() {
		return InformContent;
	}
	public void setInformContent(String informContent) {
		InformContent = informContent;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
}
