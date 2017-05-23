import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jeff.domain.Company;
import jeff.store.CompanyStore;
import jeff.store.logic.CompanyStoreLogic;

public class CompanyStoreLogicTest {
	
	private CompanyStore store;
	
	@Before
	public void setUp() {
		store = new CompanyStoreLogic();
	}
	

	@Test
	public void CreateTest() {
		
		Company c = new Company();
		
		c.setComId("3");
		c.setComEmail("ddd");
		c.setComName("dd");
		c.setComPassword("111");
		c.setComPhoneNumber(123);
		c.setLocation("daa");
		c.setOwnerName("asda");
		
		store.createCompany(c);
				
	}
	
//	@Test
//	public void  testSearchAll(){
//		List<Company> list = store.selectAllCompany();
//		assertEquals(2, list.size());
//	}
//	
//	@Test
//	public void testDelete(){
//		
//		store.deleteCompany("11");
//		
//	}
	
//	@Test
//	public void testUpdate(){
//		Company c = new Company();
//		
//		store.modifyCompany(c);
//	}
//	
	

}
