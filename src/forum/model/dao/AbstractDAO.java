package forum.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import forum.model.entities.DatabaseEntity;

public abstract class AbstractDAO {
	
	private static final String PERSISTENCE_NAME = "ForumPersistenceUnit";
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	/* This method starts also entityManagerFactory */
	protected EntityManager getEntityManager() {
		entityManager = getEntityManagerFactory().createEntityManager();
		return entityManager;
	}
	private EntityManagerFactory getEntityManagerFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
		return entityManagerFactory;
	}
	
	/* This method closes also entityManagerFactory */
	protected void closeEntityManager() {
		if (entityManager != null)
			entityManager.close();
		if (entityManagerFactory != null)
			entityManagerFactory.close();
	}
	
	protected void createRecord(DatabaseEntity entity) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction currentTransation = entityManager.getTransaction();
		currentTransation.begin();
		entity.setId(null);
		entityManager.persist(entity);
		currentTransation.commit();
		closeEntityManager();
	}
	protected void updateRecord(DatabaseEntity entity) {
		if (entity.getId() > 0) {
			EntityManager entityManager = getEntityManager();
			try {
				EntityTransaction currentTransation = entityManager.getTransaction();
				currentTransation.begin();
				entityManager.merge(entity);
				currentTransation.commit();
			} catch (Exception exception) {
				exception.printStackTrace();
			} finally {
				closeEntityManager();
			}
		}
	}
	protected <T extends DatabaseEntity> void deleteRecord(Class<T> entityClass, Integer id) {
		if (id > 0) {
			EntityManager entityManager = getEntityManager();
			try {
				EntityTransaction currentTransation = entityManager.getTransaction();
				currentTransation.begin();
				Query query = entityManager
					.createQuery("DELETE " + entityClass.getName() + " e where e.id = :id");
		        query.setParameter("id", id);
		        query.executeUpdate();
				currentTransation.commit();
			} catch (Exception exception) {
				exception.printStackTrace();
			} finally {
				closeEntityManager();
			}
		}
	}
}
