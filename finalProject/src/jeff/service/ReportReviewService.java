package jeff.service;

import java.util.List;

import jeff.domain.ReportReview;

public interface ReportReviewService {

	public ReportReview findReportReview(int reviewId);
	public List<ReportReview> findAllReportReviews();
	public void registReportReview(ReportReview reportReview);
	public void removeReportReview(int reviewId);
	
}
