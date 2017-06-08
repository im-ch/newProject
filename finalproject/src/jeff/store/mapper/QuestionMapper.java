package jeff.store.mapper;

import java.util.List;

import jeff.domain.Question;

public interface QuestionMapper {
	
	void createQuestion(Question question);

	void deleteQuestion(int questionId);

	void modifyQuestion(Question question);

	Question selectQuestion(int questionId);

	List<Question> selectAllQuestion();
	
	List<Question> selectQuestionByCategory(String category);

}
