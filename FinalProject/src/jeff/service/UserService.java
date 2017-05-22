package jeff.service;

import java.util.List;

import jeff.domain.User;

public interface UserService {

	public void registUser(User user);
	public void removeUser(String userId);
	public void updateUser(User user);
	public List<User> findAllUsers();
	public User findUser(String userId);
	public boolean login(User user);
}
