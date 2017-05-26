package jeff.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jeff.service.UserCouponService;

@Controller
public class UserCouponController {
	
	@Autowired
	private UserCouponService service;
	

}
