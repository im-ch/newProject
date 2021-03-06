package jeff.store;

import java.util.List;

import jeff.domain.Question;

public interface QuestionStore {

	void createQuestion(Question question);

	void deleteQuestion(int questionId);

	void modifyQuestion(Question question);

	Question selectQuestion(int questionId);

	List<Question> selectAllQuestion();

}
