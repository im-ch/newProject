package jeff.service.logic;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jeff.domain.Company;
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
	public void removceInterestingCompany(String userId, String companyId) {
	}

	@Override
	public List<Company> findInterestingCompany(String userId) {
		return null;
	}

	
	
}
