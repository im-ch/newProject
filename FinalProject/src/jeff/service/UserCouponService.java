package jeff.service;

import java.util.List;

public interface UserCouponService {

	public boolean registUserCoupon(String userId, int couponId);

	public void removeUserCoupon(String userId, int couponId);

	public List<Integer> findUserCoupons(String userId);

	public void useUserCoupon(String userId, int couponId);

}
