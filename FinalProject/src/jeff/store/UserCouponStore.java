package jeff.store;

import java.util.List;

import jeff.domain.Coupon;

public interface UserCouponStore {

	boolean createUserCoupon(String userId, int couponId);

	void deleteUserCoupon(String userId, int couponId);

	void useUserCoupon(String userId, int couponId);

	List<Integer> selectUserCoupon(String userId);

}
