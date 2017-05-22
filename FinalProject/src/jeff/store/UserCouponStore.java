package jeff.store;

import java.util.List;

import jeff.domain.Coupon;

public interface UserCouponStore {

	boolean createUserCoupon(String userId, int couponId);

	void deleteUserCoupon(String userId, int couponId);
	
	Coupon selectCoupon (int couponId);
	
	void useUserCoupon (String userId, int couponId);
	
	List<Coupon> selectUserCoupon(String userId);
	
	void deleteExprCoupon (List<Integer> couponIds, String userId);
	
}
