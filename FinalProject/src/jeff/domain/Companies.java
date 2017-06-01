package jeff.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="companies")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class Companies {

<<<<<<< HEAD
   @XmlElement(name="company")
   private List<Company> companies;

   public List<Company> getCompanies() {
      return companies;
   }

   public void setCompanies(List<Company> companies) {
      this.companies = companies;
   }
   
}
=======
	@XmlElement(name="company")
	private List<Company> companies;

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	
}
>>>>>>> 340e6d1cfc27a51eda32f35a728ef5a3c75249e4
