package edu.sabanciuniv.it592api.repository;

import java.util.List;

import javax.persistence.EntityManager;

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
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Project findByNumber(ProjectNumber prjNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Project> findByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}
