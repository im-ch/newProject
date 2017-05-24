package jeff.service.logic;

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
		store.createReview(review);
	}

	@Override
	public void removeReview(int reviewId) {
		store.deleteReview(reviewId);
	}

	@Override
	public void updateReview(Review review) {
		store.modifyReview(review);
	}

	@Override
	public List<Review> findReviewByCompany(String companyId) {
		return store.selectReviewByCompany(companyId);
	}

	@Override
	public Review findReviewByReviewId(int reviewId) {
		return store.selectReviewByReviewId(reviewId);
	}
	
}
