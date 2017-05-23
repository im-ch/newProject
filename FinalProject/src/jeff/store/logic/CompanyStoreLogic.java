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
	
	@Autowired
	private SqlSessionFactory factory;

	public CompanyStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public void createCompany(Company company) {
		SqlSession session = factory.openSession();

		try {
			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			mapper.createCompany(company);
			session.commit();

		} finally {
			session.close();
		}
	}

	@Override
	public void deleteCompany(String companyId) {
		SqlSession session = factory.openSession();
		
		try{
			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			mapper.deleteCompany(companyId);
			session.commit();
		}finally{
			session.close();
		}

	}

	@Override
	public void modifyCompany(Company company) {
		SqlSession session = factory.openSession();
		
		try{
			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			mapper.modifyCompany(company);
			session.commit();
		}finally{
			session.close();
		}

	}

	@Override
	public List<Company> selectAllCompany() {
		SqlSession session = factory.openSession();
		List<Company> list = null;
		
		try{
		CompanyMapper mapper = session.getMapper(CompanyMapper.class);
		list = mapper.selectAllCompany();
		}finally{
			session.close();
		}
		return list;
		
	}

	@Override
	public Company selectCompany(String companyId) {
		SqlSession session = factory.openSession();
		Company company = null;
		
		try{
		CompanyMapper mapper = session.getMapper(CompanyMapper.class);
		company= mapper.selectCompany(companyId);
		}finally{
			session.close();
		}
		
		return company;
	}

	@Override
	public Company selectCompanyByName(String comName) {
		SqlSession session = factory.openSession();
		Company company = null;
		try{
			CompanyMapper mapper = session.getMapper(CompanyMapper.class);
			company = mapper.selectCompanyByName(comName);
		}finally{
			session.close();
		}
		
		return company;
	}

	@Override
	public boolean loginCompany(Company company) {
		return false;
	}

}
