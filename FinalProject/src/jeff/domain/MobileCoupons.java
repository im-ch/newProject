package jeff.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="mCoupons")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class MobileCoupons {

	@XmlElement(name="mCoupon")
	private List<MobileCoupon> mCouponList;

	

	public List<MobileCoupon> getmCouponList() {
		return mCouponList;
	}

	public void setmCouponList(List<MobileCoupon> mCouponList) {
		this.mCouponList = mCouponList;
	}
}
