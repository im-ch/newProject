package jeff.service;

import java.util.List;

import jeff.domain.Company;

public interface InterestingCompanyService {

	public void registInterestingCompany(String userId, String companyId);
	public void removceInterestingCompany(String userId, String companyId);
	public List<Company> findInterestingCompany(String userId);
	
}
