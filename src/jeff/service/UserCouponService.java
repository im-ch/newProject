package jeff.service;

public interface UserCouponService {

	public boolean registUserCoupon(String userId, int couponId);
	public void removeUserCoupon(String userId, int couponId);
	public List<Coupon> findUserCoupons(String userId);
	public void useUserCoupon(String userId, int couponId);
	public Coupon findCoupon(String userId, int couponId);
	public void removeExprUserCoupons(String userId, List<Integer> couponIdList);
	
}
