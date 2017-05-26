package jeff.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jeff.domain.Answer;
import jeff.store.AnswerStore;
import jeff.store.mapper.AnswerMapper;

@Repository
public class AnswerStoreLogic implements AnswerStore{

	@Override
	public void createAnswer(Answer answer) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		AnswerMapper mapper = session.getMapper(AnswerMapper.class);
		mapper.createAnswer(answer);
		session.close();		
	}

	@Override
	public void deleteAnswer(int answerId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		AnswerMapper mapper = session.getMapper(AnswerMapper.class);
		mapper.deleteAnswer(answerId);
		session.close();		
	}

	@Override
	public void modifyAnswer(Answer answer) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		AnswerMapper mapper = session.getMapper(AnswerMapper.class);
		mapper.modifyAnswer(answer);
		session.close();		
	}

	@Override
	public Answer selectAnswer(int answerId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		AnswerMapper mapper = session.getMapper(AnswerMapper.class);
		Answer answer = mapper.selectAnswer(answerId);
		session.close();		
		return answer;
	}

	@Override
	public List<Answer> selectAllAnswer(int questionId) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		AnswerMapper mapper = session.getMapper(AnswerMapper.class);
		List<Answer> answer = mapper.selectAllAnswer(questionId);
		session.close();		
		return answer;
	}

}
