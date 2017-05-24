package jeff.service;

import java.util.List;

import jeff.domain.Answer;
import jeff.domain.Question;

public interface QuestionService {

	public void registQuestion(Question question);
	public void removeQuestion(int questionId);
	public void updateQuestion(Question question);
	public Question findQuestion(int questionId);
	public List<Question> findAllQuestion();
	public void registAnswer(Answer answer);
	public void removeAnswer(int answerId);
	public void updateAnswer(Answer answer);
	public Answer findAnswer(int answerId);
}
