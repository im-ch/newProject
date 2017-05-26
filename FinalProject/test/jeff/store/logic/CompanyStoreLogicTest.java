package jeff.store.logic;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jeff.domain.Company;
<<<<<<< HEAD
=======
import jeff.domain.Coupon;
>>>>>>> this
import jeff.store.CompanyStore;

public class CompanyStoreLogicTest {
	
	private CompanyStore store;
	
	@Before
	public void CompanyStoreLogicTest() {
		store = new CompanyStoreLogic();
	}

//	@Test
//	public void testCreateCompany() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteCompany() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testModifyCompany() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectAllCompany() {
//		fail("Not yet implemented");
//	}
<<<<<<< HEAD
//
//	@Test
//	public void testSelectCompany() {
//		fail("Not yet implemented");
//	}
//
=======

//	@Test
//	public void testSelectCompany() {
//		Company c = store.selectCompany("ckdgml");
//		assertNotNull(c);
//		List<Coupon> list = c.getCouponList();
//		assertNotNull(list);
//		
//		for(Coupon co : list){
//			System.out.println(co.getCouponContent());
//		}
//	}

>>>>>>> this
//	@Test
//	public void testSelectCompanyByName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testLoginCompany() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testSelectCompanyByCategory() {
//		List<Company> list = store.selectCompanyByCategory("cafe");
//		
//		assertNotNull(list);
//		
//		for(Company c : list){
//			System.out.println(c.toString());
//		}
//	}

}
