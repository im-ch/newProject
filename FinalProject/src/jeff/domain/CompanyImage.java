package jeff.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="companyImage")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class CompanyImage {
	private int companyImageId;
	private String comId;
	private String fileName;
	private String contentType;
	
	public int getCompanyImageId() {
		return companyImageId;
	}
	public void setCompanyImageId(int companyImageId) {
		this.companyImageId = companyImageId;
	}
	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
}
