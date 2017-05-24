package jeff.store.logic;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jeff.store.UserCouponStore;

public class UserCouponStoreLogicTest {
	
	private UserCouponStoreLogic store;
	
	@Before
	public void setUp() {
		store = new UserCouponStoreLogic();
	}

//	@Test
//	public void testCreateUserCoupon() {
//		String userId = "heehyun";
//		int couponId = 3;
//		
//		store.createUserCoupon(userId, couponId);
//		
//	}

//	@Test
//	public void testDeleteUserCoupon() {
//		String userId = "heehyun";
//		int couponId = 2;
//		
//		store.deleteUserCoupon(userId, couponId);
//	}

//	@Test
//	public void testSelectCoupon() {
//		
//		String userId = "heehyun";
//		List<Integer> list = store.selectUserCoupon(userId);
//		
//		assertEquals(list.size(), 2);
//		
//	}
//
//	@Test
//	public void testUseUserCoupon() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectUserCoupon() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteExprCoupon() {
//		fail("Not yet implemented");
//	}

}
