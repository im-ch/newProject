package jeff.store.mapper;

import java.util.List;

import jeff.domain.Company;
import jeff.domain.CompanyImage;

public interface CompanyMapper {
	
	void createCompany(Company company);

	void deleteCompany(String comId);

	void modifyCompany(Company company);

	List<Company> selectAllCompany();
	
	Company selectCompany (String comId);
	
	Company selectCompanyByName(String comName);
	
	boolean loginCompany (Company company);
	
	List<Company> selectCompanyByCategory(String category);
	

}
