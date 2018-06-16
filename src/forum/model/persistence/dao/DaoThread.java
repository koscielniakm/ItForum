package forum.model.persistence.dao;

import java.util.List;

import forum.model.persistence.entities.ThreadEntity;

public class DaoThread extends AbstractDao implements Dao<ThreadEntity> {

	public DaoThread() {}
	
	@Override
	public void create(ThreadEntity thread) {
		createRecord(thread);
	}

	@Override
	public void update(ThreadEntity thread) {
		updateRecord(thread);
	}

	@Override
	public void delete(Integer id) {
		deleteRecord(ThreadEntity.class, id);
	}

	@Override
	public ThreadEntity findById(Integer id) {
		ThreadEntity wantedThread = getEntityManager().find(ThreadEntity.class, id);
		closeEntityManager();
		return wantedThread;
	}

	@Override
	public List<ThreadEntity> findAll() {
		List<ThreadEntity> threads = getEntityManager().
				createQuery("FROM ThreadEntity t", ThreadEntity.class).getResultList();
		closeEntityManager();
		return threads;
	}

}
