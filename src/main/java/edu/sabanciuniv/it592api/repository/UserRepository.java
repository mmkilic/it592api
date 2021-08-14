package edu.sabanciuniv.it592api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.sabanciuniv.it592api.entity.User;

@Repository
public class UserRepository implements IRepository<User>{
	
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	@Transactional
	public boolean add(User user) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.save(user);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	@Transactional
	public boolean delete(int userId) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			Query q = currentSession.createQuery("delete from User u where u.id=:id");
			q.setParameter("id", userId);
			q.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<User> findAll() {
		return entityManager.createQuery("Select u from User u", User.class).getResultList();
	}
	@Override
	public User findById(int id) {
		return entityManager.find(User.class, id);
	}
	public User findBySesa(String sesa) {
		TypedQuery<User> query = entityManager.createQuery("Select u from User u where u.sesa=?1", User.class);
		return query.setParameter(1, sesa).getResultList().get(0);
	}
	
	@Override
	@Transactional
	public boolean update(User user) {
		if(user.getId() == 0)
			return false;
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.update(user);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
