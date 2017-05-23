package jeff.store.mapper;

import java.util.List;

import jeff.domain.Answer;

public interface AnswerMapper {
	
	void createAnswer(Answer answer);

	void deleteAnswer(int answerId);

	void modifyAnswer(Answer answer);

	Answer selectAnswer(int answerId);

	List<Answer> selectAllAnswer(int questionId);

}
