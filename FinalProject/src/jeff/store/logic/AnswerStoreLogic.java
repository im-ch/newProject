package jeff.store.logic;

import java.util.List;

import org.springframework.stereotype.Repository;

import jeff.domain.Answer;
import jeff.store.AnswerStore;

@Repository
public class AnswerStoreLogic implements AnswerStore{

	@Override
	public void createAnswer(Answer answer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAnswer(int answerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyAnswer(Answer answer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Answer selectAnswer(int answerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answer> selectAllAnswer(int questionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
