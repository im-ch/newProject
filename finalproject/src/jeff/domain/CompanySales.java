package jeff.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class CompanySales {

	private String companyId;
	@XmlElement(name="sales")
	private List<Sales> salesList;
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public List<Sales> getSalesList() {
		return salesList;
	}
	public void setSalesList(List<Sales> salesList) {
		this.salesList = salesList;
	}
	@Override
	public String toString() {
		return "CompanySales [companyId=" + companyId + ", salesList=" + salesList + "]";
	}
	
	
}
