package edu.sabanciuniv.it592api.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.sabanciuniv.it592api.entity.Project;
import edu.sabanciuniv.it592api.entity.ProjectNumber;
import edu.sabanciuniv.it592api.entity.User;

@Repository
public class ProjectRepository implements IProjectRepository{
	
	@Autowired
	private EntityManager entityManager;
	
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
	
	@Override
	public Project findByNumber(ProjectNumber prjNumber) {
		TypedQuery<Project> query = entityManager.createQuery("Select p from Project p where p.projectNumber=?1", Project.class);
		return query.setParameter(1, prjNumber).getResultList().get(0);
	}
	
	@Override
	public List<Project> findByUser(User user) {
		List<Project> prjs = new ArrayList<Project>();
		
		prjs.addAll(findByProjectUser(user));
		prjs.addAll(findByController(user));
		
		return prjs;
	}
	
	@Override
	public List<Project> findByController(User user) {
		TypedQuery<Project> query = entityManager.createQuery("Select p from Project p where "
																+ "p.gaElectDesigner=?1 or p.gaMechDesigner=?1 or"
																+ "p.bomElectDesigner=?1 or p.bomWindingDesigner=?1 or"
																+ "p.bomMechDesigner=?1 or", Project.class);
		return query.setParameter(1, user).getResultList();
	}
	
	@Override
	public List<Project> findByProjectUser(User user) {
		TypedQuery<Project> query = entityManager.createQuery("Select p from Project p where "
																+ "p.gaControlerDesigner=?1 or "
																+ "p.bomControlDesigner=?1", Project.class);
		return query.setParameter(1, user).getResultList();
	}
}
