package jeff.service;

public interface SalesService {

	public void registSales(Sales sales);
	public void updateSales(Sales sales);
	public void removeSales(int salesId);
	public List<Sales> findSalesByCompany(String companyId);
	public findBySalesId(int salesId);
	
}
