package jeff.store.logic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jeff.domain.Answer;
import jeff.domain.Question;

public class QuestionStoreLogicTest {
	
	private QuestionStoreLogic store;
	
	@Before
	public void AnswerStoreLogicTest() {
		store = new QuestionStoreLogic();
	}
	

//	@Test
//	public void testCreateQuestion() {
//		Question q = new Question();
//		q.setContent("III");
//		q.setTitle("III");
//		q.setWriterId("IIs");
//		
//		store.createQuestion(q);
//	}

//	@Test
//	public void testDeleteQuestion() {
//		store.deleteQuestion(2);
//	}

//	@Test
//	public void testModifyQuestion() {
//		Question q = store.selectQuestion(1);
//		q.setContent("modify");
//		q.setTitle("modify");
//		store.modifyQuestion(q);
//	}

//	@Test
//	public void testSelectQuestion() {
//		Question q = store.selectQuestion(1);
//		List<Answer> list = q.getAnswerList();
//		System.out.println(list.get(0).getAnswerId());
//		System.out.println(list.size());
//		assertNotNull(list);
//	}

//	@Test
//	public void testSelectAllQuestion() {
//		List<Question> list = store.selectAllQuestion();
//		assertEquals(2, list.size());
//	}

}
