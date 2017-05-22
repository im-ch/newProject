package jeff.service;

import java.util.List;

import jeff.domain.Sales;

public interface SalesService {

	public void registSales(Sales sales);
	public void updateSales(Sales sales);
	public void removeSales(int salesId);
	public List<Sales> findSalesByCompany(String companyId);
	public Sales findBySalesId (int salesId);
	
}
