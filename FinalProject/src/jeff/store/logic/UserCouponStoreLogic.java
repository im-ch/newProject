package jeff.store.logic;

import java.util.List;

import org.springframework.stereotype.Repository;

import jeff.domain.Coupon;
import jeff.store.UserCouponStore;

@Repository
public class UserCouponStoreLogic implements UserCouponStore{

	@Override
	public boolean createUserCoupon(String userId, int couponId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteUserCoupon(String userId, int couponId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Coupon selectCoupon(int couponId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void useUserCoupon(String userId, int couponId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Coupon> selectUserCoupon(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteExprCoupon(List<Integer> couponIds, String userId) {
		// TODO Auto-generated method stub
		
	}

}
