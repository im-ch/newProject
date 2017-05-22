package jeff.store.logic;

import java.util.List;

import org.springframework.stereotype.Repository;

import jeff.domain.Coupon;
import jeff.store.CouponStore;

@Repository
public class CouponStoreLogic implements CouponStore{

	@Override
	public void createCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCoupon(int couponId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Coupon> selectAllCoupon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coupon> selectCouponByCompany(String companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coupon selectCoupon(int couponId) {
		// TODO Auto-generated method stub
		return null;
	}

}
