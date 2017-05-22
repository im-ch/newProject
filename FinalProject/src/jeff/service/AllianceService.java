package jeff.service;

import java.util.List;

import jeff.domain.Alliance;

public interface AllianceService {

	public Alliance findAlliance(String companyId);
	public List<String> findAllAlliance();
	public void registAlliance(Alliance alliance);
	public void removeAlliance(String companyId);
	public void updateAlliance(Alliance alliance);
	
}
