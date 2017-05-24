package jeff.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jeff.domain.ReportReview;
import jeff.store.ReportReviewStore;
import jeff.store.mapper.ReportReviewMapper;

@Repository
public class ReportReviewStoreLogic implements ReportReviewStore{

	@Override
	public ReportReview selectReportReview(int reviewId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		ReportReviewMapper mapper = session.getMapper(ReportReviewMapper.class);
		ReportReview reportReview = mapper.selectReportReview(reviewId);
		return reportReview;
	}

	@Override
	public List<ReportReview> selectAllReportReview() {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		ReportReviewMapper mapper = session.getMapper(ReportReviewMapper.class);
		List<ReportReview> list = mapper.selectAllReportReview();
		return list;
	}

	@Override
	public void createReportReview(ReportReview reportReview) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		ReportReviewMapper mapper = session.getMapper(ReportReviewMapper.class);
		mapper.createReportReview(reportReview);
	}

	@Override
	public void deleteReportReview(int reviewId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		ReportReviewMapper mapper = session.getMapper(ReportReviewMapper.class);
		mapper.deleteReportReview(reviewId);
	}

}
