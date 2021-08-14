package edu.sabanciuniv.it592api.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.sabanciuniv.it592api.entity.Project;
import edu.sabanciuniv.it592api.entity.ProjectNumber;
import edu.sabanciuniv.it592api.entity.User;

@Repository
public class ProjectRepository implements IRepository<Project>{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public boolean add(Project prj) {
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.save(prj);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	@Override
	public boolean delete(int prjId) {
		// TODO Auto-generated method stub
		return false;
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
	
	public Project findByNumber(ProjectNumber prjNumber) {
		TypedQuery<Project> query = entityManager.createQuery("Select p from Project p where p.projectNumber=?1", Project.class);
		return query.setParameter(1, prjNumber).getResultList().get(0);
	}
	
	public List<Project> findByUser(User user) {
		List<Project> prjs = new ArrayList<Project>();
		
		prjs.addAll(findByProjectUser(user));
		prjs.addAll(findByController(user));
		
		return prjs;
	}
	
	public List<Project> findByController(User user) {
		TypedQuery<Project> query = entityManager.createQuery("Select p from Project p where "
																+ "p.gaElectDesigner=?1 or p.gaMechDesigner=?1 or"
																+ "p.bomElectDesigner=?1 or p.bomWindingDesigner=?1 or"
																+ "p.bomMechDesigner=?1 or", Project.class);
		return query.setParameter(1, user).getResultList();
	}
	
	public List<Project> findByProjectUser(User user) {
		TypedQuery<Project> query = entityManager.createQuery("Select p from Project p where "
																+ "p.gaControlerDesigner=?1 or "
																+ "p.bomControlDesigner=?1", Project.class);
		return query.setParameter(1, user).getResultList();
	}
	@Override
	public boolean update(Project prj) {
		// TODO Auto-generated method stub
		return false;
	}
}
