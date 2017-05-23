package jeff.store.logic;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jeff.domain.Company;
import jeff.store.InterestingCompanyStore;
import jeff.store.mapper.InterestingCompanyMapper;

@Repository
public class InterestingCompanyStoreLogic implements InterestingCompanyStore {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void createInterestingCompany(HashMap<String, Object> map) {
		InterestingCompanyMapper mapper = sqlSession.getMapper(InterestingCompanyMapper.class);
		mapper.createInterestingCompany(map);
	}

	@Override
	public void deleteInterestingCompany(String userId, String companyId) {

	}

	@Override
	public List<Company> selectInterestingCompany(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
