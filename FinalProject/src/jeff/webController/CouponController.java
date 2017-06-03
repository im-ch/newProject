package jeff.webController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jeff.domain.Coupon;
import jeff.service.CouponService;

@Controller
@RequestMapping("coupon")
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
	
	@RequestMapping(value="regist", method=RequestMethod.POST)
	public String registCoupon(Coupon coupon, HttpServletRequest req){
//		HttpSession session = req.getSession();
		
//		if (session == null || session.getAttribute("comId") == null) {
//			return "redirect:login.jsp";
//		}
//		String comId = (String) session.getAttribute("comId");
		coupon.setComId("111");
		System.out.println(coupon.getExpiryDate());
		service.registCoupon(coupon);
//		return "redirect:~~~~~~~MyPage?comId=" + coupon.getComId();
		return "redirect:findList";
	}
	
	@RequestMapping(value="remove")
	public String removeCoupon(int couponId,HttpServletRequest req){
//		 HttpSession session = req.getSession(false);
//		 String comId = (String)session.getAttribute("comId");
//		 if(comId == null){
//			 session.invalidate();
//		 }
		service.removeCoupon(couponId);
		return "redirect:findList";
	}
	//잠시스탑
	@RequestMapping("modify")
	public String modifyCoupon(int couponId, Model model){
		
		Coupon coupon = service.findCoupon(couponId);
		Date originalInput = coupon.getExpiryDate();
//		String originalInput = "01/06/2017";
		//형식 선언
		SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat  newFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat test = new SimpleDateFormat("dd/MM/yyyy");
			try {
				
				String parseDate = newFormat.format(originalInput);
				Date newDate = newFormat.parse(parseDate);
				
				java.sql.Date sql = new java.sql.Date(newDate.getTime());
				coupon.setExpiryDate(sql);
//				
//				System.out.println(sql);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		model.addAttribute("coupon", coupon);
		return "modifyCoupon";
	}
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modifyCoupon(Coupon coupon){
		System.out.println(coupon.getExpiryDate());
		System.out.println(coupon.getCouponId());
		service.updateCoupon(coupon);
		return "redirect:findList";
	}
	@RequestMapping("findList")
	public String findCouponBycompany(HttpServletRequest req, Model model){
//		HttpSession session = req.getSession();
//		
//		if (session == null || session.getAttribute("comId") == null) {
//			return "redirect:login.jsp";
//		}
//		String comId = (String) session.getAttribute("comId");
		List<Coupon> list = service.findCouponByCompany("111");
		model.addAttribute("couponList", list);
		
		return "companyCouponList";
		
	}
}
