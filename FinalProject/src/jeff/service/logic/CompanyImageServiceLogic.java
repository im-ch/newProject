package jeff.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jeff.domain.CompanyImage;
import jeff.service.CompanyImageService;
import jeff.store.CompanyImageStore;

@Service
public class CompanyImageServiceLogic implements CompanyImageService{

	@Autowired
	private CompanyImageStore store;
	
	@Override
	public void insertCompanyImage(CompanyImage companyImage) {
		store.insertCompanyImage(companyImage);
	}

	@Override
	public void removeCompanyImage(int companyImageId) {
		store.deleteCompanyImage(companyImageId);
	}

	@Override
	public List<CompanyImage> findCompanyImageList(String comId) {
		return store.searchCompanyImageList(comId);
	}

	@Override
	public CompanyImage findCompanyImage(String comId) {
		return store.searchCompanyImage(comId);
	}

}
