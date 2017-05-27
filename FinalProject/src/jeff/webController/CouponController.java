package jeff.webController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jeff.domain.Coupon;
import jeff.service.CouponService;

@Controller
@RequestMapping("/coupon")
public class CouponController {

	@Autowired
	private CouponService service;
	
	@RequestMapping("find")
	public ModelAndView FindCoupon(int couponId){
		Coupon coupon = service.findCoupon(couponId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("couponDetail.jsp");
		modelAndView.addObject("coupon", coupon);
		return modelAndView;
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String registCoupon(Coupon coupon){
		service.registCoupon(coupon);
		return "redirect:~~~~~~~MyPage?comId=" + coupon.getComId();
	}
	
	@RequestMapping(value="/remove")
	public String removeCoupon(int couponId,HttpServletRequest req){
		 HttpSession session = req.getSession(false);
		 String comId = (String)session.getAttribute("comId");
		 if(comId == null){
			 session.invalidate();
		 }
		service.removeCoupon(couponId);
		return "redirect:~~~~~~~MyPage?comId=" + comId;
	}
	//잠시스탑
//	public String modifyCoupon(Coupon coupon){
//		
//	}
	
}
