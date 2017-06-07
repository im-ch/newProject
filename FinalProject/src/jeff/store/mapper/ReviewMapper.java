package jeff.store.mapper;

import java.util.List;

import jeff.domain.Review;

public interface ReviewMapper {
	
	void createReview(Review review);

	void modifyReview(Review review);

	void deleteReview(int reviewId);

	Review selectReviewByReviewId(int reviewId);


}
