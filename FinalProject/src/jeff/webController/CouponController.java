package jeff.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jeff.domain.Coupon;
import jeff.service.CouponService;

@Controller
public class CouponController {

	@Autowired
	private CouponService service;
	
	@RequestMapping("Coupon")
	public ModelAndView FindCoupon(int couponId){
		Coupon coupon = service.findCoupon(couponId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("couponDetail.jsp");
		modelAndView.addObject("coupon", coupon);
		return modelAndView;
	}
	
	@RequestMapping("registCoupon")
	public String registCoupon(Coupon coupon){
		service.registCoupon(coupon);
		return "redirect:~~~~~~~companyDetail";
	}
	
	
}
