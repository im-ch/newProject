package jeff.webController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jeff.domain.Answer;
import jeff.domain.Question;
import jeff.service.QuestionService;

@Controller
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	private QuestionService service;
	
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String registQuestion (Question question, HttpServletRequest req){
		service.registQuestion(question);
		return "redirect:find?questionId=" + question.getQuestionId();
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
	public String findQuestion (int questionId, Model model){
		Question q = service.findQuestion(questionId);
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
