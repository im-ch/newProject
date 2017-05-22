package jeff.store.logic;

import java.util.List;

import org.springframework.stereotype.Repository;

import jeff.domain.Company;
import jeff.store.CompanyStore;

@Repository
public class CompanyStoreLogic implements CompanyStore{

	@Override
	public void createCompany(Company company) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCompany(String companyId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyCompany(Company company) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Company> selectAllCompany() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company selectCompany(String companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company selectCompanyByName(String comName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loginCompany(Company company) {
		// TODO Auto-generated method stub
		return false;
	}

}
