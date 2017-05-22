package jeff.service;

import java.util.List;

import jeff.domain.Coupon;

public interface CouponService {

	public void registCoupon(Coupon coupon);
	public void removeCoupon(int couponId);
	public void updateCoupon(Coupon coupon);
	public List<Coupon> findCouponByCompany(String companyId);
	public Coupon findCoupon(int couponId);
}
