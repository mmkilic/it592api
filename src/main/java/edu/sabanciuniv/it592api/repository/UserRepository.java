package edu.sabanciuniv.it592api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PreRemove;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.sabanciuniv.it592api.entity.User;
import edu.sabanciuniv.it592api.utility.HashGenerator;

@Repository
public class UserRepository implements IRepository<User>{
	
	@Autowired
	private EntityManager entityManager;
	
	
	public User userLogin(String companyId, String password) {
		password = HashGenerator.hash(password);
		TypedQuery<User> query = entityManager.createQuery("Select u from User u where u.companyId=?1 "
									+ "and u.password=?2", User.class);
		query.setParameter(1, companyId.toUpperCase());
		query.setParameter(2, password);
		return query.getResultList().get(0);
	}
	
	
	@Override
	@Transactional
	public boolean delete(int userId) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			User u = removeUsers(userId);
			currentSession.remove(u);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	@PreRemove
	private User removeUsers(int userId) {
		User user = findById(userId);
		user.getSubordinates().forEach(u -> u.setManager(null));
		user.getProjectBomElect().forEach(p -> p.setBomElectDesigner(null));
		user.getProjectBomMech().forEach(p -> p.setBomMechDesigner(null));
		user.getProjectCreator().forEach(p -> p.setCreator(null));
		user.getProjectInfo().forEach(pi -> pi.setProjectManger(null));
		user.getProjectsGaElect().forEach(p -> p.setGaElectDesigner(null));
		user.getProjectsGaMech().forEach(p -> p.setGaMechDesigner(null));
		return user;
	}
	
	@Override
	public List<User> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.createQuery("Select u from User u", User.class).getResultList();
	}
	@Override
	public User findById(int id) {
		return entityManager.find(User.class, id);
	}
	public List<User> findAllManager() {
		TypedQuery<User> query = entityManager.createQuery("Select u from User u where u.role='MANAGER'", User.class);
		return query.getResultList();
	}
	public List<User> findAllPm() {
		TypedQuery<User> query = entityManager.createQuery("Select u from User u where "
				+ "u.role='OTHER' and u.department='PROJECT'", User.class);
		return query.getResultList();
	}
	public List<User> findAllElectric() {
		TypedQuery<User> query = entityManager.createQuery("Select u from User u where u.role='ELECTRIC'", User.class);
		return query.getResultList();
	}
	public List<User> findAllMechanic() {
		TypedQuery<User> query = entityManager.createQuery("Select u from User u where u.role='MECHANIC'", User.class);
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public boolean save(User user) {
		try {
			user.setPassword(HashGenerator.hash(user.getPassword()));
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.save(user);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	@Transactional
	public boolean update(User user) {
		if(user.getId() == 0)
			return false;
		try {
			user.setPassword(HashGenerator.hash(user.getPassword()));
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.update(user);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
