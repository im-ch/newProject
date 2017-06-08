package jeff.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jeff.domain.Company;
import jeff.domain.CompanyImage;
import jeff.store.CompanyStore;
import jeff.store.mapper.CompanyMapper;

@Repository
public class CompanyStoreLogic implements CompanyStore {

	@Override
	public void createCompany(Company company) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();

		CompanyMapper mapper = session.getMapper(CompanyMapper.class);
		mapper.createCompany(company);
		session.close();

	}

	@Override
	public void deleteCompany(String comId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();

		CompanyMapper mapper = session.getMapper(CompanyMapper.class);
		mapper.deleteCompany(comId);

	}

	@Override
	public void modifyCompany(Company company) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();

		CompanyMapper mapper = session.getMapper(CompanyMapper.class);
		mapper.modifyCompany(company);
		session.close();

	}

	@Override
	public List<Company> selectAllCompany() {
		SqlSession session = JeffSessionFactory.getInstance().getSession();

		CompanyMapper mapper = session.getMapper(CompanyMapper.class);
		List<Company> list = mapper.selectAllCompany();

		session.close();

		return list;

	}

	@Override
	public Company selectCompany(String comId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();

		CompanyMapper mapper = session.getMapper(CompanyMapper.class);
		Company company = mapper.selectCompany(comId);

		session.close();

		return company;
	}

	@Override
	public List<Company> selectCompanyByName(String comName) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();

		CompanyMapper mapper = session.getMapper(CompanyMapper.class);
		List<Company> company = mapper.selectCompanyByName(comName);

		session.close();

		return company;
	}

	@Override
	public boolean loginCompany(Company company) {
		return false;
	}

	@Override
	public List<Company> selectCompanyByLocationAndCategory(HashMap<String, Object> map) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();

		CompanyMapper mapper = session.getMapper(CompanyMapper.class);
		List<Company> companyList = mapper.selectCompanyByLocationAndCategory(map);
		session.close();

		return companyList;
	}

	@Override
	public List<Company> selectCompanyByLocationAndCompany(HashMap<String, Object> map) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();

		CompanyMapper mapper = session.getMapper(CompanyMapper.class);
		List<Company> companyList = mapper.selectCompanyByLocationAndCompany(map);
		session.close();

		return companyList;
	}
	
	@Override
	public List<Company> selectCompanyByLocation(String location) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();

		CompanyMapper mapper = session.getMapper(CompanyMapper.class);
		List<Company> companyList = mapper.selectCompanyByLocation(location);
		session.close();

		return companyList;
	}

}
