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

@Controller
@RequestMapping("alliance")
public class AllianceController {

	@Autowired
	private AllianceService service;
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registAlliance(Alliance alliance, HttpServletRequest req) {
		service.registAlliance(alliance);
		HttpSession session = req.getSession();
		String comId = (String) session.getAttribute("comId");
		return "redirect:/allianceDetail?comId=" + comId;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateAlliance(Alliance alliance) {
		service.updateAlliance(alliance);
		String comId = alliance.getCompany().getComId();
		return "redirect:/allianceDetail?comId=" + comId;
	}

	@RequestMapping("/delete")
	public String removeAlliance(String comId) {
		service.removeAlliance(comId);
		return "/companyMypage.jsp";
	}

	@RequestMapping("/detail")
	public String findAlliance(String comId, Model model) {
		Alliance alliance = service.findAlliance(comId);
		model.addAttribute("alliance", alliance);
		return "/allianceDetail.jsp";
	}

	@RequestMapping("/list")
	public String findAllianceCompany(Model model, HttpServletRequest req) {
		System.out.println("Dd");
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
				ex.setRedirectURL("adminPage.jsp");
			}else{
				ex.setRedirectURL("main.jsp");
			}
			throw ex;
		}
		model.addAttribute("allianceList", allianceList);
		return "/allianceList.jsp";
	}

	@RequestMapping(value = "/companyDetail")
	public String detailAllianceCompany(String comId, Model model) {
		Alliance alliance = service.findAlliance(comId);
		model.addAttribute("alliance", alliance);
		return "/companyDetail.jsp";
	}

}
