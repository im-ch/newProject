package jeff.store;

import java.util.List;

import jeff.domain.User;

public interface UserStore {

	void createUser(User user);

	void deleteUser(String userId);

	void modifyUser(User user);

	List<User> selectAllUser();

	User selectUser(String userId);

	boolean loginUser(User user);
	
	String checkId(String userId);

}
