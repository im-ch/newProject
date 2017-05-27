package jeff.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jeff.domain.Answer;
import jeff.domain.Question;
import jeff.service.QuestionService;
import jeff.store.AnswerStore;
import jeff.store.QuestionStore;

@Service
public class QuestionServiceLogic implements QuestionService{
	
	@Autowired
	private QuestionStore qStore;
	
	@Autowired
	private AnswerStore aStore;
	

	@Override
	public void registQuestion(Question question) {
		qStore.createQuestion(question);
	}

	@Override
	public void removeQuestion(int questionId) {
		qStore.deleteQuestion(questionId);
	}

	@Override
	public void updateQuestion(Question question) {
		qStore.modifyQuestion(question);
	}

	@Override
	public Question findQuestion(int questionId) {
		return qStore.selectQuestion(questionId);
	}

	@Override
	public List<Question> findAllQuestion() {
		return qStore.selectAllQuestion();
	}

	@Override
	public void registAnswer(Answer answer) {
		aStore.createAnswer(answer);
	}

	@Override
	public void removeAnswer(int answerId) {
		aStore.deleteAnswer(answerId);
	}

	@Override
	public void updateAnswer(Answer answer) {
		aStore.modifyAnswer(answer);
	}

	@Override
	public Answer findAnswer(int answerId) {
		return aStore.selectAnswer(answerId);
	}
	
	

}
