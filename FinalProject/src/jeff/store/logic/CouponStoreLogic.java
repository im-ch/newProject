package jeff.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jeff.domain.Coupon;
import jeff.store.CouponStore;
import jeff.store.mapper.CouponMapper;

@Repository
public class CouponStoreLogic implements CouponStore{
	
	
	@Override
	public void createCoupon(Coupon coupon) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		CouponMapper mapper = session.getMapper(CouponMapper.class);
		mapper.createCoupon(coupon);
		session.close();
	}

	@Override
	public void deleteCoupon(int couponId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		CouponMapper mapper = session.getMapper(CouponMapper.class);
		mapper.deleteCoupon(couponId);
		session.close();
	}

	@Override
	public void modifyCoupon(Coupon coupon) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		CouponMapper mapper = session.getMapper(CouponMapper.class);
		mapper.modifyCoupon(coupon);
		session.close();
	}

	@Override
	public List<Coupon> selectAllCoupon() {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		CouponMapper mapper = session.getMapper(CouponMapper.class);
		List<Coupon> list = mapper.selectAllCoupon();
		session.close();
		return list;
	}

	@Override
	public List<Coupon> selectCouponByCompany(String companyId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		CouponMapper mapper = session.getMapper(CouponMapper.class);
		List<Coupon> list = mapper.selectCouponByCompany(companyId);
		session.close();
		return list;
	}

	@Override
	public Coupon selectCoupon(int couponId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		CouponMapper mapper = session.getMapper(CouponMapper.class);
		Coupon coupon = mapper.selectCoupon(couponId);
		session.close();
		return coupon;
	}

}
