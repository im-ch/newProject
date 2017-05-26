package jeff.store;


import jeff.domain.Review;

public interface ReviewStore {

	void createReview(Review review);

	void modifyReview(Review review);

	void deleteReview(int reviewId);

//	Review selectReviewByReviewId(int reviewId);


}
