package jeff.store.logic;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class InterestingCompanyStoreLogicTest {

	private InterestingCompanyStoreLogic store;

	@Before
	public void setUp() {
		store = new InterestingCompanyStoreLogic();
	}

	@Test
	public void testCreateInterestingCompany() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		String userId = "heehyun";
		Object comId = "123";
		map.put("userId", userId);
		map.put("comId", comId);
		store.createInterestingCompany(map);
	}

	// @Test
	// public void testDeleteInterestingCompany() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testSelectInterestingCompany() {
	// fail("Not yet implemented");
	// }

}
