package jeff.webController;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jeff.domain.Coupon;
import jeff.service.CouponService;
import jeff.service.UserCouponService;

@RequestMapping(value="userCoupon")
@Controller
public class UserCouponController {

	@Autowired
	private UserCouponService userCouponService;

	@Autowired
	private CouponService couponService;

	@RequestMapping(value = "/register")
	public String registCoupon(HttpServletRequest req, int couponId) {

		HttpSession session = req.getSession();

		if (session == null || session.getAttribute("userId") == null) {
			return "redirect:login.jsp";
		}

		String userId = (String) session.getAttribute("userId");

		List<Integer> list = userCouponService.findUserCoupons(userId);

		for (int i = 0; i < list.size(); i++) {
			if (couponId == list.get(i)) {
				System.out.println("이미 등록된 쿠폰입니다.");
				return "alliance/companyDetail";
			}
		}

		userCouponService.registUserCoupon(userId, couponId);
		return "redirect:userCoupon/myCoupons";

	}

	@RequestMapping(value = "/detailCoupon")
	public ModelAndView findCouponByCouponId(int couponId) {
		ModelAndView modelAndView = new ModelAndView("couponDetail.jsp");
		Coupon coupon = couponService.findCoupon(couponId);
		modelAndView.addObject("coupon", coupon);
		return modelAndView;
	}

	@RequestMapping(value = "/myCoupons")
	public String findCouponByUser(HttpServletRequest req, Model model) {

		HttpSession session = req.getSession();

		if (session == null || session.getAttribute("userId") == null) {
			return "redirect:login.jsp";
		}
		String userId = (String) session.getAttribute("userId");
		List<Integer> list = userCouponService.findUserCoupons(userId);
		List<Coupon> coupons = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			coupons.add(couponService.findCoupon(list.get(i)));
		}

		model.addAttribute("coupon", coupons);

		return "userMycoupon.jsp";
	}

	@RequestMapping(value = "/remove")
	public String removeCoupon(HttpServletRequest req, int couponId) {
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");

		userCouponService.removeUserCoupon(userId, couponId);

		return "redirect:userCoupon/myCoupons";
	}

	@RequestMapping(value = "/use")
	public String useCoupon(HttpServletRequest req, int couponId) {
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		
		userCouponService.useUserCoupon(userId, couponId);
		
		return "redirect:userCoupon/myCoupons";
	}

}
