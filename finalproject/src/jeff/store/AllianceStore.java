package jeff.store;

import java.util.List;

import jeff.domain.Alliance;

public interface AllianceStore {

	Alliance selectAlliance(String comId);

	List<String> selectAllAlliance();

	void createAlliance(Alliance alliance);

	void deleteAlliance(String comId);

	void modifyAlliance(Alliance alliance);

}
