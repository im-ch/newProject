package jeff.store.logic;

import java.util.List;

import org.springframework.stereotype.Repository;

import jeff.domain.Review;
import jeff.store.ReviewStore;

@Repository
public class ReviewStoreLogic implements ReviewStore{

	@Override
	public void createReview(Review review) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyReview(Review review) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReview(int reviewId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Review selectReviewByReviewId(int reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> selectReviewByCompany(String companyId) {
		// TODO Auto-generated method stub
		return null;
	}

}
