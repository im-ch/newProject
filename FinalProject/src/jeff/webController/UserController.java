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

import jeff.domain.User;
import jeff.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/userCreate", method = RequestMethod.POST)
	public String registUser(User user) {
		service.registUser(user);
		return "login.jsp";
	}

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public String loginUser(User user, HttpServletRequest req) {
		User loginedUser = service.findUser(user.getUserId());
		if (loginedUser != null) {
			if (loginedUser.getPassword().equals(user.getPassword())) {
				HttpSession session = req.getSession();
				session.setAttribute("userId", user.getUserId());
				return "redirect:main";
			} else {
				HttpSession session = req.getSession(false);
				session.invalidate();
				return "login.jsp";
			}
		}else{
			return "login.jsp";
		}
	}
	
	@RequestMapping("/userLogout")
	public String logoutUser(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "redirect:main";
	}
	
	@RequestMapping(value = "/userModify", method = RequestMethod.GET)
	public String updateUser(String userId, Model model) {
		User user = service.findUser(userId);
		
		model.addAttribute("userInfo", user);
		
		return "userModifyForm.jsp";
	}
	
	@RequestMapping(value = "/userModify", method = RequestMethod.POST)
	public String updateUser(User user) {
		service.updateUser(user);
		return "redirect:userDetail?userId=" + user.getUserId();
	}
	
	@RequestMapping("/userRemove")
	public String removeUser(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String userId = (String)session.getAttribute("userId");
		service.removeUser(userId);
		return "redirect:main";
	}
	
	@RequestMapping("/userList")
	public ModelAndView findAllUser() {
		List<User> list = service.findAllUsers();
		ModelAndView modelAndView = new ModelAndView("userList.jsp");
		modelAndView.addObject("userList", list);
		return modelAndView;
	}
	
	@RequestMapping("/userDetail")
	public ModelAndView findByUserId(@RequestParam("userId") String userId) {
		ModelAndView modelAndView = new ModelAndView("userInfo.jsp");
		modelAndView.addObject("user", service.findUser(userId));
		return modelAndView;
	}
}
