package jeff.store.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jeff.domain.Alliance;
import jeff.store.AllianceStore;
import jeff.store.mapper.AllianceMapper;

@Repository
public class AllianceStoreLogic implements AllianceStore{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private AllianceMapper mapper = sqlSession.getMapper(AllianceMapper.class);

	@Override
	public Alliance selectAlliance(String companyId) {
		Alliance alliance = mapper.selectAlliance(companyId);
		return alliance;
	}

	@Override
	public List<String> selectAllAlliance() {
		List<String> list = mapper.selectAllAlliance();
		return list;
	}

	@Override
	public void createAlliance(Alliance alliance) {
		mapper.createAlliance(alliance);
	}

	@Override
	public void deleteAlliance(String companyId) {
		mapper.deleteAlliance(companyId);
	}

	@Override
	public void modifyAlliance(Alliance alliance) {
		mapper.modifyAlliance(alliance);
	}

}
