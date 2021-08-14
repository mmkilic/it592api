package edu.sabanciuniv.it592api.repository;

import java.util.List;

public interface IRepository<T> {
	
	public boolean add(T t);
	public boolean delete(int id);
	public List<T> findAll();
	public T findById(int id);
	public boolean update(T t);
}
