package jeff.store;

import java.util.HashMap;
import java.util.List;

import jeff.domain.Company;
import jeff.domain.CompanyImage;

public interface CompanyStore {

	void createCompany(Company company);

	void deleteCompany(String companyId);

	void modifyCompany(Company company);

	List<Company> selectAllCompany();
	
	Company selectCompany (String companyId);
	
	List<Company> selectCompanyByName(String comName);
	
	boolean loginCompany (Company company);
	
	List<Company> selectCompanyByLocationAndCategory(HashMap<String, Object> map);
	
	List<Company> selectCompanyByLocationAndCompany(HashMap<String, Object> map);

	List<Company> selectCompanyByLocation(String location);
	
	
}