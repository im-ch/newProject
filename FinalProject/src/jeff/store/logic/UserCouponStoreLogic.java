package jeff.store.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jeff.store.UserCouponStore;
import jeff.store.mapper.InterestingCompanyMapper;
import jeff.store.mapper.UserCouponMapper;

@Repository
public class UserCouponStoreLogic implements UserCouponStore {

	@Override
	public boolean createUserCoupon(String userId, int couponId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		UserCouponMapper mapper = session.getMapper(UserCouponMapper.class);
		boolean b = mapper.createUserCoupon(userId, couponId);
		session.close();
		return b;
	}

	@Override
	public void deleteUserCoupon(String userId, int couponId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		UserCouponMapper mapper = session.getMapper(UserCouponMapper.class);
		mapper.deleteUserCoupon(userId, couponId);
		session.close();

	}

	@Override
	public void useUserCoupon(String userId, int couponId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		UserCouponMapper mapper = session.getMapper(UserCouponMapper.class);
		mapper.deleteUserCoupon(userId, couponId);
		session.close();
	}

	@Override
	public List<Integer> selectUserCoupon(String userId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		UserCouponMapper mapper = session.getMapper(UserCouponMapper.class);
		List<Integer> list = new ArrayList<>();
		list = mapper.selectUserCoupon(userId);

		session.close();

		return list;
	}

}
