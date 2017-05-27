package jeff.store.mapper;

import java.util.List;

import jeff.domain.Coupon;

public interface CouponMapper {
	
	void createCoupon(Coupon coupon);

	void deleteCoupon(int couponId);

	void modifyCoupon(Coupon coupon);

	List<Coupon> selectAllCoupon();
	
	List<Coupon> selectCouponByCompany(String companyId);
	
	Coupon selectCoupon (int couponId);
	
	void deleteExprCoupon();

}
