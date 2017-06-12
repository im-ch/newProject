package jeff.webController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jeff.domain.Company;
import jeff.domain.Review;
import jeff.service.CompanyService;
import jeff.service.ReviewService;

@Controller
@RequestMapping("review")
public class ReviewController {

	@Autowired
	private ReviewService service;

	@Autowired
	private CompanyService companyService;

	// comId를 히든으로 받아오면 리뷰에 자동으로 넣어진다는 가정
	@RequestMapping(value = "/regist", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String registReview(Review review, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		String userId = null;
		if (session != null) {
			userId = (String) session.getAttribute("userId");
		} else{
			return "login";
		}
		
		if(review.getContent().equals("content=")){
			return "null";
		}
		
		String content = review.getContent().split("=")[1];
		
		try {
			content = URLDecoder.decode(content, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		review.setContent(content);

		review.setReported(false);
		review.setUserId(userId);
		service.registReview(review);
		return "regist";
	}

	@RequestMapping("/remove")
	public @ResponseBody String removeReview(int reviewId, String comId) {
		service.removeReview(reviewId);
		return "remove";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody String upateReview(Review review, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		String userId = null;
		if (session != null) {
			userId = (String) session.getAttribute("userId");
		}
		review.setUserId(userId);
		service.updateReview(review);
		return "update";
	}

	@RequestMapping(value = "find", method = RequestMethod.GET)
	public String findReviewByReviewId(int reviewId, HttpServletRequest req, Model model) {

		Review review = service.findReviewByReviewId(reviewId);
		model.addAttribute("review", review);
		return "report";
	}

}