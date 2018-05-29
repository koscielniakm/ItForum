package forum.model.dao;

import java.util.List;

import forum.model.entities.TopicEntity;

public class DaoTopic extends AbstractDao implements Dao<TopicEntity> {

	public DaoTopic() {}
	
	@Override
	public void create(TopicEntity topic) {
		createRecord(topic);
	}

	@Override
	public void update(TopicEntity topic) {
		updateRecord(topic);
	}

	@Override
	public void delete(Integer id) {
		deleteRecord(TopicEntity.class, id);
	}

	@Override
	public TopicEntity findById(Integer id) {
		TopicEntity wantedTopic = getEntityManager().find(TopicEntity.class, id);
		closeEntityManager();
		return wantedTopic;
	}

	@Override
	public List<TopicEntity> findAll() {
		List<TopicEntity> topics = getEntityManager().
				createQuery("FROM TopicEntity t", TopicEntity.class).getResultList();
		closeEntityManager();
		return topics;
	}

}
