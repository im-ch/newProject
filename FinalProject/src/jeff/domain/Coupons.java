package jeff.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="coupons")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class Coupons {

	@XmlElement(name="coupon")
	private List<Coupon> couponList;

	public List<Coupon> getCouponList() {
		return couponList;
	}

	public void setCouponList(List<Coupon> couponList) {
		this.couponList = couponList;
	}

	@Override
	public String toString() {
		return "Coupons [couponList=" + couponList + "]";
	}
	
	
}
