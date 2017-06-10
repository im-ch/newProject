package jeff.store;

import java.util.List;

import jeff.domain.ReportReview;

public interface ReportReviewStore {

	ReportReview selectReportReview(int reviewId);

	List<ReportReview> selectAllReportReview();

	void createReportReview(ReportReview reportReview);

	void deleteReportReview(int reviewId);

}
