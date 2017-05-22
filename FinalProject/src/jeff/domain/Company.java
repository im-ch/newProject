package jeff.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="company")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class Company {

	private String ownerName;
	private String comId;
	private String comPassword;
	private String comEmail;
	private int comPhoneNumber;
	private String comName;
	private String location;
	@XmlElement(name="coupons")
	private Coupons couponList;
	private String OpeningTime;
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}
	public String getComPassword() {
		return comPassword;
	}
	public void setComPassword(String comPassword) {
		this.comPassword = comPassword;
	}
	public String getComEmail() {
		return comEmail;
	}
	public void setComEmail(String comEmail) {
		this.comEmail = comEmail;
	}
	public int getComPhoneNumber() {
		return comPhoneNumber;
	}
	public void setComPhoneNumber(int comPhoneNumber) {
		this.comPhoneNumber = comPhoneNumber;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Coupons getCouponList() {
		return couponList;
	}
	public void setCouponList(Coupons couponList) {
		this.couponList = couponList;
	}
	public String getOpeningTime() {
		return OpeningTime;
	}
	public void setOpeningTime(String openingTime) {
		OpeningTime = openingTime;
	}
	@Override
	public String toString() {
		return "Company [ownerName=" + ownerName + ", comId=" + comId + ", comPassword=" + comPassword + ", comEmail="
				+ comEmail + ", comPhoneNumber=" + comPhoneNumber + ", comName=" + comName + ", location=" + location
				+ ", couponList=" + couponList + ", OpeningTime=" + OpeningTime + "]";
	}
	
	
}
