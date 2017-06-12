package jeff.webController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jeff.domain.Question;
import jeff.service.CompanyService;
import jeff.service.QuestionService;

@Controller
@RequestMapping("question")
public class QuestionController {
   
   @Autowired
   private QuestionService service;
   
   @Autowired
   private CompanyService comService;
   
   @RequestMapping(value ="regist", method = RequestMethod.POST)
   public String registQuestion (Question question, HttpServletRequest req){
      service.registQuestion(question);
      return "redirect:find?questionId="+question.getQuestionId();
   }
   
   @RequestMapping(value = "update", method = RequestMethod.POST)
   public String updateQuestion (Question question){
      service.updateQuestion(question);
      return "redirect:find?questionId=" + question.getQuestionId();
   }
   
   @RequestMapping("remove")
   public String removeQuestion (int questionId, HttpServletRequest req){
      service.removeQuestion(questionId);
      return "redirect:findAll";
   }
   
   @RequestMapping("find")
   public String findQuestion (int questionId, Model model, HttpServletRequest req){
      Question q = service.findQuestion(questionId);
      HttpSession session = req.getSession();
      String comId = null;
      if(session != null || session.getAttribute("comId") != null){
         comId = (String)session.getAttribute("comId");
      }else{
         return "redirect:findAll";
      }
      
      model.addAttribute("question", q);
      model.addAttribute("loginedCompany",comService.findCompany(comId));
      return "/questionDetail";
   }

   @RequestMapping("findAll")
   public String findAllQuestion (Model model){
      List<Question> list = service.findAllQuestion();
      model.addAttribute("questionList", list);
      return "/questionList";
   }
   
   @RequestMapping(value="findCategory",method=RequestMethod.POST)
   public String findQuestionByCategory (String category,Model model){
      List<Question> list = service.findQuestionByCategoty(category);
      model.addAttribute("questionList",list);
      return "/questionList";
      
   }
   
   

}