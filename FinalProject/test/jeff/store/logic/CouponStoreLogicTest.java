package jeff.store.logic;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jeff.domain.Coupon;

public class CouponStoreLogicTest {

	private CouponStoreLogic store;

	@Before
	public void setUp() {
		store = new CouponStoreLogic();
	}

	@Test
	public void testDeleteExprCoupon() {
		store.deleteExprCoupon();
		List<Coupon> list = store.selectAllCoupon();
		
		assertEquals(list.size(), 3);
	}

}
