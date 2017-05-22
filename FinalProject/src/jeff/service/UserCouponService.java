package jeff.service;

import java.util.List;

import jeff.domain.Coupon;

public interface UserCouponService {

	public boolean registUserCoupon(String userId, int couponId);
	public void removeUserCoupon(String userId, int couponId);
	public List<Coupon> findUserCoupons(String userId);
	public void useUserCoupon(String userId, int couponId);
	public Coupon findCoupon(String userId, int couponId);
	public void removeExprUserCoupons(String userId, List<Integer> couponIdList);
	
}
