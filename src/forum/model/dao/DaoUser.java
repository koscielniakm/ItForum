package forum.model.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import forum.model.entities.UserEntity;

public class DaoUser extends AbstractDao implements Dao<UserEntity> {

	@Override
	public void create(UserEntity user) {
		createRecord(user);
	}

	@Override
	public void update(UserEntity user) {
		updateRecord(user);
	}

	@Override
	public void delete(Integer id) {
		deleteRecord(UserEntity.class, id);
	}

	@Override
	public UserEntity findById(Integer id) {
		UserEntity wantedUser = getEntityManager().find(UserEntity.class, id);
		closeEntityManager();
		return wantedUser;
	}

	@Override
	public List<UserEntity> findAll() {
		List<UserEntity> users = getEntityManager().
				createQuery("FROM User u", UserEntity.class).getResultList();
		closeEntityManager();
		return users;
	}
	
	public UserEntity findByLoginAndPassword
		(String loginOrEmail, String password) {
		String queryString = "SELECT u FROM User u"
			+ " WHERE u.password = :password AND u.login = :loginEmail"
			+ " OR u.password = :password AND u.email = :loginEmail";
		Query query = getEntityManager().
			createQuery(queryString, UserEntity.class);
		query.setParameter("loginEmail", loginOrEmail);
		query.setParameter("password", password);
		try {
			UserEntity loggedUser = (UserEntity) query.getSingleResult();
			closeEntityManager();
			return loggedUser;	
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public boolean checkUserExistence(String login, String email) {
	    Query query = getEntityManager().
	    	createQuery("SELECT COUNT(u) FROM UserEntity u WHERE login = :login OR email = :email");
	    query.setParameter("login", login);
	    query.setParameter("email", email);
	    long userNumber = (long) query.getSingleResult();
	    closeEntityManager();
	    if (userNumber == 0) return false;
	    else return true;
	}
	
}
