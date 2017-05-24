package jeff.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jeff.domain.Sales;
import jeff.service.SalesService;
import jeff.store.SalesStore;
import jeff.store.logic.SalesStoreLogic;

@Service
public class SalesServiceLogic implements SalesService{
	
	@Autowired
	private SalesStore store;
	
	public SalesServiceLogic() {
		store = new SalesStoreLogic();
	}
	
	@Override
	public void registSales(Sales sales) {
		store.createSales(sales);
		
	}

	@Override
	public void updateSales(Sales sales) {
		store.modifySales(sales);
	}

	@Override
	public void removeSales(int salesId) {
		store.deleteSales(salesId);
	}

	@Override
	public List<Sales> findSalesByCompany(String companyId) {
		return (List<Sales>) store.selectSalesByCompany(companyId);
	}

	@Override
	public Sales findBySalesId(int salesId) {
		return store.selectBySalesId(salesId);
	}
	
	

}
