package jeff.webController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jeff.domain.ReportReview;
import jeff.service.ReportReviewService;
@RequestMapping("/reportReview")
@Controller
public class ReportReviewController {
	
	@Autowired
	private ReportReviewService service;
	
	@RequestMapping(value="/find")
	public String findReportReview(int reviewId, Model model){
		ReportReview reportReview = service.findReportReview(reviewId);
		model.addAttribute("reportReview", reportReview);
		return "reportReview.jsp";
	}
	
	@RequestMapping(value="/findList")
	public String findAllReportReviews(Model model){
		List<ReportReview> list = service.findAllReportReviews();
		model.addAttribute("reportReviewList", list);
		return "reportReviewList.jsp";
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String registReportReview(ReportReview reportReview, String comId){
		service.registReportReview(reportReview);
		return "redirect:~~/companyDetail?comId=" + comId;
	}
	
	@RequestMapping(value="/remove")
	public String removeReportReview(int reviewId){
		service.removeReportReview(reviewId);
		return "reportReviewList.jsp";
	}

}
