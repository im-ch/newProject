package jeff.store.logic;

import java.util.List;

import org.springframework.stereotype.Repository;

import jeff.domain.CompanySales;
import jeff.domain.Sales;
import jeff.store.SalesStore;

@Repository
public class SalesStoreLogic implements SalesStore{

	@Override
	public void createSales(Sales sales) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifySales(Sales sales) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSales(int salesId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CompanySales selectSalesByCompany(String companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sales selectBySalesId(int saleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sales> selectAllSales(String companyId) {
		// TODO Auto-generated method stub
		return null;
	}

}
