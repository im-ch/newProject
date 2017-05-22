package jeff.domain;

import java.sql.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="review")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class Review {

	private String companyId;
	private String userId;
	private String title;
	private String content;
	private Date regDate;
	private Boolean reported;
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Boolean getReported() {
		return reported;
	}
	public void setReported(Boolean reported) {
		this.reported = reported;
	}
	@Override
	public String toString() {
		return "Review [companyId=" + companyId + ", userId=" + userId + ", title=" + title + ", content=" + content
				+ ", regDate=" + regDate + ", reported=" + reported + "]";
	}
	
	
}
