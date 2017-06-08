package jeff.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jeff.domain.User;
import jeff.store.UserStore;
import jeff.store.mapper.UserMapper;

@Repository
public class UserStoreLogic implements UserStore{

	@Override
	public void createUser(User user) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.createUser(user);
		session.close();
	}

	@Override
	public void deleteUser(String userId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.deleteUser(userId);
		session.close();
	}

	@Override
	public void modifyUser(User user) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.modifyUser(user);
		session.close();
	}

	@Override
	public List<User> selectAllUser() {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> users = null;
		users = mapper.selectAllUser();
		session.close();
		return users;
	}

	@Override
	public User selectUser(String userId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = null;
		user = mapper.selectUser(userId);
		session.close();
		return user;
	}

	@Override
	public boolean loginUser(User user) {
		return false;
	}

}
