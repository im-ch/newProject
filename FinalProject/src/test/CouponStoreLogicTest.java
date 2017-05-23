package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import jeff.domain.Company;
import jeff.domain.Coupon;
import jeff.store.logic.CouponStoreLogic;

public class CouponStoreLogicTest {

	private CouponStoreLogic store;
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

	@Before
	public void setUp(){
		store = new CouponStoreLogic();
	}
//	@Test
//	public void registCouponTest(){
//		Coupon c = new Coupon();
//		Company com = new Company();
//		com.setComId("123");
//		c.setCouponContent("안녕");
//		c.setCouponName("500원할인");
//		c.setCom(com);
//		store.createCoupon(c);
//	}
//	@Test
//	public void deleteCouponTest(){
//		store.deleteCoupon(2);
//	}
	@Test
	public void modifyCouponTest(){
		Coupon c = new Coupon();
		Company com = new Company();
		c.setCouponId(1);
		com.setComId("1234");
		c.setCouponContent("안녕수정");
		c.setCouponName("500원할인수정");
		c.setCom(com);
		store.modifyCoupon(c);
	
	}
	
	private void sysout() {
		// TODO Auto-generated method stub

	}
	
}
