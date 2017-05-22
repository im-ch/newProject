package jeff.service;

public interface CompanyService {

	public void registCompany(Company company);
	public void removeCompany(String companyId);
	public void updateCompany(Company company);
	public List<Company> findAllCompany();
	public Company findCompany(String companyId);
	public boolean login(Company company);
}
