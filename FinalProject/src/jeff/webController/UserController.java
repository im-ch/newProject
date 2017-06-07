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
            return "redirect:/views/main.jsp";
         }else if (loginedCompany != null && loginedCompany.getComPassword().equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("comId", id);
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
   
   @RequestMapping("detail")
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
      allUsers.add(users.size());
      allUsers.add(companys.size());
      
      modelAndView.addObject("allUsers", allUsers);
      modelAndView.addObject("users", users);
      modelAndView.addObject("companys", companys);
      return modelAndView;
   }
}