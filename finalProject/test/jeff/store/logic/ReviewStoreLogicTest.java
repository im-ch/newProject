package jeff.store.logic;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jeff.domain.Review;
import jeff.store.ReviewStore;

public class ReviewStoreLogicTest {
	
	private ReviewStore store;
	
	@Before
	public void ReviewStoreLogicTest() {
		store = new ReviewStoreLogic();
	}

//	@Test
//	public void testCreateReview() {
//		Review r = new Review();
//		r.setCompanyId("11");
//		r.setUserId("11");
//		r.setContent("gggg");
//		r.setReviewId(1);
//		r.setReported(false);
//		store.createReview(r);
//	}

//	@Test
//	public void testModifyReview() {
//		Review r = store.selectReviewByReviewId(2);
//		r.setContent("aaa");
//		store.modifyReview(r);
//	}

//	@Test
//	public void testDeleteReview() {
//		store.deleteReview(2);
//	}

//	@Test
//	public void testSelectReviewByReviewId() {
//		Review r = store.selectReviewByReviewId(1);
//		assertEquals("11", r.getUserId());
//	}

//	@Test
//	public void testSelectAllReview() {
//		List<Review> list = store.selectReviewByCompany("111");
//		assertEquals(3, list.size());
//	}

}
