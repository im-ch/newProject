package jeff.service.logic;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jeff.domain.CompanySales;
import jeff.domain.Sales;
import jeff.service.SalesService;
import jeff.store.SalesStore;

@Service
public class SalesServiceLogic implements SalesService {

	@Autowired
	private SalesStore store;

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
		return store.selectSalesByCompany(companyId);
	}

	@Override
	public Sales findBySalesId(int salesId) {
		return store.selectBySalesId(salesId);
	}

}
