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
import jeff.service.UserService;

@Controller
@RequestMapping("question")
public class QuestionController {
   
   @Autowired
   private QuestionService service;
   @Autowired
   private CompanyService comService;
   @Autowired
   private UserService userService;
   
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
      String userId = null;
      if(session.getAttribute("comId") != null){
         comId = (String)session.getAttribute("comId");
         model.addAttribute("anyBody",comId);

      }else if(session.getAttribute("userId") != null){
         userId = (String)session.getAttribute("userId");
         model.addAttribute("anyBody", userId);
      }else{
         return "/questionDetail";
      }
      model.addAttribute("question", q);
            
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