package jeff.store;

import java.util.HashMap;
import java.util.List;

public interface InterestingCompanyStore {

	void createInterestingCompany(HashMap<String, Object> map);

	void deleteInterestingCompany(HashMap<String, Object> map);

	List<String> selectInterestingCompany(String userId);

}