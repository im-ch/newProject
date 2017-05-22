package jeff.domain;

import javax.xml.bind.annotation.XmlElement;

public class AllianceForm {

	@XmlElement(name="company")
	private Company company;
	private int businessNumber;
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public int getBusinessNumber() {
		return businessNumber;
	}
	public void setBusinessNumber(int businessNumber) {
		this.businessNumber = businessNumber;
	}
	@Override
	public String toString() {
		return "AllianceForm [company=" + company + ", businessNumber=" + businessNumber + "]";
	}

	
}
