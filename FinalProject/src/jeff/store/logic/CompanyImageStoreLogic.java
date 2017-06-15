package jeff.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jeff.domain.CompanyImage;
import jeff.store.CompanyImageStore;
import jeff.store.mapper.CompanyImageMapper;

@Repository
public class CompanyImageStoreLogic implements CompanyImageStore{

	@Override
	public void insertCompanyImage(CompanyImage companyImage) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		CompanyImageMapper mapper = session.getMapper(CompanyImageMapper.class);
		
		mapper.insertCompanyImage(companyImage);
	}

	@Override
	public void deleteCompanyImage(int companyImageId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		CompanyImageMapper mapper = session.getMapper(CompanyImageMapper.class);
		
		mapper.deleteCompanyImage(companyImageId);
	}

	@Override
	public List<CompanyImage> searchCompanyImageList(String comId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		CompanyImageMapper mapper = session.getMapper(CompanyImageMapper.class);
		
		List<CompanyImage> list = mapper.searchCompanyImageList(comId);
		return list;
	}

	@Override
	public CompanyImage searchCompanyImage(String comId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		CompanyImageMapper mapper = session.getMapper(CompanyImageMapper.class);
		
		CompanyImage image = mapper.searchCompanyImage(comId);
		return image;
	}

	
}
