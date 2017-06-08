package jeff.webController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jeff.domain.Company;
import jeff.domain.Review;
import jeff.service.CompanyService;
import jeff.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	@Autowired
	private CompanyService companyService;
	//comId를 히든으로 받아오면 리뷰에 자동으로 넣어진다는 가정
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	@ResponseBody
	public Company registReview(Review review, HttpServletRequest req){
		HttpSession session = req.getSession(false);
		String userId = null;
		if(session != null){
			userId = (String)session.getAttribute("userId");
		}
		review.setUserId(userId);
		service.registReview(review);
		Company company = companyService.findCompany(review.getComId());
		return company;
	}
	
	@RequestMapping("/remove")
	@ResponseBody
	public Company removeReview(int reviewId, String comId){
		service.removeReview(reviewId);
		Company company = companyService.findCompany(comId);
		return company;
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	public Company upateReview(Review review, HttpServletRequest req){
		HttpSession session = req.getSession(false);
		String userId = null;
		if(session != null){
			userId = (String)session.getAttribute("userId");
		}
		review.setUserId(userId);
		service.updateReview(review);
		Company company = companyService.findCompany(review.getComId());
		return company;
	}
}
