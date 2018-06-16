package forum.model.persistence.dao;

import java.util.List;

public interface Dao<T> {
	public void create(T obj);
	public void update(T obj);
	public void delete(Integer id);
	public T findById(Integer id);
	public List<T> findAll();
}
