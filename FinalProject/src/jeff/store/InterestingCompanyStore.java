package jeff.store;

import java.util.HashMap;
import java.util.List;

import jeff.domain.Company;

public interface InterestingCompanyStore {

	void createInterestingCompany(HashMap<String, Object> map);

	void deleteInterestingCompany(String userId, String companyId);

	List<Company> selectInterestingCompany(String userId);

}
