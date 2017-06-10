package jeff.store.mapper;

import java.util.HashMap;
import java.util.List;

public interface InterestingCompanyMapper {
	
	void createInterestingCompany(HashMap<String, Object> map);

	void deleteInterestingCompany(HashMap<String, Object> map);

	List<String> selectInterestingCompany(String userId);


}
