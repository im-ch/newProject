package jeff.service;

import java.util.List;

import jeff.domain.Alliance;

public interface AllianceService {

	public Alliance findAlliance(String comId);
	public List<String> findAllAlliance();
	public void registAlliance(Alliance alliance);
	public void removeAlliance(String comId);
	public void updateAlliance(Alliance alliance);
	
}
