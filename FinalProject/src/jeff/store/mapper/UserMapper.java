package jeff.store.mapper;

import java.util.List;

import jeff.domain.User;

public interface UserMapper {
	
	void createUser(User user);

	void deleteUser(String userId);

	void modifyUser(User user);

	List<User> selectAllUser();

	User selectUser(String userId);

	boolean loginUser(User user);
	
	String checkId(String userId);
	
	String secondCheckId(String userId);

}
