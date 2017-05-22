package jeff.service;

public interface AllianceService {

	public Alliance findAlliance(String companyId);
	public List<companyId> findAllAlliance();
	public void registAlliance(Alliance alliance);
	public void removeAlliance(String companyId);
	public void updateAlliance(Alliance alliance);
	
}
