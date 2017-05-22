package jeff.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class User {

	private String name;
	private String userId;
	private String password;
	private String email;
	private int phoneNumber;
	@XmlElement(name="coupons")
	private Coupons couponList;
	@XmlElement(name="company")
	private List<Company> companyList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Coupons getCouponList() {
		return couponList;
	}
	public void setCouponList(Coupons couponList) {
		this.couponList = couponList;
	}
	public List<Company> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", userId=" + userId + ", password=" + password + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", couponList=" + couponList + ", companyList=" + companyList + "]";
	}
	
	
}
