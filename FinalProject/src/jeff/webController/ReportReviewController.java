package jeff.webController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jeff.domain.ReportReview;
import jeff.domain.Review;
import jeff.service.ReportReviewService;
import jeff.service.ReviewService;

@RequestMapping("reportReview")
@Controller
public class ReportReviewController {

	@Autowired
	private ReportReviewService service;

	@Autowired
	private ReviewService reviewService;

	@RequestMapping(value = "find")
	public String findReportReview(int reviewId, Model model) {
		ReportReview reportReview = service.findReportReview(reviewId);
		model.addAttribute("reportReview", reportReview);
		return "report";
	}

	@RequestMapping(value = "findList")
	public String findAllReportReviews(Model model) {
		List<ReportReview> list = service.findAllReportReviews();
		List<Review> reviewList = new ArrayList<>();

		for (ReportReview r : list) {
			Review review = reviewService.findReviewByReviewId(r.getReviewId());
			reviewList.add(review);
		}

		model.addAttribute("reviews", reviewList);
		model.addAttribute("reportReviewList", list);
		return "reportedReviewList";
	}

	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String registReportReview(ReportReview reportReview, String comId) {

		if (service.findReportReview(reportReview.getReviewId()) != null) {
			return "redirect:/alliance/companyDetail?comId=" + comId;
		} else {

			service.registReportReview(reportReview);

			Review review = reviewService.findReviewByReviewId(reportReview.getReviewId());
			review.setReported(true);
			reviewService.updateReviewReport(review);
			
			return "redirect:/alliance/companyDetail?comId=" + comId;
		}
	}

	@RequestMapping(value = "/remove")
	public String removeReportReview(int reviewId) {
		service.removeReportReview(reviewId);
		return "findList";
	}

}
