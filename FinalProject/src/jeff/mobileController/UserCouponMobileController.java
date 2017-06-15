package jeff.mobileController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jeff.domain.Company;
import jeff.domain.CompanyImage;
import jeff.domain.Coupon;
import jeff.domain.MobileCoupon;
import jeff.domain.MobileCoupons;
import jeff.service.CompanyImageService;
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
   @Autowired
   private CompanyImageService cis;

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
   public @ResponseBody MobileCoupons findCouponByUser(String userId, HttpServletRequest req) {
   
      List<Integer> list = userCouponService.findUserCoupons(userId);
      List<MobileCoupon> coupon = new ArrayList<>();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      for (int i = 0; i < list.size(); i++) {
    	  Coupon c = couponService.findCoupon(list.get(i));
    	  Company com = companyService.findCompany(c.getComId());
    	  CompanyImage ci =cis.findCompanyImage(c.getComId());
    	  MobileCoupon mcoupon = new MobileCoupon();
//    	  comId에 companyName data 보냄
    	  mcoupon.setComId(com.getComName());
    	  mcoupon.setCouponContent(c.getCouponContent());
    	  mcoupon.setCouponName(c.getCouponName());
    	  mcoupon.setCouponId(c.getCouponId());
    	  mcoupon.setExpiryDate(sdf.format(c.getExpiryDate()));
    	  if(ci != null){
//    		  절대경로로 지정 불가 상대경로 지정
//    		  mcoupon.setImgUrl(req.getContextPath()+ "resources/images/" + ci.getFileName());
    		  mcoupon.setImgUrl(req.getContextPath()+ "/resources/images/restaurant.jpg");
    	  }else{
    		  mcoupon.setImgUrl(req.getContextPath() + "/resources/images/noimage.png");
    	  }
    	  coupon.add(mcoupon);
       
      }
      

      MobileCoupons coupons = new MobileCoupons();
      coupons.setmCouponList(coupon);

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