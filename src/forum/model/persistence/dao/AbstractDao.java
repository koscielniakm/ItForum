package forum.model.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import forum.model.persistence.entities.IdEntity;

public abstract class AbstractDao {
	
	private static final String PERSISTENCE_NAME = "ForumPersistenceUnit";
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	/* This method starts also entityManagerFactory */
	protected static EntityManager getEntityManager() {
		entityManager = getEntityManagerFactory().createEntityManager();
		return entityManager;
	}
	private static EntityManagerFactory getEntityManagerFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
		return entityManagerFactory;
	}
	
	/* This method closes also entityManagerFactory */
	protected static void closeEntityManager() {
		if (entityManager != null)
			entityManager.close();
		if (entityManagerFactory != null)
			entityManagerFactory.close();
	}
	
	protected static void createRecord(IdEntity entity) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction currentTransation = entityManager.getTransaction();
		currentTransation.begin();
		entity.setId(null);
		entityManager.persist(entity);
		currentTransation.commit();
		closeEntityManager();
	}
	protected static void updateRecord(IdEntity entity) {
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
	protected static <T extends IdEntity> void deleteRecord(Class<T> entityClass, Integer id) {
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
