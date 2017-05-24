package jeff.store.logic;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jeff.domain.Answer;

public class AnswerStoreLogicTest {
	
	private AnswerStoreLogic store;
	
	@Before
	public void AnswerStoreLogicTest() {
		store = new AnswerStoreLogic();
	}

//	@Test
//	public void testCreateAnswer() {
//		Answer a = new Answer();
//		a.setContent("asdasd");
//		a.setQuestionId(1);
//		
//		store.createAnswer(a);
//	}

//	@Test
//	public void testDeleteAnswer() {
//		store.deleteAnswer(4);
//	}

//	@Test
//	public void testModifyAnswer() {
//		Answer a = store.selectAnswer(4);
//		a.setContent("modify");
//		store.modifyAnswer(a);
//	}

//	@Test
//	public void testSelectAnswer() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testSelectAllAnswer() {
//		List<Answer> list = store.selectAllAnswer(1);
//		assertEquals(3, list.size());
//	}

}
