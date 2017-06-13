package jeff.mobileController;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jeff.domain.Company;
import jeff.domain.User;
import jeff.service.CompanyService;
import jeff.service.UserService;

@RequestMapping(value = "mobile/user")
@Controller
public class UserMobileController {
	@Autowired
	private UserService service;

	@Autowired
	private CompanyService comService;

	@RequestMapping(value = "login")
	public @ResponseBody String loginUser(@RequestParam("loginId") String id,
			@RequestParam("loginPassword") String password, HttpServletRequest req) {

		User loginedUser = service.findUser(id);
		Company loginedCompany = comService.findCompany(id);

		if (loginedUser != null || loginedCompany != null) {
			if (loginedUser != null && loginedUser.getPassword().equals(password)) {
				HttpSession session = req.getSession();
				session.setAttribute("userId", id);
				return "true";
			} else if (loginedCompany != null && loginedCompany.getComPassword().equals(password)) {
				HttpSession session = req.getSession();
				session.setAttribute("comId", id);
				return "true";
			} else {
				HttpSession session = req.getSession(false);
				session.invalidate();
				return "false";
			}
		} else {
			return "false";
		}
	}

	@RequestMapping(value = "logout")
	public @ResponseBody String logoutUser(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "redirect:/views/main.jsp";
	}

}
