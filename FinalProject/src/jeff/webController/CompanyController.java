package jeff.webController;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jeff.domain.Alliance;
import jeff.domain.Companies;
import jeff.domain.Company;
import jeff.domain.CompanyImage;
import jeff.service.AllianceService;
import jeff.service.CompanyImageService;
import jeff.service.CompanyService;

@Controller
@RequestMapping("company")
public class CompanyController {

   @Autowired
   private CompanyService service;
   
   @Autowired
   private CompanyImageService imageService;
   
   @Autowired
   private AllianceService allianceService;


   @RequestMapping(value = "create", method = RequestMethod.POST)
   public String registCompany(Company company) {
      service.registCompany(company);

      return "redirect:/views/login.jsp";
   }

   @RequestMapping(value = "modify", method = RequestMethod.GET)
   public String ModifyCompany(String comId, Model model) {
      Company company = service.findCompany(comId);
      model.addAttribute("company", company);

      return "/companyInfo";
   }

   @RequestMapping(value = "modify", method = RequestMethod.POST)
   public String ModifyCompany(Company company) {
      service.updateCompany(company);
      return "redirect:detail?comId=" + company.getComId();
   }

   @RequestMapping("remove")
   public String RemoveCompany(HttpServletRequest req) {
      HttpSession session = req.getSession();
      String comId = (String) session.getAttribute("comId");
      service.removeCompany(comId);

      return "redirect:/views/main.jsp";
   }

   @RequestMapping(value = "login", method = RequestMethod.POST)
   public String loginCompany(Company company, HttpServletRequest req) {

      Company loginedCompany = service.findCompany(company.getComId());

      if (loginedCompany != null) {
         if (loginedCompany.getComPassword().equals(company.getComPassword())) {
            HttpSession session = req.getSession();
            session.setAttribute("comId", company.getComId());
            return "redirect:/views/main.jsp";
         } else {
            HttpSession session = req.getSession(false);
            session.invalidate();
            return "/login";
         }
      } else {
         return "/login";
      }
   }

   @RequestMapping("logout")
   public String logoutCompany(HttpServletRequest req) {
      HttpSession session = req.getSession();
      session.invalidate();

      return "redirect:/views/main.jsp";
   }

   @RequestMapping("list")
   public ModelAndView findAllCompany() {
      List<Company> list = service.findAllCompany();
      ModelAndView modelAndView = new ModelAndView("companyList.jsp");
      modelAndView.addObject("companyList", list);
      return modelAndView;

   }

   @RequestMapping("findByComId")
   public ModelAndView findByComId(@RequestParam("comId") String comId) {
      ModelAndView modelAndView = new ModelAndView("/companyInfo");
      modelAndView.addObject("company", service.findCompany(comId));
      return modelAndView;

   }

   @RequestMapping("findBycomName")
   public ModelAndView findBycomName(@RequestParam("comName") String comName) {
      ModelAndView modelAndView = new ModelAndView("companyList.jsp");
      modelAndView.addObject("companyList", service.findCompanyByName(comName));
      return modelAndView;
   }
// companyInfo뿌리는 메소드
   @RequestMapping("detail")
   public ModelAndView showCompanyDetail(HttpServletRequest req) {
      HttpSession session = req.getSession();
      String comId = (String)session.getAttribute("comId");
      ModelAndView modelAndView = new ModelAndView("companyInfo");
      Company company = service.findCompany(comId);
      String [] lo = company.getLocation().split(";");
      company.setLocation("[" + lo[0] + "] " + lo[1] + " " + lo[2]);
      
      modelAndView.addObject("images", imageService.findCompanyImageList(comId));
      modelAndView.addObject("company", company);
      return modelAndView;
   }
   
   @RequestMapping(value="mapList", produces="application/xml")
   public @ResponseBody Companies mapToXml(HttpServletRequest req){
      List<Company> list = new ArrayList<>();
      Companies companies = new Companies();
//      list = service.findAllCompany();
      
      HttpSession session = req.getSession();
      String location = (String)session.getAttribute("location");

      companies.setCompanies(locationReplace(list, location));
      return companies;
   }
   
