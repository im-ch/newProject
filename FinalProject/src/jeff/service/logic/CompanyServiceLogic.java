package jeff.service.logic;

import java.util.List;

import jeff.domain.Company;
import jeff.service.CompanyService;
import jeff.store.CompanyStore;
import jeff.store.logic.CompanyStoreLogic;

public class CompanyServiceLogic implements CompanyService{
	
	private CompanyStore store;
	
	public CompanyServiceLogic() {
		store = new CompanyStoreLogic();
	}

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

	
	
}
