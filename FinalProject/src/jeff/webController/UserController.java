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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jeff.domain.Company;
import jeff.domain.User;
import jeff.service.CompanyService;
import jeff.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

   @Autowired
   private UserService service;
   
   @Autowired
   private CompanyService comService;

   @RequestMapping(value="create", method = RequestMethod.POST)
   public String registUser(User user) {
      service.registUser(user);
      return "redirect:/views/login.jsp";
   }

   @RequestMapping(value = "login", method = RequestMethod.POST)
   public String loginUser(@RequestParam("loginId") String id, @RequestParam("loginPassword")String password, HttpServletRequest req) {
      User loginedUser = service.findUser(id);
      Company loginedCompany = comService.findCompany(id);
      
      if (loginedUser != null || loginedCompany != null) {
         if (loginedUser != null && loginedUser.getPassword().equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("userId", id);
            session.setAttribute("userName", loginedUser.getName());
            return "redirect:/views/main.jsp";
         }else if (loginedCompany != null && loginedCompany.getComPassword().equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("comId", id);
            session.setAttribute("comName", loginedCompany.getComName());
            session.setAttribute("jeffCoin", loginedCompany.getJeffCoin());
            return "redirect:/views/main.jsp";
         }else {
            HttpSession session = req.getSession(false);
            session.invalidate();
            return "redirect:/views/login.jsp";
         }
      }else{
         return "redirect:/views/login.jsp";
      }
   }
   
   @RequestMapping("logout")
   public String logoutUser(HttpServletRequest req) {
      HttpSession session = req.getSession();
      session.invalidate();
      return "redirect:/views/main.jsp";
   }
   
   @RequestMapping(value = "modify", method = RequestMethod.GET)
   public String updateUser(String userId, Model model) {
      User user = service.findUser(userId);
      
      model.addAttribute("user", user);
      
      return "/userModify";
   }
   
   @RequestMapping(value = "modify", method = RequestMethod.POST)
   public String updateUser(User user, HttpServletRequest req) {
     HttpSession session = req.getSession();
     String userId = (String)session.getAttribute("userId");
     user.setUserId(userId);
      service.updateUser(user);
      return "redirect:detail?userId=" + userId;
   }
   
   @RequestMapping("remove")
   public String removeUser(HttpServletRequest req) {
      HttpSession session = req.getSession();
      String userId = (String)session.getAttribute("userId");
      service.removeUser(userId);
      return "redirect:/views/main.jsp";
   }
   
   @RequestMapping("list")
   public ModelAndView findAllUser() {
      List<User> list = service.findAllUsers();
      ModelAndView modelAndView = new ModelAndView("userList");
      modelAndView.addObject("userList", list);
      return modelAndView;
   }
//	관리자가 유저 정보보는 메소드
   @RequestMapping("findUserId")
   public ModelAndView findByUserId(@RequestParam("userId") String userId) {
      ModelAndView modelAndView = new ModelAndView("userInfo");
      modelAndView.addObject("user", service.findUser(userId));
      return modelAndView;
   }
   
   @RequestMapping("allUsers")
   public ModelAndView findAllUsers(){
      ModelAndView modelAndView = new ModelAndView("/userList");
      List<User> users = service.findAllUsers();
      List<Company> companys = comService.findAllCompany();
      List<Integer> allUsers = new ArrayList<>();
      
      if(users.size() > 0 && companys.size() > 0){
    	  allUsers.add(1);
      }
      
      modelAndView.addObject("allUsers", allUsers);
      modelAndView.addObject("users", users);
      modelAndView.addObject("companys", companys);
      return modelAndView;
   }
//   유저로그인시 자신의 info보는 메소드
   @RequestMapping("detail")
   public ModelAndView findByUserId(HttpServletRequest req) {
      ModelAndView modelAndView = new ModelAndView("userInfo");
      HttpSession session = req.getSession();
      String userId = (String)session.getAttribute("userId");
      
      modelAndView.addObject("user", service.findUser(userId));
      return modelAndView;
   }
   
   @RequestMapping(value="checkUserId",method=RequestMethod.POST)
   /**
    * @param req : 인풋태그로 부터 온 개인회원의 id , 이 파라미터는 ajax checkId를 통해서 전달된다. 
    * @return       : db에 있는 개인회원의 id로 파라미터로 받은 개인회원 id와 일치하는 id가 있을경우 해당 id를 리턴하고 없을경우 공백""을 리턴한다.
    */
   public @ResponseBody String checkId(HttpServletRequest req){
	   return  service.checkId(req.getParameter("userId"));
   }
   
}
