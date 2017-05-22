package jeff.store;

import java.util.List;

import jeff.domain.Company;

public interface InterestingCompanyStore {

	void createInterestingCompany(String userId, String companyId);

	void deleteInterestingCompany(String userId, String companyId);

	List<Company> selectInterestingCompany(String userId);

}
