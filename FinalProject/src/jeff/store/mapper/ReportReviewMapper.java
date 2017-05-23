package jeff.store.mapper;

import java.util.List;

import jeff.domain.ReportReview;

public interface ReportReviewMapper {
	
	ReportReview selectReportReview(int reviewId);

	List<ReportReview> selectAllReportReview();

	void createReportReview(ReportReview reportReview);

	void deleteReportReview(int reviewId);


}
