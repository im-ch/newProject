package jeff.service.logic;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jeff.service.InterestingCompanyService;
import jeff.store.InterestingCompanyStore;

@Service
public class InterestingCompanyServiceLogic implements InterestingCompanyService{
	
	@Autowired
	private InterestingCompanyStore store;
	
	@Override
	public void registInterestingCompany(HashMap<String, Object> map) {
		store.createInterestingCompany(map);
	}

	@Override
	public void removeInterestingCompany(HashMap<String, Object> map) {
		store.deleteInterestingCompany(map);
	}

	@Override
	public List<String> findInterestingCompany(String userId) {
		return store.selectInterestingCompany(userId);
	}

	
	
}
