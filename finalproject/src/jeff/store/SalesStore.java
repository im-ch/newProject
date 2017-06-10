package jeff.store;

import java.util.List;

import jeff.domain.CompanySales;
import jeff.domain.Sales;

public interface SalesStore {

	void createSales(Sales sales);

	void modifySales(Sales sales);

	void deleteSales(int salesId);

	List<Sales> selectSalesByCompany(String companyId);

	Sales selectBySalesId(int saleId);

	List<Sales> selectAllSales(String companyId);
}
