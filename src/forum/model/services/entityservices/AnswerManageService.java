package forum.model.services.entityservices;

import java.util.Date;

import forum.model.persistence.dao.DaoAnswer;
import forum.model.persistence.dao.DaoThread;
import forum.model.persistence.dao.DaoUser;
import forum.model.persistence.entities.AnswerEntity;
import forum.model.persistence.entities.ThreadEntity;
import forum.model.persistence.entities.UserEntity;

public class AnswerManageService {

	private DaoAnswer answerAccess;
	private DaoThread topicAccess;
	private DaoUser userAccess;
	
	public AnswerManageService() {
		answerAccess = new DaoAnswer();
		topicAccess = new DaoThread();
		userAccess = new DaoUser();
	}
	
	public void insertAnswer(Integer authorId, Integer topicId, String answerContent) {
		if (authorId > 0 && topicId > 0 && answerContent != "") {
			UserEntity author = userAccess.findById(authorId);
			ThreadEntity topic = topicAccess.findById(topicId);
			AnswerEntity currentAnswer = new AnswerEntity();
			currentAnswer.setAnswerAuthor(author);
			currentAnswer.setAnswerThread(topic);
			currentAnswer.setContent(answerContent);
			currentAnswer.setPostDate(new Date());
			answerAccess.create(currentAnswer);
		}
	}
	
	public void updateAnswer(AnswerEntity answer) {
		if (answer != null && answer.getId() > 0) {
			answerAccess.update(answer);
		}
	}
	
	public void deleteAnswer(Integer answerId) {
		answerAccess.delete(answerId);
	}
	
}
