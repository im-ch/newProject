package jeff.store.mapper;

import java.util.List;

import jeff.domain.CompanySales;
import jeff.domain.Sales;

public interface SalesMapper {
	
	void createSales(Sales sales);

	void modifySales(Sales sales);

	void deleteSales(int salesId);

	CompanySales selectSalesByCompany(String companyId);

	Sales selectBySalesId(int saleId);

	List<Sales> selectAllSales(String companyId);

}
