package jeff.service;

import java.util.HashMap;
import java.util.List;

import jeff.domain.Company;

public interface InterestingCompanyService {

	public void registInterestingCompany(HashMap<String, Object> map);

	public void removceInterestingCompany(String userId, String companyId);

	public List<Company> findInterestingCompany(String userId);

}
