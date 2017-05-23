package jeff.store.logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import jeff.domain.User;

public class UserStoreLogicTest {
	
	private UserStoreLogic store;
	
	@Before
	public void UserStoreLogicTest() {
		store = new UserStoreLogic();
	}

	@Test
	public void testCreateUser() {
		User u = new User();
		u.setUserId("11");
		u.setName("22");
		u.setPassword("33");
		u.setPhoneNumber(0101234567);
		store.createUser(u);
	}

//	@Test
//	public void testDeleteUser() {
//	}
//
//	@Test
//	public void testModifyUser() {
//	}
//
//	@Test
//	public void testSelectAllUser() {
//	}
//
//	@Test
//	public void testSelectUser() {
//	}

}
