package jeff.service;

import java.util.HashMap;
import java.util.List;

import jeff.domain.Company;
import jeff.domain.CompanyImage;

public interface CompanyService {

	public void registCompany(Company company);
	public void removeCompany(String comId);
	public void updateCompany(Company company);
	public List<Company> findAllCompany();
	public Company findCompany(String companyId);
	public boolean login(Company company);
	public List<Company> findCompanyByCategory(String category);
	public Company findCompanyByName(String comName);
	public List<Company> findCompanyByLocationAndCompany(HashMap<String, Object> map);
	public List<Company> findCompanyByLocation(String location);
}
