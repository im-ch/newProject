package jeff.store.mapper;

import java.util.List;

import jeff.domain.Alliance;

public interface AllianceMapper {
	
	Alliance selectAlliance(String companyId);

	List<String> selectAllAlliance();

	void createAlliance(Alliance alliance);

	void deleteAlliance(String companyId);

	void modifyAlliance(Alliance alliance);


}
