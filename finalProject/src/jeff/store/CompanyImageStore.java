package jeff.store;

import java.util.List;

import jeff.domain.CompanyImage;

public interface CompanyImageStore {

	void insertCompanyImage(CompanyImage companyImage);
	void deleteCompanyImage(int companyImageId);
	List<CompanyImage> searchCompanyImageList(String comId);
}
