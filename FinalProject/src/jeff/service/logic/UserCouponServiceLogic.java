package jeff.service.logic;

import java.util.List;

import org.springframework.stereotype.Service;

import jeff.service.UserCouponService;
import jeff.store.UserCouponStore;

@Service
public class UserCouponServiceLogic implements UserCouponService{
	
	private UserCouponStore store;

	@Override
	public boolean registUserCoupon(String userId, int couponId) {
		return store.createUserCoupon(userId, couponId);
	}

	@Override
	public void removeUserCoupon(String userId, int couponId) {
		store.deleteUserCoupon(userId, couponId);
	}

	@Override
	public List<Integer> findUserCoupons(String userId) {
		return store.selectUserCoupon(userId);
	}

	@Override
	public void useUserCoupon(String userId, int couponId) {
		store.useUserCoupon(userId, couponId);
		
	}

}
