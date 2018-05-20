package forum.model.dao;

import java.util.List;

public interface DAO<T> {
	public void create(T obj);
	public void update(T obj);
	public void delete(Integer id);
	public T findById(Integer id);
	public List<T> findAll();
}
