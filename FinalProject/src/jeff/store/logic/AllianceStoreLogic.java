package jeff.store.logic;

import java.util.List;

import org.springframework.stereotype.Repository;

import jeff.domain.Alliance;
import jeff.store.AllianceStore;

@Repository
public class AllianceStoreLogic implements AllianceStore{

	@Override
	public Alliance selectAlliance(String companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> selectAllAlliance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createAlliance(Alliance alliance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAlliance(String companyId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyAlliance(Alliance alliance) {
		// TODO Auto-generated method stub
		
	}

}
