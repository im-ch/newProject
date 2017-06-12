package jeff.service.logic;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jeff.domain.Review;
import jeff.service.ReviewService;
import jeff.store.ReviewStore;

@Service
public class ReviewServiceLogic implements ReviewService{
	
	@Autowired
	private ReviewStore store;

	@Override
	public void registReview(Review review) {
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		review.setRegDate(today);
		store.createReview(review);
	}

	@Override
	public void removeReview(int reviewId) {
		store.deleteReview(reviewId);
	}

	@Override
	public void updateReview(Review review) {
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		review.setRegDate(today);
		store.modifyReview(review);
	}

	@Override
	public Review findReviewByReviewId(int reviewId) {
		return store.selectReviewByReviewId(reviewId);
	}

	@Override
	public List<Review> findAllReview(String comId) {
		return store.selectAllReview(comId);
	}

	@Override
	public void updateReviewReport(Review review) {
		store.modifyReviewReport(review);
	}
}
