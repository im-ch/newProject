package jeff.store.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jeff.domain.User;
import jeff.store.UserStore;
import jeff.store.mapper.UserMapper;

@Repository
public class UserStoreLogic implements UserStore{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void createUser(User user) {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		mapper.createUser(user);
	}

	@Override
	public void deleteUser(String userId) {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		mapper.deleteUser(userId);
	}

	@Override
	public void modifyUser(User user) {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		mapper.modifyUser(user);;
	}

	@Override
	public List<User> selectAllUser() {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = null;
		users = mapper.selectAllUser();
		return users;
	}

	@Override
	public User selectUser(String userId) {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = null;
		user = mapper.selectUser(userId);
		return user;
	}

	@Override
	public boolean loginUser(User user) {
		return false;
	}

}
