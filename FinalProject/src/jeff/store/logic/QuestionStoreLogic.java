package jeff.store.logic;

import java.util.List;

import org.springframework.stereotype.Repository;

import jeff.domain.Question;
import jeff.store.QuestionStore;

@Repository
public class QuestionStoreLogic implements QuestionStore{

	@Override
	public void createQuestion(Question question) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteQuestion(int questionId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyQuestion(Question question) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Question selectQuestion(int questionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> selectAllQuestion() {
		// TODO Auto-generated method stub
		return null;
	}

}
