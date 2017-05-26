package jeff.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jeff.store.InterestingCompanyStore;
import jeff.store.mapper.InterestingCompanyMapper;

@Repository
public class InterestingCompanyStoreLogic implements InterestingCompanyStore {

	@Override
	public void createInterestingCompany(HashMap<String, Object> map) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		InterestingCompanyMapper mapper = session.getMapper(InterestingCompanyMapper.class);
		mapper.createInterestingCompany(map);
		session.close();
	}

	@Override
	public void deleteInterestingCompany(HashMap<String, Object> map) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		InterestingCompanyMapper mapper = session.getMapper(InterestingCompanyMapper.class);
		mapper.deleteInterestingCompany(map);
		session.close();
	}

	@Override
	public List<String> selectInterestingCompany(String userId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		InterestingCompanyMapper mapper = session.getMapper(InterestingCompanyMapper.class);
		List<String> list = mapper.selectInterestingCompany(userId);
		session.close();

		return list;

	}
}
