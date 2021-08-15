package edu.sabanciuniv.it592api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.sabanciuniv.it592api.entity.ProjectNumber;

@Repository
public class ProjectNumberRepository implements IRepository<ProjectNumber>{
	
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	@Transactional
	public boolean delete(int prjNbrId) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			Query q = currentSession.createQuery("delete from User u where u.id=:id");
			q.setParameter("id", prjNbrId);
			q.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<ProjectNumber> findAll() {
		return entityManager.createQuery("Select pn from ProjectNumber pn", ProjectNumber.class).getResultList();
	}
	@Override
	public ProjectNumber findById(int id) {
		return entityManager.find(ProjectNumber.class, id);
	}
	public List<ProjectNumber> findByMainProject(int mainPrjId) {
		TypedQuery<ProjectNumber> query = entityManager.createQuery("SELECT pn from ProjectNumber pn where pn.mainProject.id=?1", ProjectNumber.class);
		return query.setParameter(1, mainPrjId).getResultList();
	}
	
	@Override
	@Transactional
	public boolean save(ProjectNumber prjNbr) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.save(prjNbr);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	@Transactional
	public boolean update(ProjectNumber prjNbr) {
		if(prjNbr.getId() == 0)
			return false;
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.update(prjNbr);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
