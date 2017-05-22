package jeff.service;

public interface CouponService {

	public void registCoupon(Coupon coupon);
	public void removeCoupon(int couponId);
	public void updateCoupon(Coupon coupon);
	public List<Coupon> findCouponByCompany(String companyId);
	public Coupon findCoupon(int couponId);
}
