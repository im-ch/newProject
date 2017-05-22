package jeff.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name = "alliance")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class Alliance {
	@XmlElement(name = "company")
	private Company company;
	private int businessNumber;
	private String openingHours;
	private String detail;
	
	private String name; 

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

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
