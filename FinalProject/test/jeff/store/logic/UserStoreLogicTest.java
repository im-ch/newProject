package jeff.store.logic;

import static org.junit.Assert.*;

import java.util.List;

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

//	@Test
//	public void testCreateUser() {
//		User u = new User();
//		u.setUserId("11");
//		u.setName("22");
//		u.setPassword("33");
//		u.setPhoneNumber(0101234567);
//		u.setEmail("eojin");
//		store.createUser(u);
//	}

//	@Test
//	public void testDeleteUser() {
//		store.deleteUser("11");
//	}

//	@Test
//	public void testModifyUser() {
//		User u = store.selectUser("11");
//		u.setPassword("22");
//		store.modifyUser(u);
//	}

//	@Test
//	public void testSelectAllUser() {
//		List<User> list = store.selectAllUser();
//		assertEquals(1, list.size());
//	}

//	@Test
//	public void testSelectUser() {
//		User u = store.selectUser("11");
//		assertEquals("22", u.getPassword());
//	}

}
