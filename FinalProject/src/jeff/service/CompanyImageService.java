package jeff.service;

import java.util.List;

import jeff.domain.CompanyImage;

public interface CompanyImageService {
	public void insertCompanyImage(CompanyImage companyImage);
	public void removeCompanyImage(int companyImageId);
	public List<CompanyImage> findCompanyImageList(String comId);
	public CompanyImage findCompanyImage(String comId);
}
