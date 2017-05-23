import static org.junit.Assert.*;

import org.junit.Test;

import jeff.domain.Company;
import jeff.store.CompanyStore;
import jeff.store.logic.CompanyStoreLogic;

public class CompanyStoreLogicTest {
	
	private CompanyStore store;
	
	public CompanyStoreLogicTest() {
		store = new CompanyStoreLogic();
	}
	

private void set() {

}
	@Test
	public void CreateTest() {
		
		Company c = new Company();
		
		c.setComId("11");
		c.setComEmail("ddd");
		c.setComName("dd");
		c.setComPassword("111");
		c.setComPhoneNumber(123);
		c.setLocation("daa");
		c.setOwnerName("asda");
		
		store.createCompany(c);
		
		
		
	}

}
