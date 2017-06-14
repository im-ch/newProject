package jeff.service.logic;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jeff.domain.Coupon;
import jeff.service.CouponService;
import jeff.store.CouponStore;
import jeff.store.PaymentStore;

@Service
public class CouponServiceLogic implements CouponService {

	@Autowired
	private CouponStore couponStore;
	
	@Autowired
	private PaymentStore paymentStore;

	@Override
	public void registCoupon(Coupon coupon) {
		couponStore.createCoupon(coupon);
		HashMap<String, Object> map = new HashMap<>();
		map.put("comId", coupon.getComId());
		map.put("couponId", coupon.getCouponId());
		paymentStore.createPayment(map);
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
		return list;
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
