package jeff.store.logic;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jeff.domain.Company;
import jeff.domain.Coupon;
import jeff.store.CompanyStore;

public class CompanyStoreLogicTest {

	private CompanyStore store;

	@Before
	public void CompanyStoreLogicTest() {
		store = new CompanyStoreLogic();
	}

	// @Test
	// public void testCreateCompany() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testDeleteCompany() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testModifyCompany() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testSelectAllCompany() {
	// fail("Not yet implemented");
	// }

	// @Test
	// public void testSelectCompanyByName() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testLoginCompany() {
	// fail("Not yet implemented");
	// }

	// @Test
	// public void testSelectCompanyByCategory() {
	// List<Company> list = store.selectCompanyByCategory("cafe");
	//
	// assertNotNull(list);
	//
	// for(Company c : list){
	// System.out.println(c.toString());
	// }
	// }
	
	 @Test
	 public void selectCompanyByLocation() {
		 
		 HashMap<String, Object> map = new HashMap<>();
		 map.put("location", "서울시 강남구");
		 map.put("category", "기타");
		 
		 List<Company> list = store.selectCompanyByLocation(map);
		 
		 assertEquals(2, list.size());
		 
	 }

}
