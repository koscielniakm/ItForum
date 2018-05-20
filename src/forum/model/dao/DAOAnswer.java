package forum.model.dao;

import java.util.List;

import forum.model.entities.Answer;

public class DAOAnswer extends AbstractDAO implements DAO<Answer> {

	@Override
	public void create(Answer answer) {
		createRecord(answer);
	}

	@Override
	public void update(Answer answer) {
		updateRecord(answer);
	}

	@Override
	public void delete(Integer id) {
		deleteRecord(Answer.class, id);
	}

	@Override
	public Answer findById(Integer id) {
		Answer wantedAnswer = getEntityManager().find(Answer.class, id);
		closeEntityManager();
		return wantedAnswer;
	}

	@Override
	public List<Answer> findAll() {
		List<Answer> answers = getEntityManager().
			createQuery("FROM Answer a", Answer.class).getResultList();
		closeEntityManager();
		return answers;
	}

}
