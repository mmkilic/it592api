package edu.sabanciuniv.it592api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sabanciuniv.it592api.entity.Project;
import edu.sabanciuniv.it592api.entity.ProjectNumber;
import edu.sabanciuniv.it592api.entity.User;
import edu.sabanciuniv.it592api.repository.ProjectRepository;

@Service
public class ProjectService implements IProjectService{
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Override
	public List<Project> findAll(){
		return projectRepo.findAll();
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
