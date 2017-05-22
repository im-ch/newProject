package jeff.service.logic;

import java.util.List;

import jeff.domain.Coupon;
import jeff.service.UserCouponService;

public class UserCouponServiceLogic implements UserCouponService{

	@Override
	public boolean registUserCoupon(String userId, int couponId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeUserCoupon(String userId, int couponId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Coupon> findUserCoupons(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void useUserCoupon(String userId, int couponId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Coupon findCoupon(String userId, int couponId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeExprUserCoupons(String userId, List<Integer> couponIdList) {
		// TODO Auto-generated method stub
		
	}
	
	

}
