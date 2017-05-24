import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jeff.domain.Sales;
import jeff.store.SalesStore;
import jeff.store.logic.SalesStoreLogic;

public class SalesStoreLogicTest {
	
	private SalesStore store;
	
	@Before
	public void setUp(){
		store = new SalesStoreLogic();
	}
	
//	@Test
//	public void CreateTest(){
//		
//		Sales s = new Sales();
//		
//		s.setCompanyId("22");
//		s.setSalesId(22);
//		s.setSales(22);
//		
//		store.createSales(s);
//	}
	
//	@Test
//	public void DeleteTest(){
//		
//		store.deleteSales(2);
//		
//	}
	
//	@Test
//	public void ModifyTest(){
//		Sales s = new Sales();
//		
//		s.setSalesId(1);
//		s.setSales(1111);
//		s.setCompanyId("1");
//		
//		store.modifySales(s);
//		
//		
//		
//	}
	
//	@Test
//	public void testSelectAllSales(){
//		Sales s = new Sales();
//		List<Sales> list = store.selectAllSales(s.getCompanyId());
//		assertEquals(1, list.size());
//	}
	
//	@Test
//	public void testSelectBySalesId(){
//		Sales s = new Sales();
//		s.setSalesId(1);
//		store.selectBySalesId(s.getSalesId());
//		assertEquals(1, s);
//	}

}
