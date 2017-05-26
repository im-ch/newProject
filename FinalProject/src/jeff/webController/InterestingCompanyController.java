package jeff.webController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jeff.domain.Company;
import jeff.service.CompanyService;
import jeff.service.InterestingCompanyService;

@Controller
public class InterestingCompanyController {

	@Autowired
	private InterestingCompanyService service;
	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "registerInterestingCompany")
	public String registInterestingCompany(HttpServletRequest req, String comId) {

		HttpSession session = req.getSession(false);
		HashMap<String, Object> map = new HashMap<String, Object>();

//		if (session == null || session.getAttribute("userId") == null) {
//			return "redirect:login";
//		}

		map.put("userId", "heehyun");
		map.put("comId", comId);

		service.registInterestingCompany(map);

		return "redirect:interestingCompanyList";

	}

	@RequestMapping(value = "interestingCompanyList")
	public String findInterestingCompany(HttpServletRequest req, Model model) {

		HttpSession session = req.getSession(false);

		String userId = (String) session.getAttribute("userId");

//		if (session == null || session.getAttribute("userId") == null) {
//			return "redirect:login";
//		}

		List<String> comList = service.findInterestingCompany("heehyun");
		System.out.println(comList.size());
		List<Company> list = new ArrayList<>();

		for (int i = 0; i < comList.size(); i++) {
			list.add(companyService.findCompany(comList.get(i)));
		}
		model.addAttribute("company", list);

		return "interestingCompany.jsp";
	}

	@RequestMapping(value = "removeInterestingCompany")
	public String removeInterestingCompany(HttpServletRequest req, String comId) {
		
		
		return null;
	}

	// findInterestingCompany(req: HttpServletRequest, model : Model) : String
	// removeInterestingCompany(req: HttpServletRequest, companyId : String) :
	// String

}
