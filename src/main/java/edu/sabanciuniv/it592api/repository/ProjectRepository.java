package edu.sabanciuniv.it592api.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.sabanciuniv.it592api.entity.Project;

@Repository
public class ProjectRepository implements IRepository<Project>{
	
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	@Transactional
	public boolean delete(int prjId) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.delete(findById(prjId));
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public List<Project> findAll() {
		/*
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Project> theQuery = currentSession.createQuery("from Project", Project.class);
		return theQuery.getResultList();
		*/
		return entityManager.createQuery("Select p from Project p", Project.class).getResultList();
	}
	@Override
	public Project findById(int id) {
		return entityManager.find(Project.class, id);
	}
	public Project findByProjectNumber(int prjNbrId) {
		TypedQuery<Project> query = entityManager.createQuery("Select p from Project p where p.projectNumber.id=?1", Project.class);
		return query.setParameter(1, prjNbrId).getResultList().get(0);
	}
	public List<Project> findByCreateYear(int year) {
		TypedQuery<Project> query = entityManager.createQuery("Select p from Project p where p.createdDate>=?1"
				+ " and p.createdDate<?2", Project.class);
		query.setParameter(1, LocalDate.of(year, 01, 01));
		query.setParameter(2, LocalDate.of(++year, 01, 01));
		return query.getResultList();
	}
	public List<Project> findByUser(int userId) {
		try {
			TypedQuery<Project> query = entityManager.createQuery("Select p from Project p where "
					+ "p.gaElectDesigner.id=?1 or p.gaMechDesigner.id=?1 or "
					+ "p.bomElectDesigner.id=?1 or p.bomMechDesigner.id=?1", Project.class);
			return query.setParameter(1, userId).getResultList();
		} catch (Exception e) {
			return new ArrayList<Project>();
		}
	}
	
	@Override
	@Transactional
	public boolean save(Project prj) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.save(prj);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	@Transactional
	public boolean update(Project prj) {
		if(prj.getId() == 0)
			return false;
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.update(prj);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
