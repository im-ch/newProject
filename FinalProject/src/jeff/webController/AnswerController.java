package jeff.webController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jeff.domain.Answer;
import jeff.service.QuestionService;


@Controller
@RequestMapping("answer")
public class AnswerController {


	@Autowired
	private QuestionService service;
	
	@RequestMapping(value = "/registAnswer", method = RequestMethod.POST)
	public String registAnswer(Answer answer) {
		service.registAnswer(answer);
		return "redirect:questionDetail?QuestionId=" + answer.getQuestionId();
	}
	
	@RequestMapping("/removeAnswer")
	public String removeAnswer(int answerId) {
		service.removeAnswer(answerId);
		List<Answer> a = service.findAnswer(answerId);
		return "redirect:questionDetail?QuestionId=" + a.get(answerId);
	}
	
	@RequestMapping(value = "/modifyAnswer", method = RequestMethod.GET)
	public String updateAnswer(Model model, int answerId) {
		List<Answer> answer = service.findAnswer(answerId);
		model.addAttribute("answer", answer);
		model.addAttribute("modifyForm", "modify");
		return "redirect:questionDetail?QuestionId=" + answer.get(answerId);
	}
	
	@RequestMapping(value = "/modifyAnswer", method = RequestMethod.POST)
	public String updateAnswer(Answer answer) {
		service.updateAnswer(answer);
		return "redirect:questionDetail?QuestionId=" + answer.getQuestionId();
	}
}
