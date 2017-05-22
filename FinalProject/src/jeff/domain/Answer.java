package jeff.domain;

import java.sql.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="answer")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class Answer {

	private int answerId;
	private String content;
	private String questionId;
	private Date regDate;
	
	private String name;
	
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", content=" + content + ", questionId=" + questionId + ", regDate="
				+ regDate + "]";
	}
	
	
}
