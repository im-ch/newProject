package jeff.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="reportReview")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class ReportReview {

	private int reviewId;
	private String reportReason;
	
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public String getReportReason() {
		return reportReason;
	}
	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}
	@Override
	public String toString() {
		return "ReportReview [reviewId=" + reviewId + ", reportReason=" + reportReason + "]";
	}
	
	
}
