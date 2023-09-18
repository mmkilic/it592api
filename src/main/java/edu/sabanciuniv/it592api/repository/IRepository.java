package edu.sabanciuniv.it592api.repository;

import java.util.List;

public interface IRepository<T> {
	
	public boolean delete(int id);
	public List<T> findAll();
	public T findById(int id);
	public boolean save(T t);
	public boolean update(T t);
}
