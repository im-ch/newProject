package jeff.service;

public interface ReportReviewService {

	public ReportReview findReportReview(int reviewId);
	public List<ReportReview> findAllReportReviews();
	public void registReportReview(ReportReview reportReview);
	public void removeReportReview(int reviewId);
	
}
