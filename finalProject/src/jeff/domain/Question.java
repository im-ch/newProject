package jeff.domain;

import java.sql.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="question")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class Question {

	private String writerId;
	private int questionId;
	private String title;
	private String content;
	private String category;
	private Date regDate;
	@XmlElement(name="answer")
	private List<Answer> answerList;
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public List<Answer> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
	@Override
	public String toString() {
		return "Question [writerId=" + writerId + ", questionId=" + questionId + ", title=" + title + ", content="
				+ content + ", category=" + category + ", regDate=" + regDate + ", answerList=" + answerList + "]";
	}
	
	
	
	
	
}
