package dao;

import java.util.List;

public abstract class EntityDAO<T> {
	
	public abstract List<T> getAll();	
	public abstract T get(long id);
	public abstract void insert(T t) throws Exception;
	public abstract void update(T t) throws Exception;
	public abstract void delete(T t) throws Exception;
}
