package jeff.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jeff.store.InterestingCompanyStore;
import jeff.store.mapper.InterestingCompanyMapper;

@Repository
public class InterestingCompanyStoreLogic implements InterestingCompanyStore {

	private SqlSession session = JeffSessionFactory.getInstance().getSession();

	@Override
	public void createInterestingCompany(HashMap<String, Object> map) {

		InterestingCompanyMapper mapper = session.getMapper(InterestingCompanyMapper.class);
		mapper.createInterestingCompany(map);
		session.close();
	}

	@Override
	public void deleteInterestingCompany(HashMap<String, Object> map) {
		InterestingCompanyMapper mapper = session.getMapper(InterestingCompanyMapper.class);
		mapper.deleteInterestingCompany(map);
		session.close();
	}

	@Override
	public List<String> selectInterestingCompany(String userId) {
		InterestingCompanyMapper mapper = session.getMapper(InterestingCompanyMapper.class);
		List<String> list = mapper.selectInterestingCompany(userId);
		session.close();

		return list;

	}
}
