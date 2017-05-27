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
import org.springframework.web.bind.annotation.RequestMethod;

import jeff.domain.Company;
import jeff.service.CompanyService;
import jeff.service.InterestingCompanyService;

@Controller
public class InterestingCompanyController {

	@Autowired
	private InterestingCompanyService service;
	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/register")
	public String registInterestingCompany(HttpServletRequest req, String comId) {

		HttpSession session = req.getSession();
		HashMap<String, Object> map = new HashMap<String, Object>();

		if (session == null || session.getAttribute("userId") == null) {
			return "redirect:login.jsp";
		}

		map.put("userId", (String) session.getAttribute("userId"));
		map.put("comId", comId);

		service.registInterestingCompany(map);

		return "redirect:interestingCompany/list";

	}

	@RequestMapping(value = "list.do", method=RequestMethod.GET)
	public String findInterestingCompany(HttpServletRequest req, Model model) {

//		HttpSession session = req.getSession();
//
//		String userId = (String) session.getAttribute("userId");
//
//		if (session == null || session.getAttribute("userId") == null) {
//			return "redirect:login.jsp";
//		}
		
		System.out.println("¿Ô´Ù°¨");
		List<String> comList = service.findInterestingCompany("heehyun");
		System.out.println(comList.size());
		List<Company> list = new ArrayList<>();

		for (int i = 0; i < comList.size(); i++) {
			list.add(companyService.findCompany(comList.get(i)));
		}
		model.addAttribute("company", list);

		return "interestingCompany.jsp";
	}

	@RequestMapping(value = "/remove")
	public String removeInterestingCompany(HttpServletRequest req, String comId) {

		HttpSession session = req.getSession();

		if (session == null || session.getAttribute("userId") == null) {
			return "redirect:login.jsp";
		}

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("userId", (String) session.getAttribute("userId"));
		map.put("comId", comId);

		service.removeInterestingCompany(map);

		return "redirect:interestingCompany/list";
	}

}
