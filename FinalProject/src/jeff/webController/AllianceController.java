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

import jeff.common.exception.YzRuntimeException;
import jeff.domain.Alliance;
import jeff.service.AllianceService;
import jeff.service.CompanyService;

@Controller
@RequestMapping("alliance")
public class AllianceController {

	@Autowired
	private AllianceService service;
	
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String registAlliance(Alliance alliance, HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		String comId = (String) session.getAttribute("comId");
		alliance.setCompany(companyService.findCompany(comId));
		service.registAlliance(alliance);
		return "redirect:/allianceDetail?comId=test";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateAlliance(Alliance alliance) {
		service.updateAlliance(alliance);
		String comId = alliance.getCompany().getComId();
		return "redirect:detail.do?comId=" + comId;
	}

	@RequestMapping("delete")
	public String removeAlliance(String comId) {
		service.removeAlliance(comId);
		return "/companyMypage";
	}

	@RequestMapping("detail")
	public String findAlliance(String comId, Model model) {
		Alliance alliance = service.findAlliance(comId);
		model.addAttribute("alliance", alliance);
		return "/allianceDetail";
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
