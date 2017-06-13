package jeff.mobileController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jeff.domain.Company;
import jeff.domain.Coupon;
import jeff.domain.Coupons;
import jeff.service.CompanyService;
import jeff.service.CouponService;
import jeff.service.UserCouponService;

@RequestMapping(value = "mobile/userCoupon")
@Controller
public class UserCouponMobileController {
	@Autowired
	private UserCouponService userCouponService;

	@Autowired
	private CouponService couponService;

	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/register")
	public @ResponseBody String registCoupon(HttpServletRequest req, int couponId) {

		HttpSession session = req.getSession();

		if (session == null || session.getAttribute("userId") == null) {
			return "login";
		}

		String userId = (String) session.getAttribute("userId");

		List<Integer> list = userCouponService.findUserCoupons(userId);

		for (int i = 0; i < list.size(); i++) {
			if (couponId == list.get(i)) {
				return "false";
			}
		}

		userCouponService.registUserCoupon(userId, couponId);
		
		return "true";

	}

	@RequestMapping(value = "/detailCoupon", produces = "application/xml")
	public @ResponseBody Company findCouponByCouponId(int couponId) {
		Coupon coupon = couponService.findCoupon(couponId);
		Company company = companyService.findCompany(coupon.getComId());
		return company;
	}

	@RequestMapping(value = "/myCoupons", produces = "application/xml")
	public @ResponseBody Coupons findCouponByUser(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();

		if (session == null || session.getAttribute("userId") == null) {
			return null;
		}
		String userId = (String) session.getAttribute("userId");
		List<Integer> list = userCouponService.findUserCoupons(userId);
		List<Coupon> coupon = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			coupon.add(couponService.findCoupon(list.get(i)));
		}

		Coupons coupons = new Coupons();
		coupons.setCouponList(coupon);

		return coupons;
	}

	@RequestMapping(value = "/use")
	public @ResponseBody String useCoupon(HttpServletRequest req, int couponId) {
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		userCouponService.useUserCoupon(userId, couponId);
		return "true";
	}

}
