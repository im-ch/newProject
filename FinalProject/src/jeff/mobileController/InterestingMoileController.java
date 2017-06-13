package jeff.mobileController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jeff.domain.Companies;
import jeff.domain.Company;
import jeff.domain.CompanyImage;
import jeff.service.CompanyImageService;
import jeff.service.CompanyService;
import jeff.service.InterestingCompanyService;

@RequestMapping(value = "mobile/interesting")
@Controller
public class InterestingMoileController {

	@Autowired
	private InterestingCompanyService service;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CompanyImageService imgService;

	
	@RequestMapping(value = "/list", produces = "application/xml")
	public @ResponseBody Companies findInterestingCompany(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		if (session == null || session.getAttribute("userId") == null) {
			return null;
		}
		List<String> comList = service.findInterestingCompany(userId);
		List<Company> list = new ArrayList<>();
		List<CompanyImage> image = new ArrayList<>();

		for (int i = 0; i < comList.size(); i++) {
			list.add(companyService.findCompany(comList.get(i)));
		}
		for (Company c : list) {
			image = new ArrayList<>();
			if (c.getImageList().size() > 0) {
				image.add(c.getImageList().get(0));
				c.setImageList(image);
			} else {
				CompanyImage img = new CompanyImage();
				img.setFileName("noimage.png");
				image.add(img);
				c.setImageList(image);
			}
		}
		Companies companies = new Companies();
		companies.setCompanies(list);
		return companies;
	}

}
