package jeff.service;

import java.util.List;

import jeff.domain.Review;

public interface ReviewService {

	public void registReview(Review review);
	public void removeReview(int reviewId);
	public void updateReview(Review review);
	public List<Review> findReviewByCompany(String companyId);
	public Review findReviewByReviewId(int reviewId);
}
