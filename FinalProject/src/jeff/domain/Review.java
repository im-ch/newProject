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

	private int reviewId;
	private String companyId;
	private String userId;
	private String content;
	private Date regDate;
	private Boolean reported;
	
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
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
		return "Review [reviewId=" + reviewId + ", companyId=" + companyId + ", userId=" + userId + ", content="
				+ content + ", regDate=" + regDate + ", reported=" + reported + "]";
	}
	
	
	
}
