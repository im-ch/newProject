package jeff.store.logic;

import java.util.List;

import org.springframework.stereotype.Repository;

import jeff.domain.User;
import jeff.store.UserStore;

@Repository
public class UserStoreLogic implements UserStore{

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loginUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