   @RequestMapping(value="mapListByComName", produces="application/xml")
   public @ResponseBody Companies mapXMLByComName(HttpServletRequest req, String comName){
      List<Company> list = new ArrayList<>();
      Companies companies = new Companies();
      
      HttpSession session = req.getSession();
      String location = (String)session.getAttribute("location");
      HashMap<String, Object> map = new HashMap<>();
      map.put("location", location);
      map.put("comName", comName);
      
      list = service.findCompanyByLocationAndCompany(map);
      
      companies.setCompanies(locationReplace(list, location));
      return companies;
   }
   
   @RequestMapping("locationAndComName")
   public String findByLocation (HttpServletRequest req, @RequestParam("comName") String comName, Model model){
      HttpSession session = req.getSession();
      String location = (String)session.getAttribute("location");
      String value [] = location.split("\\s");
      
      HashMap<String, Object> map = new HashMap<>();
      map.put("location", value[1] + " " + value[2]);
      map.put("comName", comName);
      
      List<Company> listCom = service.findCompanyByLocationAndCompany(map);

      model.addAttribute("companies", replace(listCom));
       return "/recommendCompanyList";
   }
   
   @RequestMapping("locationAndCategory")
   public String findByCategory (HttpServletRequest req, @RequestParam("category") String category, Model model){
      HttpSession session = req.getSession();
      String location = (String)session.getAttribute("location");
      String value [] = location.split("\\s");
      
      HashMap<String, Object> map = new HashMap<>();
      map.put("location", value[1] + " " + value[2]);
      map.put("category", category);
      
      List<Company> listCom = service.findCompanyByLocationAndCategory(map);

      model.addAttribute("companies", replace(listCom));
       return "/recommendCompanyList";
   }
   
	@RequestMapping(value="saveLocation", produces="application/xml")
	public void saveLocation(HttpServletRequest req, String location){
		HttpSession session = req.getSession();
		session.removeAttribute("location");
        if(location.contains("로 ")){
           String [] lo = location.split("로 ");
           String loo = lo[0] + "로";
           session.setAttribute("location", loo);
        }else if (location.contains("길 ")){
           String [] lo = location.split("길 ");
           String loo = lo[0] + "길";
           session.setAttribute("location", loo);
        }else if (location.contains("동 ")){
           String [] lo = location.split("동 ");
           String loo = lo[0] + "동";
           session.setAttribute("location", loo);
        }
     }

   //   String 보낼때 문자 깨지는거 -> produces="text/plain;charset=UTF-8"
      @RequestMapping(value="loadLocation", produces="text/plain;charset=UTF-8")
      public @ResponseBody String loadLocation(HttpServletRequest req,HttpServletResponse reqs){
         HttpSession session = req.getSession();
         String location = (String)session.getAttribute("location");
         
         if(location == null || location == ""){
            location = "서울 강남구 봉은사로";
         }
         session.setAttribute("location", location);
         return location;
      }
      
      
      private List<Company> replace(List<Company> companies){
    	  List<CompanyImage> image = null;
          
          for(Company c : companies){
        	  image = new ArrayList<>();
        	  if(c.getImageList().size() > 0){
        		  image.add(c.getImageList().get(0));
        		  c.setImageList(image);
        	  }else {
        		  CompanyImage img = new CompanyImage();
        		  img.setFileName("noimage.png");
        		  image.add(img);
        		  c.setImageList(image);
        	  }
        	  Alliance al = allianceService.findAlliance(c.getComId());
        	  if(al != null){
        		  c.setOwnerName(al.getDetail());
        	  }else{
        		  c.setOwnerName(" ");
        	  }
          }
          return companies;
      }
      
      private List<Company> locationReplace(List<Company> list, String location){
          String value [] = location.split("\\s");
          list = service.findCompanyByLocation(value[1] + " " + value[2]);
          for(Company c : list){
             String location2 = c.getLocation();
             String [] lo = location2.split(";");
             
             String [] lo2 = lo[1].split("\\(");
             c.setLocation(lo2[0]);
          }
    	  return list;
      }
   
}