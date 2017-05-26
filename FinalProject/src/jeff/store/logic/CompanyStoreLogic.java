package jeff.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jeff.domain.Company;
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
	public void deleteCompany(String companyId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();

		CompanyMapper mapper = session.getMapper(CompanyMapper.class);
		mapper.deleteCompany(companyId);

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
	public Company selectCompany(String companyId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();

		CompanyMapper mapper = session.getMapper(CompanyMapper.class);
		Company company = mapper.selectCompany(companyId);

		session.close();

		return company;
	}

	@Override
	public Company selectCompanyByName(String comName) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();

		CompanyMapper mapper = session.getMapper(CompanyMapper.class);
		Company company = mapper.selectCompanyByName(comName);

		session.close();

		return company;
	}

	@Override
	public boolean loginCompany(Company company) {
		return false;
	}

	@Override
	public List<Company> selectCompanyByCategory(String category) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();

		CompanyMapper mapper = session.getMapper(CompanyMapper.class);
		List<Company> companyList = mapper.selectCompanyByCategory(category);
		session.close();

		return companyList;
	}

}
