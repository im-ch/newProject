package jeff.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jeff.domain.Review;
import jeff.store.ReviewStore;
import jeff.store.mapper.ReviewMapper;

@Repository
public class ReviewStoreLogic implements ReviewStore{

	@Override
	public void createReview(Review review) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		ReviewMapper mapper = session.getMapper(ReviewMapper.class);
		mapper.createReview(review);
		session.close();
	}

	@Override
	public void modifyReview(Review review) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		ReviewMapper mapper = session.getMapper(ReviewMapper.class);
		mapper.modifyReview(review);
		session.close();
	}

	@Override
	public void deleteReview(int reviewId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		ReviewMapper mapper = session.getMapper(ReviewMapper.class);
		mapper.deleteReview(reviewId);
		session.close();
	}

	@Override
	public Review selectReviewByReviewId(int reviewId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		ReviewMapper mapper = session.getMapper(ReviewMapper.class);
		Review review = null;
		review = mapper.selectReviewByReviewId(reviewId);
		session.close();
		return review;
	}

	@Override
	public List<Review> selectReviewByCompany(String companyId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		ReviewMapper mapper = session.getMapper(ReviewMapper.class);
		List<Review> reviews = null;
		reviews = mapper.selectReviewByCompany(companyId);
		session.close();
		return reviews;
	}

}
