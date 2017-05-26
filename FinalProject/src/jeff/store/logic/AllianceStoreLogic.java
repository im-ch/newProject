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
	
	@Override
	public Alliance selectAlliance(String comId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		AllianceMapper mapper = session.getMapper(AllianceMapper.class);
		Alliance alliance = mapper.selectAlliance(comId);
		session.close();
		return alliance;
	}

	@Override
	public List<String> selectAllAlliance() {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		AllianceMapper mapper = session.getMapper(AllianceMapper.class);
		List<String> list = mapper.selectAllAlliance();
		
		session.close();
		return list;
	}

	@Override
	public void createAlliance(Alliance alliance) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		AllianceMapper mapper = session.getMapper(AllianceMapper.class);
		mapper.createAlliance(alliance);
		session.close();
	}

	@Override
	public void deleteAlliance(String comId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		AllianceMapper mapper = session.getMapper(AllianceMapper.class);
		mapper.deleteAlliance(comId);
		session.close();
	}

	@Override
	public void modifyAlliance(Alliance alliance) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		AllianceMapper mapper = session.getMapper(AllianceMapper.class);
		mapper.modifyAlliance(alliance);
		session.close();
	}

}
