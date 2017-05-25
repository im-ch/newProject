package jeff.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jeff.domain.Company;
import jeff.service.CompanyService;
import jeff.store.CompanyStore;
import jeff.store.logic.CompanyStoreLogic;

@Service
public class CompanyServiceLogic implements CompanyService{
	
	@Autowired
	private CompanyStore store;
	

	@Override
	public void registCompany(Company company) {
		
		store.createCompany(company);
		
		
	}

	@Override
	public void removeCompany(String companyId) {
		
		store.deleteCompany(companyId);
		
	}

	@Override
	public void updateCompany(Company company) {
		
		store.modifyCompany(company);
		
	}

	@Override
	public List<Company> findAllCompany() {
		
		return store.selectAllCompany();
	}

	@Override
	public Company findCompany(String companyId) {
		return store.selectCompany(companyId);
	}

	@Override
	public boolean login(Company company) {
		
		return false;
	}

	@Override
	public List<Company> findCompanyByCategory(String category) {
		return store.selectCompanyByCategory(category);
	}
	
	
}
