package forum.model.dao;

import java.util.List;

import forum.model.entities.Topic;

public class DAOTopic extends AbstractDAO implements DAO<Topic> {

	@Override
	public void create(Topic topic) {
		createRecord(topic);
	}

	@Override
	public void update(Topic topic) {
		updateRecord(topic);
	}

	@Override
	public void delete(Integer id) {
		deleteRecord(Topic.class, id);
	}

	@Override
	public Topic findById(Integer id) {
		Topic wantedTopic = getEntityManager().find(Topic.class, id);
		closeEntityManager();
		return wantedTopic;
	}

	@Override
	public List<Topic> findAll() {
		List<Topic> topics = getEntityManager().
				createQuery("FROM Topic t", Topic.class).getResultList();
		closeEntityManager();
		return topics;
	}

}
