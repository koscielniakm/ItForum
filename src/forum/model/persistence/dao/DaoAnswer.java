package forum.model.persistence.dao;

import java.util.List;

import forum.model.persistence.entities.AnswerEntity;

public class DaoAnswer extends AbstractDao implements Dao<AnswerEntity> {

	@Override
	public void create(AnswerEntity answer) {
		createRecord(answer);
	}

	@Override
	public void update(AnswerEntity answer) {
		updateRecord(answer);
	}

	@Override
	public void delete(Integer id) {
		deleteRecord(AnswerEntity.class, id);
	}

	@Override
	public AnswerEntity findById(Integer id) {
		AnswerEntity wantedAnswer = getEntityManager().find(AnswerEntity.class, id);
		closeEntityManager();
		return wantedAnswer;
	}

	@Override
	public List<AnswerEntity> findAll() {
		List<AnswerEntity> answers = getEntityManager().
			createQuery("FROM AnswerEntity a", AnswerEntity.class).getResultList();
		closeEntityManager();
		return answers;
	}

}
