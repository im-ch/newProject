package jeff.webController;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@RequestMapping(value = "/detailCoupon")
	public ModelAndView findCouponByCouponId(int couponId) {
		ModelAndView modelAndView = new ModelAndView("couponDetail.jsp");
		Coupon coupon = couponService.findCoupon(couponId);
		modelAndView.addObject("coupon", coupon);
		return modelAndView;
	}

	@RequestMapping(value = "/myCoupons")
	public String findCouponByUser(HttpServletRequest req, Model model) {
		System.out.println("컨");
		HttpSession session = req.getSession();

		if (session == null || session.getAttribute("userId") == null) {
			return "redirect:login.jsp";
		}
		String userId = (String) session.getAttribute("userId");
		List<Integer> list = userCouponService.findUserCoupons(userId);
		List<Coupon> coupons = new ArrayList<>();
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			coupons.add(couponService.findCoupon(list.get(i)));
		}
		
		System.out.println(coupons.size());
		model.addAttribute("coupon", coupons);

		return "userCouponList";
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
