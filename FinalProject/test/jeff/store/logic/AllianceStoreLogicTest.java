package jeff.store.logic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jeff.domain.Alliance;
import jeff.domain.Company;
import jeff.domain.Coupon;
import jeff.domain.Coupons;

public class AllianceStoreLogicTest {
	
	private AllianceStoreLogic store;
	
	@Before
	public void AllianceStoreLogicTest() {
		store = new AllianceStoreLogic();
	}
//
//	@Test
//	public void testSelectAlliance() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testSelectAllAlliance() {
//		List<String> list = store.selectAllAlliance();
//		
//		assertEquals(4, list.size());
//	}

	@Test
	public void testCreateAlliance() {
		Alliance alliance = new Alliance();
		alliance.setDetail("dfsdf");
		alliance.setOpeningHours("55");
		alliance.setBusinessNumber(6565);
		Company company = new Company();
		company.setComId("fff");
		company.setComName("sdff");
		company.setComPassword("dfdf");
		company.setComEmail("sdfs");
		company.setComPhoneNumber(324324);
		company.setLocation("sdfsdf");
		company.setOwnerName("asdf");
		Coupons coupons = new Coupons();
		company.setCouponList(coupons);
		alliance.setCompany(company);
		
		store.createAlliance(alliance);
//		assertEquals("dfsdf", store.selectAlliance("fff"));
	}

//	@Test
//	public void testDeleteAlliance() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testModifyAlliance() {
//		fail("Not yet implemented");
//	}

}
