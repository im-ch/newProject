package jeff.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="reportReviews")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class ReportReviews {

	@XmlElement(name="reportReview")
	private List<ReportReview> reportReviewList;

	public List<ReportReview> getReportReviewList() {
		return reportReviewList;
	}

	public void setReportReviewList(List<ReportReview> reportReviewList) {
		this.reportReviewList = reportReviewList;
	}

	@Override
	public String toString() {
		return "ReportReviews [reportReviewList=" + reportReviewList + "]";
	}
	
	
}
