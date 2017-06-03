package jeff.store.mapper;

import java.util.List;

import jeff.domain.CompanyImage;

public interface CompanyImageMapper {

	void insertCompanyImage(CompanyImage companyImage);
	void deleteCompanyImage(int companyImageId);
	List<CompanyImage> searchCompanyImageList(String comId);
}
