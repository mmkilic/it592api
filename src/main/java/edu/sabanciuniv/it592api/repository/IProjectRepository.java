package edu.sabanciuniv.it592api.repository;

import java.util.List;

import edu.sabanciuniv.it592api.entity.Project;
import edu.sabanciuniv.it592api.entity.ProjectNumber;
import edu.sabanciuniv.it592api.entity.User;

public interface IProjectRepository {
	
	public List<Project> findAll();
	public Project findById(int id);
	public Project findByNumber(ProjectNumber prjNumber);
	public List<Project> findByUser(User user);
	
}
