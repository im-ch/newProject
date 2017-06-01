package jeff.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jeff.domain.CompanySales;
import jeff.domain.Sales;
import jeff.store.SalesStore;
import jeff.store.mapper.SalesMapper;

@Repository
public class SalesStoreLogic implements SalesStore{

	@Override
	public void createSales(Sales sales) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		
		SalesMapper mapper = session.getMapper(SalesMapper.class);
		mapper.createSales(sales);
		session.close();
	}

	@Override
	public void modifySales(Sales sales) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		
		SalesMapper mapper = session.getMapper(SalesMapper.class);
		mapper.modifySales(sales);
		session.close();
		
	}

	@Override
	public void deleteSales(int salesId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		
		SalesMapper mapper = session.getMapper(SalesMapper.class);
		mapper.deleteSales(salesId);
		session.close();
		
	}

	@Override
	public List<Sales> selectSalesByCompany(String companyId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		
		SalesMapper mapper = session.getMapper(SalesMapper.class);
		List<Sales> list = mapper.selectSalesByCompany(companyId);
		
		session.close();
		return list;
	}

	@Override
	public Sales selectBySalesId(int salesId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		
		SalesMapper mapper = session.getMapper(SalesMapper.class);
		Sales sales = mapper.selectBySalesId(salesId);
		
		session.close();
		return sales;
	}

	@Override
	public List<Sales> selectAllSales(String companyId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		SalesMapper mapper = session.getMapper(SalesMapper.class);
		List<Sales> list = mapper.selectAllSales(companyId);
		
		session.close();
		return list;
	}

}
