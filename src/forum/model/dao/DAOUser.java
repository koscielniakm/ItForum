package forum.model.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

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
	
	public User findByLoginAndPassword
		(String loginOrEmail, String password) {
		String queryString = "SELECT u FROM User u"
			+ " WHERE u.password = :password AND u.login = :loginEmail"
			+ " OR u.password = :password AND u.email = :loginEmail";
		Query query = getEntityManager().
			createQuery(queryString, User.class);
		query.setParameter("loginEmail", loginOrEmail);
		query.setParameter("password", password);
		try {
			User loggedUser = (User) query.getSingleResult();
			closeEntityManager();
			return loggedUser;	
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public boolean checkUserExistence(String login, String email) {
	    Query query = getEntityManager().
	    	createQuery("SELECT COUNT(u) FROM User u WHERE login = :login OR email = :email");
	    query.setParameter("login", login);
	    query.setParameter("email", email);
	    long userNumber = (long) query.getSingleResult();
	    closeEntityManager();
	    if (userNumber == 0) return false;
	    else return true;
	}
	
}
