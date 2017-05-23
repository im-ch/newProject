package jeff.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jeff.domain.User;
import jeff.service.UserService;
import jeff.store.UserStore;

public class UserServiceLogic implements UserService{
	
	@Autowired
	private UserStore store;

	@Override
	public void registUser(User user) {
		store.createUser(user);
	}

	@Override
	public void removeUser(String userId) {
		store.deleteUser(userId);
	}

	@Override
	public void updateUser(User user) {
		store.modifyUser(user);
	}

	@Override
	public List<User> findAllUsers() {
		return store.selectAllUser();
	}

	@Override
	public User findUser(String userId) {
		return store.selectUser(userId);
	}

	@Override
	public boolean login(User user) {
		return false;
	}
	
	

}
