import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import jeff.domain.ReportReview;
import jeff.store.ReportReviewStore;
import jeff.store.logic.ReportReviewStoreLogic;

public class ReportReviewStoreTest {

	private ReportReviewStore store;
	
	@Before
	public void setUp(){
		store = new ReportReviewStoreLogic();
	}
//	@Test
//	public void registReportTest(){
//		ReportReview rr = new ReportReview();
//		rr.setReportReason("테스트");
//		store.createReportReview(rr);
//	}
//	@Test
//	public void deleteReportTest(){
//		store.deleteReportReview(1);
//	}
//	@Test
//	public void seleteReportTest(){
//		
//		
//		assertEquals(2, store.selectReportReview(2).getReviewId());
//	}
	@Test
	public void selectAll(){
		assertEquals(2, store.selectAllReportReview().size());
	}
}
