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
	
	@Override
	public String checkId(String userId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		String checkId = mapper.checkId(userId);

		String secondCheckId = mapper.secondCheckId(userId);  
		/* 개인회원 id와 기업회원 id가 같은게 있는지 확인하는 메소드 , 만약 개인회원가 기업회원 가입시 같은 id로 가입이 가능 할 경우
		 회원은 가입되지만 나중에 로그인이 불가능해지기 때문에 (userController의 로그인 메소드 참조) 중복된 id를 원천적으로 막기위해 2차 확인을 한다*/
		session.close();
		if (checkId == null && secondCheckId == null) // 회원가입 하려는 id가 user_tb와 company_tb 에 중복된게 없을 경우
			return null;
		else
			return checkId + secondCheckId;
	}

}
