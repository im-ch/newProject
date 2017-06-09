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
import org.springframework.web.bind.annotation.ResponseBody;

import jeff.domain.Company;
import jeff.domain.CompanyImage;
import jeff.service.CompanyImageService;
import jeff.service.CompanyService;
import jeff.service.InterestingCompanyService;

@RequestMapping(value = "interesting")
@Controller
public class InterestingCompanyController {
   @Autowired
   private InterestingCompanyService service;
   @Autowired
   private CompanyService companyService;
   @Autowired
   private CompanyImageService imgService;

   @RequestMapping(value = "/register")
   public @ResponseBody String registInterestingCompany(HttpServletRequest req, String comId) {
      System.out.println("controller");
      HttpSession session = req.getSession();
      if (session == null || session.getAttribute("userId") == null) {
         return "redirect:login";
      }
      String userId = (String) session.getAttribute("userId");
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

   @RequestMapping(value = "/list", method = RequestMethod.GET)
   public String findInterestingCompany(HttpServletRequest req, Model model) {

      HttpSession session = req.getSession();
      String userId = (String) session.getAttribute("userId");
      if (session == null || session.getAttribute("userId") == null) {
         return "redirect:login";
      }
      List<String> comList = service.findInterestingCompany(userId);
      List<Company> list = new ArrayList<>();
      List<CompanyImage> imgList = new ArrayList<>();

      for (int i = 0; i < comList.size(); i++) {
         list.add(companyService.findCompany(comList.get(i)));
      }
      model.addAttribute("company", list);
      return "interestingCompany";
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