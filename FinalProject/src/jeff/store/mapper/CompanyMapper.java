package jeff.store.mapper;

import java.util.List;

import jeff.domain.Company;

public interface CompanyMapper {
	
	void createCompany(Company company);

	void deleteCompany(String companyId);

	void modifyCompany(Company company);

	List<Company> selectAllCompany();
	
	Company selectCompany (String companyId);
	
	Company selectCompanyByName(String comName);
	
	boolean loginCompany (Company company);
	
	List<Company> selectCompanyByCategory(String category);

}
