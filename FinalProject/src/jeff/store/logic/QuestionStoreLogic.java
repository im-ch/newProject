package jeff.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jeff.domain.Question;
import jeff.store.QuestionStore;
import jeff.store.mapper.QuestionMapper;

@Repository
public class QuestionStoreLogic implements QuestionStore {

	@Override
	public void createQuestion(Question question) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		QuestionMapper mapper = session.getMapper(QuestionMapper.class);
		mapper.createQuestion(question);
		session.close();
	}

	@Override
	public void deleteQuestion(int questionId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		QuestionMapper mapper = session.getMapper(QuestionMapper.class);
		mapper.deleteQuestion(questionId);
		session.close();
	}

	@Override
	public void modifyQuestion(Question question) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		QuestionMapper mapper = session.getMapper(QuestionMapper.class);
		mapper.modifyQuestion(question);
		session.close();
	}

	@Override
	public Question selectQuestion(int questionId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		QuestionMapper mapper = session.getMapper(QuestionMapper.class);
		Question question = mapper.selectQuestion(questionId);
		session.close();
		return question;
	}

	@Override
	public List<Question> selectAllQuestion() {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		QuestionMapper mapper = session.getMapper(QuestionMapper.class);
		List<Question> question = mapper.selectAllQuestion();
		session.close();
		return question;
	}

	@Override
	public 	List<Question> selectQuestionByCategory(String category) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		QuestionMapper mapper = session.getMapper(QuestionMapper.class);
		List<Question> question = mapper.selectQuestionByCategory(category);
		session.close();
		return question;
	}

}
