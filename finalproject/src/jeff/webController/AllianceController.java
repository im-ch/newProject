package jeff.webController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jeff.domain.Alliance;
import jeff.domain.Company;
import jeff.domain.CompanyImage;
import jeff.domain.Coupon;
import jeff.domain.Review;
import jeff.service.AllianceService;
import jeff.service.CompanyImageService;
import jeff.service.CompanyService;
import jeff.service.CouponService;
import jeff.service.ReviewService;

@Controller
@RequestMapping("alliance")
public class AllianceController {

	@Autowired
	private AllianceService service;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private CompanyImageService imgService;

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private CouponService couponService;

	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String registAlliance(Model model, HttpServletRequest req) {

		HttpSession session = req.getSession();
		String comId = (String) session.getAttribute("comId");
		Company company = companyService.findCompany(comId);

		String[] lo = company.getLocation().split(";");
		company.setLocation("[" + lo[0] + "] " + lo[1] + " " + lo[2]);

		model.addAttribute("company", company);

		return "/allianceForm";
	}

	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String registAlliance(Alliance alliance, HttpServletRequest req) {
		HttpSession session = req.getSession();
		String comId = (String) session.getAttribute("comId");
		Company company = companyService.findCompany(comId);
		alliance.setCompany(company);
		service.registAlliance(alliance);
		return "redirect:detail?comId=" + comId;
	}

	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String updateAlliance(String comId, Model model) {

		Alliance alliance = service.findAlliance(comId);
		model.addAttribute("alliance", alliance);

		return "/allianceModify";
	}

	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String updateAlliance(Alliance alliance, HttpServletRequest req) {
		HttpSession session = req.getSession();
		String comId = (String) session.getAttribute("comId");
		alliance.setCompany(companyService.findCompany(comId));
		service.updateAlliance(alliance);
		return "redirect:detail?comId=" + comId;
	}

	@RequestMapping("delete")
	public String removeAlliance(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String comId = (String) session.getAttribute("comId");
		service.removeAlliance(comId);

		return "redirect:/views/main.jsp";
	}

	// 기업이 자신의 제휴제안서 볼 때 메소드
	@RequestMapping("detail")
	public ModelAndView allianceDetail(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String comId = (String) session.getAttribute("comId");
		ModelAndView modelAndView = new ModelAndView("allianceDetail");
		Alliance alliance = service.findAlliance(comId);
		Company company = alliance.getCompany();
		String[] lo = company.getLocation().split(";");
		company.setLocation("[" + lo[0] + "] " + lo[1] + " " + lo[2]);
		alliance.setCompany(company);

		modelAndView.addObject("alliance", alliance);
		return modelAndView;
	}

	// 관리자가 기업 제휴제안서 볼 때 메소드
	@RequestMapping("findComId")
	public ModelAndView allianceDetail(@RequestParam("comId") String comId) {
		ModelAndView modelAndView = new ModelAndView("allianceDetail");
		Alliance alliance = service.findAlliance(comId);
		Company company = alliance.getCompany();
		String[] lo = company.getLocation().split(";");
		company.setLocation("[" + lo[0] + "] " + lo[1] + " " + lo[2]);
		alliance.setCompany(company);
		modelAndView.addObject("alliance", alliance);
		return modelAndView;
	}

	@RequestMapping(value = "companyDetail")
	public String detailAllianceCompany(String comId, Model model, HttpServletRequest req) {

		Alliance alliance = service.findAlliance(comId);
		List<Review> review = reviewService.findAllReview(comId);
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		List<CompanyImage> img = imgService.findCompanyImageList(comId);

		couponService.removeExprCoupon();

		List<Coupon> couponList = couponService.findCouponByCompany(comId);

		model.addAttribute("coupon", couponList);
		model.addAttribute("images", img);
		model.addAttribute("userId", userId);
		model.addAttribute("alliance", alliance);
		model.addAttribute("review", review);
		return "companyDetail";
	}
	

}
