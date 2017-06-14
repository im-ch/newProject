package jeff.domain;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Payment {
	
	private Company company;
	private Coupon coupon;
	private Date payDate;
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Coupon getCoupon() {
		return coupon;
	}
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	

}
