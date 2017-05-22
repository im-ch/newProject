package jeff.store;

import java.util.List;

import jeff.domain.Answer;

public interface AnswerStore {

	void createAnswer(Answer answer);

	void deleteAnswer(int answerId);

	void modifyAnswer(Answer answer);

	Answer selectAnswer(int answerId);

	List<Answer> selectAllAnswer(int questionId);
}
