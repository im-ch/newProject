package jeff.store.mapper;

import java.util.List;

import jeff.domain.Company;

public interface InterestingCompanyMapper {
	
	void createInterestingCompany(String userId, String companyId);

	void deleteInterestingCompany(String userId, String companyId);

	List<Company> selectInterestingCompany(String userId);

}
