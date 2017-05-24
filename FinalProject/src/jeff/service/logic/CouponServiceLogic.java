package jeff.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jeff.domain.Coupon;
import jeff.service.CouponService;
import jeff.store.CouponStore;

@Service
public class CouponServiceLogic implements CouponService {

	@Autowired
	private CouponStore couponStore;

	@Override
	public void registCoupon(Coupon coupon) {
		couponStore.createCoupon(coupon);
	}

	@Override
	public void removeCoupon(int couponId) {
		couponStore.deleteCoupon(couponId);
	}

	@Override
	public void updateCoupon(Coupon coupon) {
		couponStore.modifyCoupon(coupon);
	}

	@Override
	public List<Coupon> findCouponByCompany(String companyId) {
		List<Coupon> list = couponStore.selectCouponByCompany(companyId);
		return null;
	}

	@Override
	public Coupon findCoupon(int couponId) {
		Coupon coupon = couponStore.selectCoupon(couponId);
		return coupon;
	}

	@Override
	public List<Coupon> findAllCoupon() {
		List<Coupon> list = couponStore.selectAllCoupon();
		return list;
	}

	@Override
	public void removeExprCoupon() {
		couponStore.deleteExprCoupon();
	}

}
