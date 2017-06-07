package jeff.webController;

import java.util.ArrayList;
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

import jeff.common.exception.YzRuntimeException;
import jeff.domain.Alliance;
import jeff.domain.Company;
import jeff.service.AllianceService;
import jeff.service.CompanyService;

@Controller
@RequestMapping("alliance")
public class AllianceController {

	@Autowired
	private AllianceService service;
	
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String registAlliance(Model model, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		String comId = (String) session.getAttribute("comId");
		Company company = companyService.findCompany(comId);
		
		String [] lo = company.getLocation().split(";");
	    company.setLocation("[" + lo[0] + "] " + lo[1] + " " + lo[2]);
		
	    model.addAttribute("company", company);
	    
		return "/allianceForm";
	}
	
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String registAlliance(Alliance alliance, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		String comId = (String) session.getAttribute("comId");
		Company company = companyService.findCompany(comId);
		alliance.setCompany(company);
		service.registAlliance(alliance);
		System.out.println(alliance.getCompany().getComId());
		return "redirect:detail?comId=" + comId;
	}

	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String updateAlliance(String comId, Model model) {
		
		Alliance alliance = service.findAlliance(comId);
	    model.addAttribute("alliance", alliance);
	      
		return "/allianceModify";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String updateAlliance(Alliance alliance, HttpServletRequest req) {
		HttpSession session = req.getSession();
	    String comId = (String)session.getAttribute("comId");
		alliance.setCompany(companyService.findCompany(comId));
		service.updateAlliance(alliance);
		return "redirect:detail?comId=" + comId;
	}

	@RequestMapping("delete")
	public String removeAlliance(HttpServletRequest req) {
		 HttpSession session = req.getSession();
	      String comId = (String) session.getAttribute("comId");
	      service.removeAlliance(comId);

	      return "redirect:/views/main.jsp";
	}

	// 기업이 자신의 제휴제안서 볼 때 메소드
	@RequestMapping("detail")
	public ModelAndView allianceDetail(HttpServletRequest req) {
	    HttpSession session = req.getSession();
	    String comId = (String)session.getAttribute("comId");
	    ModelAndView modelAndView = new ModelAndView("allianceDetail");
	    Alliance alliance = service.findAlliance(comId);
	    Company company = alliance.getCompany();
	    String [] lo = company.getLocation().split(";");
	    company.setLocation("[" + lo[0] + "] " + lo[1] + " " + lo[2]);
	    alliance.setCompany(company);
	    
	    modelAndView.addObject("alliance", alliance);
	    return modelAndView;
	}
	
	// 관리자가 기업 제휴제안서 볼 때 메소드
   @RequestMapping("findComId")
   public ModelAndView allianceDetail(@RequestParam("comId") String comId) {
      ModelAndView modelAndView = new ModelAndView("allianceDetail");
      modelAndView.addObject("alliance", service.findAlliance(comId));
      return modelAndView;
   }

	@RequestMapping("list")
	public String findAllianceCompany(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		String comId = (String)session.getAttribute("comId");
		List<String> list = service.findAllAlliance();
		List<Alliance> allianceList = new ArrayList<>();
		
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Alliance a = service.findAlliance(list.get(i));
				allianceList.add(a);
				continue;
			}
		}else {
			YzRuntimeException ex = new YzRuntimeException("제휴제안서가 없습니다.");
			if(comId == null){
				ex.setRedirectURL("/adminPage");
			}else{
				ex.setRedirectURL("/main");
			}
			throw ex;
		}
		model.addAttribute("allianceList", allianceList);
		return "/main";
	}

	@RequestMapping(value = "companyDetail")
	public String detailAllianceCompany(String comId, Model model) {
		Alliance alliance = service.findAlliance(comId);
		model.addAttribute("alliance", alliance);
		return "/companyDetail";
	}
	
}
