package jeff.webController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jeff.domain.Company;
import jeff.service.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService service;

	@RequestMapping(value = "/companyCreate", method = RequestMethod.POST)
	public String registCompany(Company company) {
		service.registCompany(company);

		return "redirect:login.jsp";

	}

	@RequestMapping(value = "/companyModify", method = RequestMethod.GET)
	public String ModifyCompany(String comId, Model model) {
		Company company = service.findCompany(comId);
		model.addAttribute("boardDetail", company);

		return "companyInfo.jsp";
	}

	@RequestMapping(value = "/companyModify", method = RequestMethod.POST)
	public String ModifyCompany(Company company) {
		service.updateCompany(company);
		return "redirect:companyDetail?comId=" + company.getComId();
	}

	@RequestMapping("/companyRemove")
	public String RemoveCompany(HttpServletRequest req) {

		HttpSession session = req.getSession();
		String comId = (String) session.getAttribute("comId");
		service.removeCompany(comId);

		return "redirect:main.jsp";
	}

	@RequestMapping(value = "/companyLogin", method = RequestMethod.POST)
	public String loginCompany(Company company, HttpServletRequest req) {

		Company loginedCompany = service.findCompany(company.getComId());

		if (loginedCompany != null) {
			if (loginedCompany.getComPassword().equals(company.getComPassword())) {
				HttpSession session = req.getSession();
				session.setAttribute("comId", company.getComId());
				return "redirect:main.jsp";
			} else {
				HttpSession session = req.getSession(false);
				session.invalidate();
				return "login.jsp";
			}
		} else {
			return "login.jsp";
		}

	}

	@RequestMapping("/companyLogout")
	public String logoutCompany(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();

		return "redirect:main.jsp";
	}

	@RequestMapping("/companyList")
	public ModelAndView findAllCompany() {

		List<Company> list = service.findAllCompany();
		ModelAndView modelAndView = new ModelAndView("companyList.jsp");
		modelAndView.addObject("companyList", list);
		return modelAndView;

	}

	@RequestMapping("/findByComId")
	public ModelAndView findByComId(@RequestParam("comId") String comId) {
		Company company = service.findCompany(comId);
		ModelAndView modelAndView = new ModelAndView("companyList.jsp");
		modelAndView.addObject("companyList", service.findCompany(comId));
		return modelAndView;

	}

	@RequestMapping("/findByCategory")
	public ModelAndView findByCategory(@RequestParam("category") String category) {
		List<Company> list = service.findCompanyByCategory(category);
		ModelAndView modelAndView = new ModelAndView("companyList.jsp");
		modelAndView.addObject("companyList", service.findCompanyByCategory(category));
		return modelAndView;

	}

	@RequestMapping("/findBycomName")
	public ModelAndView findBycomName(@RequestParam("comName") String comName) {
		Company company = service.findCompanyByName(comName);
		ModelAndView modelAndView = new ModelAndView("companyList.jsp");
		modelAndView.addObject("companyList", service.findCompanyByName(comName));
		return modelAndView;
	}

	@RequestMapping("/companyDetail")
	public ModelAndView showCompanyDetail(@RequestParam("comId") String comId) {
		ModelAndView modelAndView = new ModelAndView("companyDetail.jsp");
		modelAndView.addObject("company", service.findCompany(comId));
		return modelAndView;
	}

}
