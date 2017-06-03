package jeff.webController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.ResponseBody;
=======
>>>>>>> eojin

import jeff.domain.Company;
import jeff.service.CompanyService;
import jeff.service.InterestingCompanyService;
<<<<<<< HEAD

=======
>>>>>>> eojin
@RequestMapping(value = "interesting")
@Controller
public class InterestingCompanyController {

	@Autowired
	private InterestingCompanyService service;
	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/register")
	public @ResponseBody String registInterestingCompany(HttpServletRequest req, String comId) {
		System.out.println("controller");
		HttpSession session = req.getSession();
<<<<<<< HEAD

=======
		
>>>>>>> eojin
		if (session == null || session.getAttribute("userId") == null) {
			return "redirect:login";
		}
<<<<<<< HEAD
		String userId = (String) session.getAttribute("userId");
=======
		
>>>>>>> eojin
		HashMap<String, Object> map = new HashMap<String, Object>();

		List<String> list = service.findInterestingCompany(userId);
		System.out.println(list.size());
		if (list != null || list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(comId)) {
					return "false";
				}
			}
		}

		map.put("userId", userId);
		map.put("comId", comId);

		service.registInterestingCompany(map);

		return "true";
	}

<<<<<<< HEAD
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String findInterestingCompany(HttpServletRequest req, Model model) {

		HttpSession session = req.getSession();

		String userId = (String) session.getAttribute("userId");

		if (session == null || session.getAttribute("userId") == null) {
<<<<<<< HEAD
			return "redirect:login.jsp";
=======
			return "redirect:login";
>>>>>>> hyun
		}
		List<String> comList = service.findInterestingCompany(userId);
=======
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public String findInterestingCompany(HttpServletRequest req, Model model) {

//		HttpSession session = req.getSession();
//
//		String userId = (String) session.getAttribute("userId");
//
//		if (session == null || session.getAttribute("userId") == null) {
//			return "redirect:login.jsp";
//		}
		List<String> comList = service.findInterestingCompany("heehyun");
>>>>>>> eojin
		List<Company> list = new ArrayList<>();

		for (int i = 0; i < comList.size(); i++) {
			list.add(companyService.findCompany(comList.get(i)));
		}
		System.out.println("컨트롤러");
		model.addAttribute("company", list);
<<<<<<< HEAD
		return "interestingCompany";
=======
		return "/interestingCompany";
>>>>>>> eojin
	}

	@RequestMapping(value = "/remove")
	public @ResponseBody String removeInterestingCompany(HttpServletRequest req, String comId) {
		HttpSession session = req.getSession();

		if (session == null || session.getAttribute("userId") == null) {
			return "redirect:login";
		}

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("userId", (String) session.getAttribute("userId"));
		map.put("comId", comId);

		service.removeInterestingCompany(map);

		return "true";
	}

}
