package jeff.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jeff.domain.Alliance;
import jeff.store.AllianceStore;
import jeff.store.mapper.AllianceMapper;

@Repository
public class AllianceStoreLogic implements AllianceStore{
	
//	@Autowired
//	private SqlSessionTemplate sqlSession;
	
	private SqlSession session = JeffSessionFactory.getInstance().getSession();
	
//	private AllianceMapper mapper = sqlSession.getMapper(AllianceMapper.class);

	@Override
	public Alliance selectAlliance(String companyId) {
		AllianceMapper mapper = session.getMapper(AllianceMapper.class);
		Alliance alliance = mapper.selectAlliance(companyId);
		return alliance;
	}

	@Override
	public List<String> selectAllAlliance() {
		AllianceMapper mapper = session.getMapper(AllianceMapper.class);
		List<String> list = mapper.selectAllAlliance();
		return list;
	}

	@Override
	public void createAlliance(Alliance alliance) {
		AllianceMapper mapper = session.getMapper(AllianceMapper.class);
		mapper.createAlliance(alliance);
	}

	@Override
	public void deleteAlliance(String companyId) {
		AllianceMapper mapper = session.getMapper(AllianceMapper.class);
		mapper.deleteAlliance(companyId);
	}

	@Override
	public void modifyAlliance(Alliance alliance) {
		AllianceMapper mapper = session.getMapper(AllianceMapper.class);
		mapper.modifyAlliance(alliance);
	}

}
