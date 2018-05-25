package forum.model.services;

import forum.model.dao.DAOTopic;
import forum.model.entities.Topic;

public class TopicService {

	private static DAOTopic topicAccess = new DAOTopic();
	
	public static boolean create(Topic topic) {
		if (topic.getAuthor() == null) return false;
		topicAccess.create(topic);
		return true;
	}
	
	public static boolean update(Topic topic) {
		if (topic.getId() <= 0 || topic == null) return false;
		topicAccess.update(topic);
		return true;
	}
	
	public static boolean delete(Integer id) {
		if (id <= 0) return false;
		topicAccess.delete(id);
		return true;
	}
	public static boolean delete(Topic topic) {
		return delete(topic.getId());
	}
	
}
