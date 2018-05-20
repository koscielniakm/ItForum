package forum.model.dao;

import java.util.List;

import forum.model.entities.User;

public class DAOUser extends AbstractDAO implements DAO<User> {

	@Override
	public void create(User user) {
		createRecord(user);
	}

	@Override
	public void update(User user) {
		updateRecord(user);
	}

	@Override
	public void delete(Integer id) {
		deleteRecord(User.class, id);
	}

	@Override
	public User findById(Integer id) {
		User wantedUser = getEntityManager().find(User.class, id);
		closeEntityManager();
		return wantedUser;
	}

	@Override
	public List<User> findAll() {
		List<User> users = getEntityManager().
				createQuery("FROM User u", User.class).getResultList();
		closeEntityManager();
		return users;
	}

}
