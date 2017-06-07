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
<<<<<<< HEAD
<<<<<<< HEAD

   @Autowired
   private CompanyService comService;

   @RequestMapping(value = "/userCreate", method = RequestMethod.POST)
   public String registUser(User user) {
      service.registUser(user);
      return "login.jsp";
   }

   @RequestMapping(value = "login", method = RequestMethod.POST)
   public String loginUser(@RequestParam("loginId") String id,
         @RequestParam("loginPassword") String password, HttpServletRequest req) {
      User loginedUser = service.findUser(id);
      Company loginedCompany = comService.findCompany(id);


=======
   
   @Autowired
   private CompanyService comService;

   @RequestMapping(value="create", method = RequestMethod.POST)
=======

   @Autowired
   private CompanyService comService;

   @RequestMapping(value = "/userCreate", method = RequestMethod.POST)
>>>>>>> sangjin
   public String registUser(User user) {
      service.registUser(user);
      return "login.jsp";
   }

   @RequestMapping(value = "login", method = RequestMethod.POST)
   public String loginUser(@RequestParam("loginId") String id,
         @RequestParam("loginPassword") String password, HttpServletRequest req) {
      User loginedUser = service.findUser(id);
      Company loginedCompany = comService.findCompany(id);
<<<<<<< HEAD
      
>>>>>>> 75fdce9e41d3aad4ce7e48897fa9e0db704c7903
=======


>>>>>>> sangjin
      if (loginedUser != null || loginedCompany != null) {
         if (loginedUser != null && loginedUser.getPassword().equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("userId", id);
            return "redirect:/views/main.jsp";
<<<<<<< HEAD
<<<<<<< HEAD
         } else if (loginedCompany != null && loginedCompany.getComPassword().equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("comId", id);
            return "redirect:/views/main.jsp";
         } else {
            HttpSession session = req.getSession(false);
            session.invalidate();
            return "redirect:/views/main.jsp";
         }
      } else {
         return "redirect:/views/main.jsp";
      }
   }

=======
         }else if (loginedCompany != null && loginedCompany.getComPassword().equals(password)) {
=======
         } else if (loginedCompany != null && loginedCompany.getComPassword().equals(password)) {
>>>>>>> sangjin
            HttpSession session = req.getSession();
            session.setAttribute("comId", id);
            return "redirect:/views/main.jsp";
         } else {
            HttpSession session = req.getSession(false);
            session.invalidate();
            return "redirect:/views/main.jsp";
         }
      } else {
         return "redirect:/views/main.jsp";
      }
   }
<<<<<<< HEAD
   
>>>>>>> 75fdce9e41d3aad4ce7e48897fa9e0db704c7903
=======

>>>>>>> sangjin
   @RequestMapping("logout")
   public String logoutUser(HttpServletRequest req) {
      HttpSession session = req.getSession();
      session.invalidate();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> f19ae54054c9610a9539ae011508ff1e94bbe72d
      return "redirect:/views/main.jsp";
   }

   @RequestMapping(value = "/userModify", method = RequestMethod.GET)
   public String updateUser(String userId, Model model) {
      User user = service.findUser(userId);
<<<<<<< HEAD

      model.addAttribute("userInfo", user);

      return "userModifyForm.jsp";
   }

   @RequestMapping(value = "/userModify", method = RequestMethod.POST)
   public String updateUser(User user) {
      service.updateUser(user);
      return "redirect:userDetail?userId=" + user.getUserId();
=======
      
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
>>>>>>> f19ae54054c9610a9539ae011508ff1e94bbe72d
   }

   @RequestMapping("/userRemove")
   public String removeUser(HttpServletRequest req) {
      HttpSession session = req.getSession();
      String userId = (String) session.getAttribute("userId");
      service.removeUser(userId);
<<<<<<< HEAD
      return "redirect:main";
   }

   @RequestMapping("/userList")
=======
      return "redirect:/main";
=======
      return "redirect:/views/main.jsp";
>>>>>>> sangjin
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
=======
      return "redirect:/views/main.jsp";
>>>>>>> f19ae54054c9610a9539ae011508ff1e94bbe72d
   }

   @RequestMapping("/userRemove")
   public String removeUser(HttpServletRequest req) {
      HttpSession session = req.getSession();
      String userId = (String) session.getAttribute("userId");
      service.removeUser(userId);
      return "redirect:main";
   }
<<<<<<< HEAD
   
   @RequestMapping("list")
>>>>>>> 75fdce9e41d3aad4ce7e48897fa9e0db704c7903
=======

   @RequestMapping("/userList")
>>>>>>> sangjin
   public ModelAndView findAllUser() {
      List<User> list = service.findAllUsers();
      ModelAndView modelAndView = new ModelAndView("userList");
      modelAndView.addObject("userList", list);
      return modelAndView;
   }
<<<<<<< HEAD
<<<<<<< HEAD

   @RequestMapping("/userDetail")
=======
   
   @RequestMapping("detail")
>>>>>>> 75fdce9e41d3aad4ce7e48897fa9e0db704c7903
=======

   @RequestMapping("/userDetail")
>>>>>>> sangjin
   public ModelAndView findByUserId(@RequestParam("userId") String userId) {
      ModelAndView modelAndView = new ModelAndView("userInfo");
      modelAndView.addObject("user", service.findUser(userId));
      return modelAndView;
   }
<<<<<<< HEAD
<<<<<<< HEAD

   @RequestMapping("/allUsers")
   public ModelAndView findAllUsers() {
=======
   
   @RequestMapping("allUsers")
   public ModelAndView findAllUsers(){
>>>>>>> 75fdce9e41d3aad4ce7e48897fa9e0db704c7903
=======

   @RequestMapping("/allUsers")
   public ModelAndView findAllUsers() {
>>>>>>> sangjin
      ModelAndView modelAndView = new ModelAndView("/userList");
      List<User> users = service.findAllUsers();
      List<Company> companys = comService.findAllCompany();
      List<Integer> allUsers = new ArrayList<>();
      allUsers.add(users.size());
      allUsers.add(companys.size());
<<<<<<< HEAD
<<<<<<< HEAD

=======
      
>>>>>>> 75fdce9e41d3aad4ce7e48897fa9e0db704c7903
=======

>>>>>>> sangjin
      modelAndView.addObject("allUsers", allUsers);
      modelAndView.addObject("users", users);
      modelAndView.addObject("companys", companys);
      return modelAndView;
   }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
}
=======
}
>>>>>>> 75fdce9e41d3aad4ce7e48897fa9e0db704c7903
=======
}
>>>>>>> sangjin
=======
}
>>>>>>> f19ae54054c9610a9539ae011508ff1e94bbe72d
