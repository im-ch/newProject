package jeff.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jeff.domain.Alliance;
import jeff.service.AllianceService;
import jeff.store.AllianceStore;
import jeff.store.logic.AllianceStoreLogic;

@Service
public class AllianceServiceLogic implements AllianceService{
	
	@Autowired
	private AllianceStore store;
	

	@Override
	public Alliance findAlliance(String companyId) {
		return store.selectAlliance(companyId);
	}

	@Override
	public List<String> findAllAlliance() {
		return store.selectAllAlliance();
	}

	@Override
	public void registAlliance(Alliance alliance) {
		store.createAlliance(alliance);
	}

	@Override
	public void removeAlliance(String companyId) {
		store.deleteAlliance(companyId);
	}

	@Override
	public void updateAlliance(Alliance alliance) {
		store.modifyAlliance(alliance);
	}
	
	

}
