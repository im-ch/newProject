package jeff.store.logic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jeff.domain.Company;

public class InterestingCompanyStoreLogicTest {

	private InterestingCompanyStoreLogic store;

	@Before
	public void setUp() {
		store = new InterestingCompanyStoreLogic();
	}

	// @Test
	// public void testCreateInterestingCompany() {
	// HashMap<String, Object> map = new HashMap<String, Object>();
	// String userId = "heehyun";
	// Object comId = "789";
	// map.put("userId", userId);
	// map.put("comId", comId);
	// store.createInterestingCompany(map);
	// }

	// @Test
	// public void testDeleteInterestingCompany() {
	// HashMap<String, Object> map = new HashMap<String, Object>();
	//
	// String userId = "heehyun";
	// Object comId = "123";
	//
	// map.put("userId", userId);
	// map.put("comId", comId);
	//
	// store.deleteInterestingCompany(map);
	// }

//	@Test
//	public void testSelectInterestingCompany() {
//		List<String> list = new ArrayList<>();
//		list = store.selectInterestingCompany("heehyun");
//		
//		assertEquals(list.size(), 3);
//		assertEquals(list.get(0), "789");
//
//	}

}
