package jeff.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jeff.domain.ReportReview;
import jeff.service.ReportReviewService;
import jeff.store.ReportReviewStore;

@Service
public class ReportReviewServiceLogic implements ReportReviewService{

	@Autowired
	private ReportReviewStore store;
	@Override
	public ReportReview findReportReview(int reviewId) {
		return store.selectReportReview(reviewId);
	}

	@Override
	public List<ReportReview> findAllReportReviews() {
		return store.selectAllReportReview();
	}

	@Override
	public void registReportReview(ReportReview reportReview) {
		store.createReportReview(reportReview);
	}

	@Override
	public void removeReportReview(int reviewId) {
		store.deleteReportReview(reviewId);
	}
	
	

}
