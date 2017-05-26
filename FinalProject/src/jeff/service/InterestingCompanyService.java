package jeff.service;

import java.util.HashMap;
import java.util.List;

import jeff.domain.Company;

public interface InterestingCompanyService {

	public void registInterestingCompany(HashMap<String, Object> map);

	public void removeInterestingCompany(HashMap<String, Object> map);

	public List<String> findInterestingCompany(String userId);

}
